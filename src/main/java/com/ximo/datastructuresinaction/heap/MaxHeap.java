package com.ximo.datastructuresinaction.heap;

import com.ximo.datastructuresinaction.array.Array;

/**
 * 二叉堆的定义：
 * 1.是一颗完全二叉树
 * 2.大顶堆的父节点元素要比其左右孩子节点要大（小顶堆反之）
 *
 * 大顶堆
 * 当数组索引从1开，那么
 * parent = i / 2
 * leftChild = i * 2
 * rightChild = i * 2 + 1
 *
 * 当数组索引从0开始
 * parent = (i - 1) / 2
 * leftChild = i * 2 + 1
 * rightChild = i * 2 + 2
 *
 * @author xikl
 * @date 2019/1/3
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    /**
     * heapify:
     * 将任意数组变成一个堆
     * 1.主要思想是找到最后一个非叶子节点索引k（最后一个节点的父节点）
     * 2.然后进行下沉操作siftDown(k)
     *
     * 找到最后一个叶子节点，然后找到他的父亲节点
     * @param arr
     */
    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        // 找到最后一个叶子节点，然后找到他的父亲节点
        for (int cur = getParentIndex(arr.length - 1); cur >= 0; cur--) {
            siftDown(cur);
        }
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 获得父类的索引位置
     *
     *
     *
     * @param index 索引位置
     * @return 父亲索引
     */
    public int getParentIndex(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        }
        return (index - 1) / 2;
    }

    public int getLeftChildIndex(int index) {
        return index * 2 + 1;
    }

    public int getRightChildIndex(int index) {
        return index * 2 + 2;
    }

    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    public void siftUp(int index) {
        int parentIndex = getParentIndex(index);
        // 比较父亲与自己的大小
        while (index > 0 && data.get(parentIndex).compareTo(data.get(index)) < 0) {
            // 交换
            data.swap(index, parentIndex);
            index = parentIndex;
            parentIndex = getParentIndex(index);
        }
    }

    public E findMax() {
        return data.getFirst();
    }

    public E extractMax() {
        E ret = findMax();
        // 将堆中最大的元素和最小的元素交换位置
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        // 进行下沉操作
        siftDown(0);
        return ret;
    }

    public void siftDown(int index) {
        while (getLeftChildIndex(index) < data.getSize()) {
            int maxOnLeftAndRightValueIndex = getMaxOnLeftAndRightValueIndex(index);
            if (data.get(index).compareTo(data.get(maxOnLeftAndRightValueIndex)) >= 0) {
                break;
            }
            data.swap(index, maxOnLeftAndRightValueIndex);
            index = maxOnLeftAndRightValueIndex;
        }
    }

    public int getMaxOnLeftAndRightValueIndex(int index) {
        int leftChildIndex = getLeftChildIndex(index);
        // 其实也等于 leftChildIndex + 1
        int rightChildIndex = getRightChildIndex(index);

        boolean leftLessThanRight = rightChildIndex < data.getSize()
                && data.get(leftChildIndex).compareTo(data.get(rightChildIndex)) < 0;
        return leftLessThanRight ? rightChildIndex : leftChildIndex;
    }

    /**
     * 取出堆中最大的元素，并替换为新的元素
     * 再进行下沉操作
     *
     * @param newValue 一个新的值
     * @return 堆中的最大值
     */
    public E replace(E newValue) {
        E max = findMax();
        data.set(0, newValue);
        siftDown(0);
        return max;
    }




}
