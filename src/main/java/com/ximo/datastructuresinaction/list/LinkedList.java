package com.ximo.datastructuresinaction.list;

/**
 * 链表
 *
 * @author Ximo
 * @date 2018/10/28 14:23
 */
public class LinkedList<E> {

    /** 虚拟头部元素 */
    private Node dummyHead;

    /** 大小 */
    private int size;

    public LinkedList() {
        this.dummyHead = new Node(null, null);
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在制定位置添加元素
     *
     * @param index 位置 从0开始
     * @param element 被添加的元素
     */
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, Illegal index.");
        }
            // 找到需要插入的位置
        Node prev = dummyHead;

        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        // 同样和之前addFirst中的操作一致
        prev.next = new Node(element, prev.next);
        size++;
    }


    /**
     * 在链表的头部进行添加
     *
     * @param element 被添加的元素
     */
    public void addFirst(E element) {
        add(0, element);
    }

    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 获得指定位置的元素
     *
     * @param index 索引位置
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * 获得第一一个元素
     *
     * @return 第一个元素
     */
    public E getFirst() {
        return get(0);
    }

    /** 获得最后一个元素 */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 修改值
     *
     * @param index 索引位置
     * @param element 元素
     */
    public void set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = element;
    }

    /**
     * 是否包含元素
     *
     * @param element 被查找的元素信息
     * @return 是否包含
     */
    public boolean contains(E element) {
        Node cur = dummyHead.next;
//        for (int i = 0; i < size; i++) {
//            if (element.equals(cur.e)) {
//                return true;
//            } else {
//                cur = cur.next;
//            }
//        }
        while (cur != null) {
            if (cur.e.equals(element)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 删除元素
     *
     * @param index 索引位置
     * @return 被删除的元素
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal");
        }

        // 遍历到要删除的节点的前一位置
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        // 跳过节点信息
        Node retNode = prev.next;
        prev.next = retNode.next;
        // help gc
        retNode.next = null;
        return retNode.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E remveLast() {
        // size - 1
        return remove(size - 1);
    }

    /**
     * 删除指定元素
     * 只能删除一个
     *
     * @param e 被删除的元素
     */
    public void removeElement(E e) {
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.e.equals(e)) {
                break;
            }
            // 后移一位
            prev = prev.next;
        }
        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            // help gc
            delNode.next = null;
            size--;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        // 第一种遍历方法
//        Node cur = dummyHead.next;
//        while (cur != null) {
//            res.append(cur);
//            res.append(" -> ");
//            cur = cur.next;
//        }

        // 另一种遍历的方法
        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
            res.append(cur);
            res.append(" -> ");
        }
        res.append("null");
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
