package com.ximo.datastructuresinaction.bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
     * 非递归前序遍历
     * 根左右
     * 深度优先遍历
     */
    public void inOrderNR() {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    /**
     * 层序遍历
     * 广度优先遍历
     */
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.e);
            if (cur.left != null) {
                queue.add(root.left);
            }
            if (cur.right != null) {
                queue.add(root.right);
            }
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

    /**
     * 中序遍历
     *  遍历出来的结果就是排序后的结果
     *
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 中序遍历
     *
     * @param node 节点信息
     */
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /** 后序遍历 */
    public void postOrder() {
        postOrder(root);
    }

    /** 后续遍历 */
    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    /** 查找最小元素 */
    public E minmum() {
        if (size == 0) {
            throw new IllegalArgumentException(" BST is empty");
        }
        return minmum(root).e;
    }

    private Node minmum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minmum(node.left);
    }

    /** 查找最大值 */
    public E maxmum() {
        if (size == 0) {
            throw new IllegalArgumentException(" BST is empty");
        }
        return maxmum(root).e;
    }

    public Node maxmum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maxmum(node.right);
    }

    public E remomveMin() {
        // 找到最小的元素
        E ret = minmum();
        // 重新赋值根节点的信息 删除最小值的元素
        root = removeMin(root);
        return ret;
    }

    /**
     * 删除该树中的最小元素
     *
     * @param node 树的根
     * @return 删除最小值的 树的根节点
     */
    public Node removeMin(Node node) {
        // 左子树为空
        if (node.left == null) {
            return getAndRemoveRight(node);
        }

        // 不为空的时候
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 删除树中的最大元素
     *
     * @return 被删除的最大元素
     */
    public E remomveMax() {
        // 找到最大的元素
        E ret = maxmum();
        // 重新赋值根节点的信息 删除最小值的元素
        root = removeMax(root);
        return ret;
    }

    /**
     * 删除该树中的最小元素
     *
     * @param node 树的根
     * @return 删除最小值的 树的根节点
     */
    public Node removeMax(Node node) {
        // 右子树为空
        if (node.right == null) {
            return getAndRemoveLeft(node);
        }

        // 不为空的时候
        node.right = removeMax(node.right);
        return node;
    }

    public void remove(E element) {
        root = remove(root, element);
    }

    private Node remove(Node node, E element) {
        if (node == null) {
            return null;
        }
        int compareResult = element.compareTo(node.e);
        if (compareResult < 0) {
            node.left = remove(node.left, element);
            return node;
        } else if (compareResult > 0) {
            node.right = remove(node.right, element);
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
            successor.right = removeMin(node.right);
            successor.left = node.left;

            // help gc
            node.left = node.right = null;
            return successor;
        }
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
