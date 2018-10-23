package com.ximo.datastructuresinaction.queue;

/**
 * @author Ximo
 * @date 2018/10/23 22:10
 */
public interface Queue<E> {

    /** 获得大小 */
    int getSize();

    /**  是否为空 */
    boolean isEmpty();

    /** 入队列 */
    void enqueue(E element);

    /** 入队列 */
    E dequeue();

    /** 获得第一个元素 */
    E getFront();


}
