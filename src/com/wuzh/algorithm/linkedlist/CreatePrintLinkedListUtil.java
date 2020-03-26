package com.wuzh.algorithm.linkedlist;

/**
 * @author wuzh
 * @version V1.0
 * @Package com.wuzh.algorithm.linkedlist
 * @Description: 创建链表和输出链表工具类
 * @date 2020-03-26
 */
public class CreatePrintLinkedListUtil {
    /**
     * 创建链表
     *
     * @param arr
     * @return
     */
    public static ListNode createLinkedList(int[] arr) {
        if (arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }

    /**
     * 打印链表
     *
     * @param head
     */
    public static void printLinkedList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode cur = head;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
