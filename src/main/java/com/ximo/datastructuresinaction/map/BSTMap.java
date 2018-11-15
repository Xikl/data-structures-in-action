package com.ximo.datastructuresinaction.map;

import java.util.Optional;

/**
 * @author Ximo
 * @date 2018/11/15 22:40
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private Node root;

    private int size;

    public BSTMap() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    /**
     * 添加一个新的元素 key相等 则覆盖原值
     *
     * @param node 节点信息
     * @param key key 键值
     * @param value value
     * @return 头结点
     */
    private Node add(Node node, K key, V value) {
        if (root == null) {
            size++;
            return new Node(key, value);
        }

        int compareResult = key.compareTo(node.key);
        if (compareResult < 0) {
            node.left = add(node.left, key, value);
        } else if (compareResult > 0) {
            node.right = add(node.right, key, value);
        } else {
            // 覆盖原值
            node.value = value;
        }

        return node;
    }

    @Override
    public V remove(K key) {
        Optional<Node> nodeOpt = getNode(root, key);

        if (nodeOpt.isPresent()) {
            root = remove(root, key);
            return nodeOpt.get().value;
        }
        return null;
    }

    /**
     * 删除节点
     *
     * @param node
     * @param key
     * @return
     */
    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }
        int compareResult = key.compareTo(node.key);
        if (compareResult < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (compareResult > 0) {
            node.right = remove(node.right, key);
            return node;
        } else { // 相等的时候
            // 左子树为空
            if (node.left == null) {
                return getAndRemoveRight(node);
            }

            // 右子树为空
            if (node.right == null) {
                return getAndRemoveLeft(node);
            }

            // 找到后继（替换者）
            Node successor = minmum(node.right);
            // 删除该节点的信息
            successor.right = removeMin(node.right);
            successor.left = node.left;

            // help gc
            node.left = node.right = null;
            return successor;
        }
    }

    private Node minmum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minmum(node.left);
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            return getAndRemoveRight(node);
        }

        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 移除右子树
     *
     * @param node 一棵树
     * @return 返回被删除的右子树
     */
    private Node getAndRemoveRight(Node node) {
        Node rightNode = node.right;
        node.right = null;
        size--;
        return rightNode;
    }

    /**
     * 移除左子树
     *
     * @param node 一棵树
     * @return 返回被删除的左子树
     */
    private Node getAndRemoveLeft(Node node) {
        Node leftNode = node.left;
        node.left = null;
        size--;
        return leftNode;
    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key).isPresent();
    }

    @Override
    public V get(K key) {
        return getNode(root, key).orElseGet(Node::new).value;
    }

    /**
     * 获得key对应的节点信息
     *
     * @param node 头结点信息
     * @param key key对应的节点信息
     * @return {@link Optional}包装的信息
     */
    private Optional<Node> getNode(Node node, K key) {
        if (node == null) {
            return Optional.empty();
        }

        int compareResult = key.compareTo(node.key);
        if (compareResult < 0) {
            return getNode(node.left, key);
        } else if (compareResult > 0) {
            return getNode(node.right, key);
        } else {
            return Optional.of(node);
        }
    }

    @Override
    public void set(K key, V newValue) {
        Optional<Node> nodeOpt = getNode(root, key);
        if (!nodeOpt.isPresent()) {
            throw new IllegalArgumentException(key + "is not exist");
        } else {
            nodeOpt.get().value = newValue;
        }
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

        Node left, right;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        Node() {
        }
    }
}
