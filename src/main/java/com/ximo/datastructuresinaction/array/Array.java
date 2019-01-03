package com.ximo.datastructuresinaction.array;

/**
 * 自己的一个数组类
 *
 * @author Ximo
 * @date 2018/10/21 23:34
 */
public class Array<E> {

    private E[] data;

    private int size;

    /**
     * 初始化一个数组对象
     *
     * @param capacity 数组容量
     */
    @SuppressWarnings("unchecked")
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
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
    public void addLast(E element) {
        add(size, element);
    }

    /**
     * 在数组中的头部位置进行添加元素
     *
     * @param element 需要添加元素
     */
    public void addFirst(E element) {
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
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, Require index >= 0 and index <= size");
        }
        if (size == data.length) {
            resize(2 * data.length);
        }
        // 将后续的元素往后移动一个位置（从后往前依次挪动）
        if (size - index >= 0) {
            System.arraycopy(data, index, data, index + 1, size - index);
        }
        data[index] = element;
        size++;
    }

    /**
     * 扩容
     * 同样将
     * for (int i = 0; i < size; i++) {
     * newData[i] = data[i];
     * }
     * 改为
     * if (size >= 0) {
     * System.arraycopy(data, 0, newData, 0, size);
     * }
     *
     * @param newCapacity 新的容量
     */
    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        if (size >= 0) {
            System.arraycopy(data, 0, newData, 0, size);
        }
        data = newData;
    }

    /**
     * 获得数组中index位置中的元素
     *
     * @param index 元素
     * @return 该数组中该为重元素的值
     */
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, Require index >= 0 and index <= size");
        }
        return data[index];
    }

    /**
     * 取末尾的值
     *
     * @return 末尾的元素
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 获得头部的值
     *
     * @return 头部的元素
     */
    public E getFirst() {
        return get(0);
    }


    /**
     * 修改指定位置的元素的值
     *
     * @param index   指定位置
     * @param element 元素的值
     */
    public void set(int index, E element) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, Require index >= 0 and index <= size");
        }
        data[index] = element;
    }

    /**
     * 判断数组中是否包含该元素
     *
     * @param element 元素
     * @return 是否包含 true or false
     */
    public boolean contains(E element) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找元素，获得元素所在的index索引位置
     * 查找不到返回 -1
     *
     * @param element 元素
     * @return 查找元素，获得元素所在的index索引位置
     */
    public int find(E element) {
        for (int i = 0; i < size; i++) {
            if (data[i] == element) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除元素
     * 同样，将
     * for (int i = index + 1; i < size; i++) {
     * data[i - 1] = data[i];
     * }
     * 替换为
     * if (size - index + 1 >= 0) {
     * System.arraycopy(data, index + 1, data, index + 1 - 1, size - index + 1);
     * }
     *
     * @param index 删除元素的位置
     * @return 被删除元素的值
     */
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, Require index >= 0 and index <= size");
        }
        // 返回值
        E ret = data[index];
        // 将右边的元素左移
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        // 帮助gc loitering objects != memory leak
        data[size] = null;
        // 当容量是capacity的1/4的时候，同时当length不等于1的时候，才进行扩容，
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 指定元素的值，删除等于该值的第一个元素
     *
     * @param element 元素的值
     */
    public void removeElement(E element) {
        int index = find(element);
        if (index != -1) {
            remove(index);
        }
    }

    /**
     * 交换元素
     *
     * @param prev 元素所在索引
     * @param next 下一个所在的索引位置
     */
    public void swap(int prev, int next) {
        if (prev < 0 || prev > size || next < 0 || next > size) {
            throw new IndexOutOfBoundsException();
        }
        E temp = data[prev];
        data[prev] = data[next];
        data[next] = temp;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }
}
