package com.ximo.datastructuresinaction.map;

import java.util.Optional;

/**
 * @author Ximo
 * @date 2018/11/14 23:32
 */
public class LinkedListMap<K, V> implements Map<K, V> {

    /**
     * 虚拟头节点
     */
    public Node dummyHead;
    /**
     * 大小
     */
    private int size;

    public LinkedListMap() {
        this.dummyHead = new Node();
        size = 0;
    }

    /**
     * 传入一个key 获得这个节点
     *
     * @param key key 健
     * @return 这个健对应的节点信息
     */
    private Optional<Node> getNode(K key) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.key.equals(key)) {
                return Optional.of(cur);
            }
            cur = cur.next;
        }
        return Optional.empty();
    }

    /**
     * 添加 重复的元素 直接进行覆盖
     *
     * @param key   key
     * @param value value
     */
    @Override
    public void add(K key, V value) {
        Optional<Node> nodeOpt = getNode(key);
        if (nodeOpt.isPresent()) {
            nodeOpt.get().value = value;
        } else {
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        }
    }

    /**
     * 删除节点的信息
     * 为空的时候 返回null
     *
     * @param key key
     * @return 被删除的元素
     */
    @Override
    public V remove(K key) {
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.key.equals(key)) {
                break;
            }
            // 接着找
            prev = prev.next;
        }
        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
            return delNode.value;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key).isPresent();
    }

    @Override
    public V get(K key) {
        return getNode(key).orElseGet(Node::new).value;
    }

    @Override
    public void set(K key, V newValue) {
        Optional<Node> nodeOpt = getNode(key);
        if (!nodeOpt.isPresent()) {
            throw new IllegalArgumentException("the key doesn't exist!");
        }
        nodeOpt.get().value = newValue;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }

    private class Node {
        K key;

        V value;

        Node next;

        Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        Node(K key) {
            this.key = key;
        }

        Node() {
        }

        @Override
        public String toString() {
            return key.toString() + ":" + value.toString();
        }
    }
}
