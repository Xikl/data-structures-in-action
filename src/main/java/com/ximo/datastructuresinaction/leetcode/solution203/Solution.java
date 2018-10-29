package com.ximo.datastructuresinaction.leetcode.solution203;

import java.util.List;

/**
 * 移除链表中的元素
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 *
 * @author Ximo
 * @date 2018/10/29 21:57
 */
public class Solution {

    /**
     * 删除该链表中的所有元素
     *
     * @param head 头结点信息
     * @param val 要删除的元素
     * @return 删除后的链表
     */
    public ListNode removeElements(ListNode head, int val) {
//        return removeElementsByHeadAndHelpGc(head, val);
//        return removeElementByDummyHead(head, val);
        return removeElementsByHeadAndNotHelpGc(head, val);
    }


    private ListNode removeElementsByHeadAndHelpGc(ListNode head, int val) {
        // 恰好头结点就是要删除的信息
        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }
        // 是否已经删除所有
        if (head == null) {
            return null;
        }
        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                // 移除
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                // 向后移动一位
                prev = prev.next;
            }
        }
        return head;
    }


    /** 不需要考虑gc的操作 来进行删除 */
    private ListNode removeElementsByHeadAndNotHelpGc(ListNode head, int val) {
        // 恰好头结点就是要删除的信息
        while (head != null && head.val == val) {
            head = head.next;
        }
        // 是否已经删除所有
        if (head == null) {
            return null;
        }
        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                // 移除
                prev.next = prev.next.next;
            } else {
                // 向后移动一位
                prev = prev.next;
            }
        }
        return head;
    }

    /** 利用虚拟头结点的信息进行操作 */
    private ListNode removeElementByDummyHead(ListNode head, int val) {
        // 创建一个虚拟头结点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }

    /**
     * LeetCode提供的默认类
     */
    private static class ListNode{
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode(int[] arr) {
            if (arr == null || arr.length == 0) {
                throw new IllegalArgumentException("Arr is empty");
            }
            this.val = arr[0];
            ListNode cur = this;
            for (int i = 1; i < arr.length; i++) {
                cur.next = new ListNode(arr[i]);
                cur = cur.next;
            }
        }

        @Override
        public String toString() {
            StringBuilder res = new StringBuilder();
            ListNode cur = this;
            while (cur != null) {
                res.append(cur.val).append(" -> ");
                cur = cur.next;
            }
            res.append("null");
            return res.toString();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 5, 6, 4};
        ListNode head = new ListNode(nums);
        System.out.println(head);
    }


}
