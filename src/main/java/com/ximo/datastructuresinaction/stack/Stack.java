package com.ximo.datastructuresinaction.stack;

/**
 * @author Ximo
 * @date 2018/10/23 0:01
 */
public interface Stack<E> {


    void push(E element);

    E pop();

    E peek();

    int getSize();

    boolean isEmpty();


}
