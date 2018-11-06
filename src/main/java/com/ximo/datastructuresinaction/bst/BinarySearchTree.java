package com.ximo.datastructuresinaction.bst;

/**
 * 二分搜索树
 *
 * @author Ximo
 * @date 2018/11/5 23:23
 */
public class BinarySearchTree<E extends Comparable<E>> {

    /** 根节点的信息 */
    private Node root;

    /** 树的大小 */
    private int size;

    public BinarySearchTree() {
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E element) {
        if (root == null) {
            root = new Node(element);
            size++;
        }
        add(root, element);
    }

    private void add(Node node, E element) {
        // 递归调用终止条件
        int compareResult = element.compareTo(node.e);
        if (compareResult < 0) {
            if (node.left == null) {
                node.left = new Node(element);
                size++;
            } else {
                add(node.left, element);
            }
        } else if (compareResult > 0){
            // 大于零的时候
            if (node.right == null) {
                node.right = new Node(element);
                size++;
            } else {
                add(node.right, element);
            }
        }
    }

    /**
     * 简单版本递归调用 需要更多的理解
     *
     * @param element 元素
     */
    public void addSimple(E element) {
        // 递归调用
        root = addSimple(root, element);
    }

    /**
     * 递归调用
     *
     * @param node 节点信息
     * @param element 元素
     * @return 添加后的元素
     */
    private Node addSimple(Node node, E element) {
        if (node == null) {
            size++;
            return new Node(element);
        }
        int compareResult = element.compareTo(node.e);
        // 比该节点要小 放到右边
        if (compareResult < 0) {
            node.left = addSimple(node.left, element);
        } else if (compareResult > 0) {
            node.right = addSimple(node.right, element);
        }
        return node;
    }


    /**
     * 是否包含
     *
     * @param element 元素
     * @return 是否包含
     */
    public boolean contains(E element) {
        return contains(root, element);
    }

    /**
     * 是否包含该元素
     *
     * @param node 该节点及其子树
     * @param element 要查找的元素
     * @return 是否包含
     */
    private boolean contains(Node node, E element) {
        if (node == null) {
            return false;
        }
        int compareResult = element.compareTo(node.e);
        if (compareResult == 0) {
            return true;
        } else if (compareResult < 0) {
            return contains(node.left, element);
        } else {// compareResult > 0 的情况
            return contains(node.right, element);
        }
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 前序遍历
     * 简单的
     *
     * @param node 节点信息
     */
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    /**
     * 生成树的结构字符串
     *
     * @param node 节点信息
     * @param depth 深度
     * @param res 结果字符串
     */
    private void generateBSTString(Node node, int depth, StringBuilder res) {
        // 每个节点都要打印深度信息
        res.append(generateDepthString(depth));
        if (node == null) {
            res.append("null\n");
            return;
        }
        res.append(node.e).append("\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

    private class Node {
        private E e;

        private Node left;

        private Node right;

        public Node(E e) {
            this.e = e;
        }
    }







}
