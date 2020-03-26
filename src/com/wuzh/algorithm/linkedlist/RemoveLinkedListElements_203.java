package com.wuzh.algorithm.linkedlist;

/**
 * @author wuzh 使用虚拟头结点
 * @Description: 203. 移除链表元素
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 * @date 2020-03-26
 */
public class RemoveLinkedListElements_203 {

    /**
     * 不利用虚拟头结点需要考虑头结点特殊情况
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements1(ListNode head, int val) {
        //如果删除节点是头结点
        while (head != null && head.val == val) {
            head = head.next;
        }
        //删除了头结点，校验是否为空，避免空指针
        if (head == null) {
            return null;
        }
        //如果不是头结点,以下一个节点的值来判断
        ListNode curNode = head;
        while (curNode.next != null) {
            //找到满足条件就删除
            if (curNode.next.val == val) {
                ListNode deleteNode = curNode.next;
                curNode.next = deleteNode.next;
            } else {
                //没找到，指针后移
                curNode = curNode.next;
            }
        }
        return head;
    }

    /**
     * 利用虚拟头结点
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements(ListNode head, int val) {
        //虚拟头结点，值随意，关键next头指针指向头结点
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        if (head == null) {
            return null;
        }
        ListNode curNode = dummyNode;
        while (curNode.next != null) {
            //移除指定节点
            if (curNode.next.val == val) {
                ListNode deleteNode = curNode.next;
                curNode.next = deleteNode.next;
            } else {
                curNode = curNode.next;
            }
        }
        //返回虚拟头结点的下一个节点
        return dummyNode.next;
    }

    public static void main(String[] args) {
//        int[] arr = {1, 2, 6, 3, 4, 5, 6};
        int[] arr = {6, 2, 6, 3, 4, 5, 6};
        ListNode linkedList = CreatePrintLinkedListUtil.createLinkedList(arr);
        ListNode reverseNode = removeElements1(linkedList, 6);
        CreatePrintLinkedListUtil.printLinkedList(reverseNode);
    }
}
