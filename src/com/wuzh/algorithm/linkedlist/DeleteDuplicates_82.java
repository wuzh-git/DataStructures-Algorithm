package com.wuzh.algorithm.linkedlist;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author wuzh
 * @version V1.0
 * @Package com.wuzh.algorithm.linkedlist
 * @Description: 82. 删除排序链表中的重复元素 II
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 示例 1:
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * <p>
 * 示例 2:
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 * @date 2020-03-26
 */
public class DeleteDuplicates_82 {

    /**
     * 利用tree map计数
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates1(ListNode head) {
        if (head == null) {
            return null;
        }
        //利用Map计数
        Map<Integer, Integer> map = new TreeMap<>();
        ListNode curNode = head;
        while (curNode != null) {
            int val = curNode.val;
            Integer count = map.get(val);
            if (count != null) {
                map.put(val, ++count);
            } else {
                map.put(val, 1);
            }
            curNode = curNode.next;
        }
        //重新生成链表
        ListNode newHead = null;
        //是否是头节点
        boolean flag = true;
        ListNode cur = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            //处理头结点
            if (value == 1 && flag) {
                newHead = new ListNode(key);
                flag = false;
                cur = newHead;
                continue;
            }
            if (value == 1) {
                cur.next = new ListNode(key);
                cur = cur.next;
            }
        }
        return newHead;
    }

    /**
     * 注意该链表是排序后的链表
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        //虚拟头结点
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode curNode = dummyNode;
        while (curNode.next != null && curNode.next.next != null) {
            //如果当前下一个节点的值和下下一个节点的值相同，则找一个临时节点记录最后一个值相同的节点
            if (curNode.next.val == curNode.next.next.val) {
                //tmpNode作为最后一个值重复的节点
                ListNode tmpNode = curNode.next;
                while (tmpNode != null && tmpNode.next != null && tmpNode.val == tmpNode.next.val) {
                    tmpNode = tmpNode.next;
                }
                curNode.next = tmpNode.next;
            } else {
                curNode = curNode.next;
            }
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 3, 3, 4, 4, 5};
        ListNode head = CreatePrintLinkedListUtil.createLinkedList(arr);
        ListNode reverseNode = deleteDuplicates(head);
        CreatePrintLinkedListUtil.printLinkedList(reverseNode);
    }
}
