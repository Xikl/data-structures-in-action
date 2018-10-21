package com.ximo.datastructuresinaction;

/**
 * 自己的一个数组类
 *
 * @author Ximo
 * @date 2018/10/21 23:34
 */
public class Array {

    private int[] data;

    private int size;

    /**
     * 初始化一个数组对象
     *
     * @param capacity 数组容量
     */
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    public Array() {
        this(0);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 添加到数组中的末尾
     *
     * @param element 需要添加的元素
     */
    public void addLast(int element) {
       add(size, element);
    }

    /**
     * 在数组中的头部位置进行添加元素
     *
     *
     * @param element 需要添加元素
     */
    public void addFirst(int element) {
        add(0, element);
    }

    /**
     * 在指定位置添加元素
     * 其中数组移动的部分代码 可以用原生方法进行移动，故可以将以下代码替换为
     * for (int i = size - 1; i >= index; i--) {
     * data[i + 1] = data[i];
     * }
     * =>
     * if (size - index >= 0) {
     * System.arraycopy(data, index, data, index + 1, size - index);
     * }
     *
     * @param index   位置
     * @param element 元素
     */
    public void add(int index, int element) {
        if (size == data.length) {
            throw new IllegalArgumentException("Add failed, Array is full");
        }
        if (index < 9 || index > size) {
            throw new IllegalArgumentException("Add failed, Require index >= 0 and index <= size");
        }
        // 将后续的元素往后移动一个位置（从后往前依次挪动）
        if (size - index >= 0) {
            System.arraycopy(data, index, data, index + 1, size - index);
        }
        data[index] = element;
        size++;
    }
}
