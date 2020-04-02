package com.wuzh.algorithm.stackqueue;

import com.wuzh.algorithm.linkedlist.CreatePrintLinkedListUtil;
import com.wuzh.algorithm.linkedlist.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author wuzh
 * @Description: 考察堆 23. 合并K个排序链表
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * <p>
 * 延伸：
 * 堆还经常用来寻找第k大或第k小的元素，比如现在要找第k大的元素，现在只需要建立一个个数为k的最小堆，堆顶元素就是第k大的元素
 * @date 2020-04-01
 */
public class MergeKList_23 {

    public static ListNode mergeKLists(ListNode[] lists) {
        //创建优先队列，
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparing(node -> node.val));
        for (ListNode node : lists) {
            while (node != null) {
                pq.add(new ListNode(node.val));
                node = node.next;
            }
        }
        //将排序好的优先队列生成新链表
        ListNode dummyNode = new ListNode(0);
        ListNode curNode = dummyNode;
        while (!pq.isEmpty()) {
            curNode.next = pq.poll();
            curNode = curNode.next;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 4, 5};
        int[] arr2 = {1, 3, 4};
        int[] arr3 = {2, 6};
//        int[] arr1 = {-2,-1,-1,-1};
//        int[] arr2 = {};
        ListNode node1 = CreatePrintLinkedListUtil.createLinkedList(arr1);
        ListNode node2 = CreatePrintLinkedListUtil.createLinkedList(arr2);
        ListNode node3 = CreatePrintLinkedListUtil.createLinkedList(arr3);
        ListNode[] listNodes = {node1, node2,node3};
        ListNode node = mergeKLists(listNodes);
        CreatePrintLinkedListUtil.printLinkedList(node);
    }
}
