package com.snakat.cache;

import androidx.annotation.NonNull;

import kotlin.NotImplementedError;

abstract class CacheBase {

    @NonNull
    public static String getCacheName() {
        throw new NotImplementedError("Please add a static method, named 'getCacheName', to provide this cache name!");
    }
}
