package com.ximo.datastructuresinaction.leetcode.recursive;

import java.util.StringJoiner;

/**
 * 两两交换链表中的节点
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * @author xikl
 * @date 2019/7/3
 */
public class SwapNode {

    private static class ListNode {
        int value;
        private ListNode tail;

        public ListNode(int x) {
            this.value = x;
        }

    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.tail == null) {
            return head;
        }

        ListNode tail = head.tail;
        head.tail = swapPairs(tail.tail);

        tail.tail = head;

        // 此时他就是头结点
        return tail;
    }


    /**
     * 假设我们现在有 1-> 2 -> 3 -> 4
     * 那么先反转 2-> 3 -> 4 得到 4 -> 3 -> 2
     * 但是1 还是指向 2 的 1-> 2 所以先 1.2.tail = 1 然后 1.tail = null
     * 最终就有了 4 3 2 1
     *
     *
     * @param head 头结点
     * @return
     */
    private static ListNode reverseNode(ListNode head) {
        if (head == null || head.tail == null) {
            return head;
        }

        // 缩小化我们的结果
        ListNode newHead = reverseNode(head.tail);
        head.tail.tail = head;
        head.tail = null;

        return newHead;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.tail = new ListNode(2);
        head.tail.tail = new ListNode(3);
        head.tail.tail.tail = new ListNode(4);
        print(head);

        ListNode result = swapPairs(head);
        print(result);

    }

    private static void print(ListNode head) {
        ListNode cur = head;
        StringJoiner joiner = new StringJoiner(" -> ", "{", "}");
        while (cur != null) {
            joiner.add(String.valueOf(cur.value));
            cur = cur.tail;
        }
        System.out.println(joiner.toString());
    }


}
