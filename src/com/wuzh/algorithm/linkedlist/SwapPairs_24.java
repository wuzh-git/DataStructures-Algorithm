package com.wuzh.algorithm.linkedlist;

/**
 * @author wuzh
 * @Description: 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例:
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * @date 2020-03-27
 */
public class SwapPairs_24 {

    /**
     * 利用四个指针进行交换,p->node1->node2->next
     *
     *     p     node1 node2 next
     * dummyHead -> 1 -> 2 -> 3 -> 4
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        ListNode dummyNode=new ListNode(0);
        dummyNode.next=head;
        ListNode p=dummyNode;
        while (p.next!=null&&p.next.next!=null){
            ListNode node1=p.next;
            ListNode node2=p.next.next;
            ListNode next=p.next.next.next;
            //链表穿针引线
            node1.next=next;
            node2.next=node1;
            p.next=node2;
            //p变为第二个修改位置的节点
            p=p.next.next;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4};
        ListNode head = CreatePrintLinkedListUtil.createLinkedList(arr);
        ListNode node = swapPairs(head);
        CreatePrintLinkedListUtil.printLinkedList(node);
    }
}
