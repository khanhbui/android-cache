package com.snakat.cache;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract class OneCacheBase<T extends IEntity> extends CacheBase implements IOneCache<T> {

    private T mData;

    @Override
    @Nullable
    public T get() {
        return mData;
    }

    @Override
    public void update(@NonNull T entity) {
        mData = entity;
    }

    @Override
    public void delete() {
        mData = null;
    }
}
