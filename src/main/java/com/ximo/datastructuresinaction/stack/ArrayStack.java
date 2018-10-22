package com.ximo.datastructuresinaction.stack;

import com.ximo.datastructuresinaction.array.Array;

/**
 * @author Ximo
 * @date 2018/10/23 0:02
 */
public class ArrayStack<E> implements Stack<E> {

    private Array<E> array;


    public ArrayStack(int capacity) {
        this.array = new Array<>(capacity);
    }

    public ArrayStack() {
        this.array = new Array<>();
    }

    @Override
    public void push(E element) {
        array.addLast(element);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
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
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Stack: ");
        result.append("[");
        for (int i = 0, size = array.getSize(); i < size; i++) {
            result.append(array.get(i));
            if (i != size - 1) {
                result.append(",");
            }
        }
        result.append("] top");
        return result.toString();
    }
}
