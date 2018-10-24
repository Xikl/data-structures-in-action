package com.ximo.datastructuresinaction.queue;

/**
 * @author Ximo
 * @date 2018/10/23 23:26
 */
public class LoopQueue<E> implements Queue<E> {

    /**
     * 队列中的元素
     */
    private E[] data;

    /**
     * 头位置
     */
    private int front;

    /**
     * 尾位置
     */
    private int tail;

    /**
     * 队列的大小
     */
    private int size;

    /**
     * 由于循环队列中要有意识的浪费一个位置 所以我们需要 将capacity + 1再进行赋值
     *
     * @param capacity 容量
     */
    @SuppressWarnings("unchecked")
    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
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
        // 判断是不是满的
        if (isFull()) {
            resize(getCapacity() * 2);
        }
        data[tail] = element;
        tail = (tail + 1) % data.length;
        size++;
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        // 另外的一种遍历方式 仔细思考
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        }
        E result = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        // 是否应该扩容
        if ((size == getCapacity() / 4) && (getCapacity() / 2 != 0)) {
            resize(getCapacity() / 2);
        }
        return result;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        }
        return data[front];
    }


    public boolean isFull() {
        return (tail + 1) % data.length == front;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Queue: size = %d, capacity = %d\n", size, getCapacity()));
        result.append("front [");
        // 让i等于front 每次都加1 然后 对数组的最大长度进行扩容
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            result.append(data[i]);
            if ((i + 1) % data.length != tail) {
                result.append(", ");
            }
        }
        result.append("] tail");
        return result.toString();
    }
}
