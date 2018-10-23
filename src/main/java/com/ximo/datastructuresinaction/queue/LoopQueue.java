package com.ximo.datastructuresinaction.queue;

/**
 * @author Ximo
 * @date 2018/10/23 23:26
 */
public class LoopQueue<E> implements Queue<E>{

    /** 队列中的元素  */
    private E[] data;

    /** 头位置 */
    private int front;

    /** 尾位置 */
    private int tail;

    /** 队列的大小 */
    private int size;

    /**
     * 由于循环队列中要有意识的浪费一个位置 所以我们需要 将capacity + 1再进行赋值
     *
     * @param capacity 容量
     */
    @SuppressWarnings("unchecked")
    public LoopQueue(int capacity) {
        data = (E[])new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    /**
     * 循环队列只有在front == tail的条件时才满足为空的条件
     *
     * @return 是否为空
     */
    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E element) {

    }

    @Override
    public E dequeue() {
        return null;
    }

    @Override
    public E getFront() {
        return null;
    }
}
