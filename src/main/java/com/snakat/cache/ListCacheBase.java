package com.snakat.cache;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class ListCacheBase<T extends IEntity> extends CacheBase implements IListCache<T> {
    private final List<T> mData = new ArrayList<>();
    private final HashMap<Integer, T> mHashMap = new HashMap<>();

    @Override
    @NonNull
    public List<T> get() {
        return mData;
    }

    @Override
    @Nullable
    public T getById(int id) {
        return mHashMap.get(id);
    }

    @Override
    public void update(@NonNull T... entities) {
        for (T entity: entities) {
            updateOne(entity);
        }
    }

    @Override
    public void delete(@NonNull T... entities) {
        for (T entity: entities) {
            deleteOne(entity);
        }
    }

    private void updateOne(@NonNull T entity) {
        int id = entity.getId();
        int size = mData.size();
        int i = 0;
        for (; i < size; i++) {
            if (mData.get(i).getId() == id) {
                mData.set(i, entity);
                break;
            }
        }
        if (i >= size) {
            mData.add(entity);
        }
        mHashMap.put(id, entity);
    }

    private void deleteOne(@NonNull T entity) {
        int id = entity.getId();
        int size = mData.size();
        for (int i = 0; i < size; i++) {
            if (mData.get(i).getId() == id) {
                mData.remove(i);
                break;
            }
        }
        mHashMap.remove(id);
    }
}
