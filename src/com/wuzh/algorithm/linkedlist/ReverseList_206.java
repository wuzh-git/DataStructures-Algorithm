package com.wuzh.algorithm.linkedlist;

/**
 * @author wuzh
 * @Description: 206. 反转链表
 * 反转一个单链表。
 * <p>
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * @date 2020-03-25
 */
public class ReverseList_206 {

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            //反转
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return cur;
    }

    public static void main(String[] args) {
        ListNode cur = new ListNode(1);
        ListNode next = new ListNode(2);
        for (int i = 3; i <= 5; i++) {
            ListNode node = new ListNode(i);


        }
        ListNode reverseNode = reverseList(cur);
        while (reverseNode != null) {
            System.out.println(reverseNode.val);
            reverseNode = reverseNode.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}


