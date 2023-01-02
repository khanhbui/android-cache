package com.snakat.cache;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public interface IOneCache<T> {
    @Nullable
    T get();

    void update(@NonNull T entity);

    void delete();
}
