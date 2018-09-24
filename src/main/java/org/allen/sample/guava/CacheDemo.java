package org.allen.sample.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CacheDemo {

    private LoadingCache<String, Optional<String>> cache = CacheBuilder.newBuilder()
            .maximumSize(50)
            .refreshAfterWrite(24, TimeUnit.HOURS)
            .build(new CacheLoader<String, Optional<String>>() {
                @Override
                public Optional<String> load(String s) throws Exception {
                    return getFromLocal(s);
                }
            });

    private Optional<String> getFromLocal(String key) {
        System.out.println("get from local, key:" + key);
        if ("DD".equalsIgnoreCase(key)) return Optional.empty();
        return Optional.of(key + ", 123");
    }

    public static void main(String[] args) {
        CacheDemo demo = new CacheDemo();
        try {
            Optional<String> optional = demo.cache.get("hello");
            System.out.println(optional.isPresent());
            Optional<String> optional1 = demo.cache.get("hello");
            System.out.println(optional1.isPresent());
            Optional<String> optional2 = demo.cache.get("dd");
            System.out.println(optional2.isPresent());
            System.out.println("@@@@@@@");
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
