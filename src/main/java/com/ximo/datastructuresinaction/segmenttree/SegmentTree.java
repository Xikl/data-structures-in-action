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
        buildSegmentTree(0, 0, data.length);
        this.merger = merger;
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
        return Arrays.stream(tree).map(Object::toString).collect(joining("", "", ""));
    }
}
