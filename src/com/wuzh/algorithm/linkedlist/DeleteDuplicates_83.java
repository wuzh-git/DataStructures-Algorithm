package com.wuzh.algorithm.linkedlist;

/**
 * @author wuzh
 * @Description: 83. 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * 输入: 1->1->2
 * 输出: 1->2
 * <p>
 * 示例 2:
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * @date 2020-03-26
 */
public class DeleteDuplicates_83 {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head==null){
            return null;
        }
        //虚拟头节点
        ListNode dummyNode=new ListNode(0);
        dummyNode.next=head;
        ListNode curNode=dummyNode;
        while (curNode.next!=null){

        }

        return null;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 3};
        ListNode head = CreatePrintLinkedListUtil.createLinkedList(arr);
        ListNode node = deleteDuplicates(head);
        CreatePrintLinkedListUtil.printLinkedList(node);
    }
}
