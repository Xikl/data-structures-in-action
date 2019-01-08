package com.ximo.datastructuresinaction.list;

/**
 * 双向链表
 *
 * @author Ximo
 * @date 2018/11/4 16:35
 */
public class DoubleLinkedList<E> {

    /** 虚拟头结点 */
    private Node<E> dummyHead;

    /** 链表的大小 */
    private int size;

    public DoubleLinkedList() {
        dummyHead = new Node<>(null, null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在指定位置添加元素
     *
     * @param index 索引位置
     * @param element 元素
     */
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("illegal index");
        }
        // 找到需要插入的位置
        Node<E> prev = dummyHead;

        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node<E> newNode = new Node<>(prev, element, prev.next);
        if (prev.next != null) {
            prev.next.prev = newNode;
        }
        prev.next = newNode;
        size++;
    }

    public void addFirst(E element) {
        add(0, element);
    }

    public void addLast(E element) {
        add(size, element);
    }


    /**
     * 获得索引的位置上的值
     *
     * @param index 索引位置
     * @return 索引位置的值
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("illegal index");
        }

        // 虚拟头结点的后一位开始遍历
        Node<E> cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        return cur.value;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    /**
     * 修改其中的值
     * todo
     * @param index 所因为位置
     * @param element 元素
     */
    public void set(int index, E element) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("illegal index");
        }


    }


    private class Node<E> {
        /** 元素的值  */
        private E value;

        /** 元素的前一个值 */
        private Node<E> prev;

        /** 元素的后一个值 */
        private Node<E> next;

        public Node(Node<E> prev, E value, Node<E> next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }
}
