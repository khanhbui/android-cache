package com.snakat.cache;

import androidx.annotation.NonNull;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public final class CacheFactory {

    private final static HashMap<String, ICache> mCaches = new HashMap<>();

    public static void register(Class<? extends ICache> cacheClass) {
        try {
            String name = getCacheName(cacheClass);
            ICache cache = getCacheInstance(cacheClass);
            mCaches.put(name, cache);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @NonNull
    public static ICache get(Class<? extends ICache> cacheClass) {
        ICache cache = null;
        try {
            String name = getCacheName(cacheClass);
            cache = mCaches.get(name);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        assert cache != null;
        return cache;
    }

    private static String getCacheName(@NonNull Class<? extends ICache> cacheClass) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return (String) cacheClass.getMethod("getCacheName").invoke(null);
    }

    @NonNull
    private static ICache getCacheInstance(@NonNull Class<? extends ICache> cacheClass) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        return cacheClass.getConstructor().newInstance();
    }
}
