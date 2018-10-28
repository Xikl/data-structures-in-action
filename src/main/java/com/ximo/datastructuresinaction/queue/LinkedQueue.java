package com.ximo.datastructuresinaction.queue;


/**
 * @author Ximo
 * @date 2018/10/28 19:29
 */
public class LinkedQueue<E> implements Queue<E>{

    /** 头部信息 */
    private Node head;
    /** 尾部信息 */
    private Node tail;
    /** 大小 */
    private int size;

    public LinkedQueue() {
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E element) {
        // 为空说明 头和尾在一个位置
        if (tail == null) {
            tail = new Node(element);
            head = tail;
        } else {
            // 不为空 则搞定
            tail.next = new Node(element);
            // 尾节点右移一位
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty. Can not Queue");
        }

        Node retNode = head;
        head = head.next;
        retNode.next = null;
        if (head == null) {
            tail = null;
        }
        size--;
        return retNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");
        for (Node cur = head; cur != null; cur = cur.next) {
            res.append(cur + "->");
        }
        res.append("NULL tail");
        return res.toString();
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
