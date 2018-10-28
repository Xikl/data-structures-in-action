package com.ximo.datastructuresinaction.list;

/**
 * 链表
 *
 * @author Ximo
 * @date 2018/10/28 14:23
 */
public class LinkList<E> {

    /** 头部元素 */
    private Node head;

    /**  */
    private int size;

    public LinkList() {
        this.head = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表的头部进行添加
     *
     * @param element 被添加的元素
     */
    public void addFirst(E element) {
//        Node node = new Node(element);
//        node.next = head;
//        head = node;

        // 直接利用构造函数进行添加
        head = new Node(element, head);
        // 大小加1
        size++;
    }

    /**
     * 在制定位置添加元素
     *
     * @param index 位置 从0开始
     * @param element 被添加的元素
     */
    public void add(int index, E element) {
        if (index < 0) {
            throw new IllegalArgumentException("Add failed, Illegal index.");
        }
        if (index == 0) {
            addFirst(element);
        } else {
            // 找到需要插入的位置
            Node prev = head;

            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            // 同样和之前addFirst中的操作一致
            prev.next = new Node(element, prev.next);
            size++;
        }
    }

    public void addLast(E e) {
        add(size, e);
    }


    /** 内部存储节点类 */
    private class Node {

        public E e;

        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }







}
