package com.ximo.datastructuresinaction.map;

/**
 * @author Ximo
 * @date 2018/11/14 23:28
 */
public interface Map<K, V> {

    void add(K key, V value);

    V remove(K key);

    boolean contains(K key);

    V get(K key);

    void set(K key, V newValue);

    int getSize();

    boolean isEmpty();

}
