package com.ximo.datastructuresinaction.set;

/**
 * @author Ximo
 * @date 2018/11/12 21:27
 */
public interface Set<E> {

    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();


}
