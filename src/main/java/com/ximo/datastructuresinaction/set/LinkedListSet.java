package com.ximo.datastructuresinaction.set;

import com.ximo.datastructuresinaction.list.LinkedList;

/**
 * @author Ximo
 * @date 2018/11/12 21:50
 */
public class LinkedListSet<E> implements Set<E> {

    private LinkedList<E> linkedList;

    public LinkedListSet() {
        this.linkedList = new LinkedList<>();
    }

    @Override
    public void add(E e) {
        if (!linkedList.contains(e)) {
            linkedList.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        linkedList.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return linkedList.contains(e);
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}
