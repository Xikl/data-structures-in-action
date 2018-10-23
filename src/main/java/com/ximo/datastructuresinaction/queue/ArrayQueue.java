package com.ximo.datastructuresinaction.queue;

import com.ximo.datastructuresinaction.array.Array;

/**
 * @author Ximo
 * @date 2018/10/23 22:13
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue(int capcity) {
        this.array = new Array<>(capcity);
    }

    public ArrayQueue() {
        this.array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public void enqueue(E element) {
        array.addLast(element);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Queue: ");
        result.append("front [");
        for (int i = 0, size = array.getSize(); i < size; i++) {
            result.append(array.get(i));
            if (i != size - 1) {
                result.append(",");
            }
        }
        result.append("] tail");
        return result.toString();
    }
}
