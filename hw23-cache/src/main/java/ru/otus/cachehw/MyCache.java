package ru.otus.cachehw;


import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

public class MyCache<K, V> implements HwCache<K, V> {
//Надо реализовать эти методы

    private final WeakHashMap<K, V> map = new WeakHashMap<>();

    private final List<HwListener<K, V>> listeners = new ArrayList<>();

    @Override
    public void put(K key, V value) {
        map.put(key, value);
        listeners.forEach(l -> l.notify(key, value, "PUT"));
    }

    @Override
    public void remove(K key) {
        map.remove(key);
        listeners.forEach(l -> l.notify(key, map.get(key), "REMOVE"));
    }

    @Override
    public V get(K key) {
        listeners.forEach(l -> l.notify(key, map.get(key), "GET"));
        return map.get(key);
    }

    @Override
    public void addListener(HwListener<K, V> listener) {
        listeners.add(listener);
    }

    @Override
    public void removeListener(HwListener<K, V> listener) {
        listeners.remove(listener);
    }
}
