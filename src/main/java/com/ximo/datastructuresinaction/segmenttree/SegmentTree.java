package com.ximo.datastructuresinaction.segmenttree;

import java.util.Arrays;
import java.util.function.BinaryOperator;

import static java.util.stream.Collectors.joining;

/**
 * @author xikl
 * @date 2019/1/7
 */
public class SegmentTree<E> {

    /** 内部维护一个数组来存储数据 */
    private E[] data;

    /** 内部维护一个树 */
    private E[] tree;

    private BinaryOperator<E> merger;

    @SuppressWarnings("unchecked")
    public SegmentTree(E[] arr, BinaryOperator<E> merger) {
        data = (E[]) Arrays.stream(arr).toArray();
        tree = (E[]) new Object[4 * data.length];
        // 要优先赋值
        this.merger = merger;
        // 对于根节点 右边界应该 length - 1 如八个元素 [0, 7]
        buildSegmentTree(0, 0, data.length - 1);
    }

    /**
     * 创建一个起始索引位置 在left 和 right 的一个 线段树 如 [0, data.length]
     * 闭区间
     *
     * @param treeIndex 树的起始索引
     * @param left 左边界
     * @param right 右边界
     */
    private void buildSegmentTree(int treeIndex, int left, int right) {
        if (left == right) {
            tree[treeIndex] = data[left];
            return;
        }

        int leftChildIndex = getLeftChildIndex(treeIndex);
        int rightChildIndex = getRightChildIndex(treeIndex);
        // 获得中间值 防止 内存溢出
        int mid = left + (right - left) / 2;
        buildSegmentTree(leftChildIndex, left, mid);
        buildSegmentTree(rightChildIndex, mid + 1, right);
        tree[treeIndex] = merger.apply(tree[leftChildIndex], tree[rightChildIndex]);
    }

    public E queryRangeClose(int queryLeft, int queryRight) {
        // 边界判断
        if (queryLeft < 0 || queryRight > getSize() - 1 ||
                queryLeft >= getSize() || queryRight >= getSize() || queryLeft > queryRight) {
            throw new IllegalArgumentException("illegal argument exception");
        }
        return queryRangeClose(0, 0, getSize() - 1, queryLeft, queryRight);
    }

    public E queryRangeClose(int treeIndex, int left, int right, int queryLeft, int queryRight) {
        // 边界条件
        if (left == queryLeft && right == queryRight) {
            return tree[treeIndex];
        }

        int mid = left + (right - left) / 2;
        int leftChildIndex = getLeftChildIndex(treeIndex);
        int rightChildIndex = getRightChildIndex(treeIndex);

        // 刚好全在 区间的 右边部分
        if (queryLeft >= mid + 1) {
            return queryRangeClose(rightChildIndex, mid + 1, right, queryLeft, queryRight);
            // 刚好在区间的左半部分
        } else if (queryRight <= mid) {
            return queryRangeClose(leftChildIndex, left, mid, queryLeft, queryRight);
        }

        // 左右都有 一部分 注意 queryRight 和 queryLeft的值已经变化
        E leftResult = queryRangeClose(leftChildIndex, left, mid, queryLeft, mid);
        E rightResult = queryRangeClose(rightChildIndex, mid + 1, right, mid + 1, queryRight);
        return merger.apply(leftResult, rightResult);
    }

    public E get(int index) {
        if (index < 0 || index > data.length) {
            throw new IndexOutOfBoundsException("index-out-of-bounds");
        }
        return data[index];
    }

    public int getSize() {
        return data.length;
    }

    public int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    public int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    @Override
    public String toString() {
        return Arrays.stream(tree).map(Object::toString).collect(joining("", "[", "]"));
    }
}
