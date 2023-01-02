package com.snakat.cache;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public interface IListCache<T extends IEntity> extends ICache {
    @NonNull
    List<T> get();

    @Nullable
    T getById(int id);

    void update(@NonNull T... entities);

    void delete(@NonNull T... entities);
}
