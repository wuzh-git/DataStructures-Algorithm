package com.wuzh.algorithm.linkedlist;

/**
 * @author wuzh
 * @Description: 2. 两数相加
 * 给出两个 [非空] 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 [逆序] 的方式存储的，并且它们的每个节点只能存储 [一位] 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例1：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 示例2：
 * 输入[5]+[5]
 * 输出[0,1]
 * @date 2020-03-26
 */
public class AddTwoNum_2 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode curNode = dummyNode;
        //存储相加超过10的进位值
        int tmpVal = 0;
        while (l1 != null || l2 != null) {
            int v1 = (l1 != null) ? l1.val : 0;
            int v2 = (l2 != null) ? l2.val : 0;
            int sum = v1 + v2 + tmpVal;
            //超过10进位或者没超过10则置0
            tmpVal = sum / 10;
            //只留个位数
            int val = sum % 10;
            ListNode node = new ListNode(val);
            curNode.next = node;
            curNode = curNode.next;
            //指针后移
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }
        //特殊情况：如果上面tmpVal在循环后还为1，则需要添加节点
        if (tmpVal == 1) {
            curNode.next = new ListNode(tmpVal);
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
//        int[] arr1 = {5};
//        int[] arr2 = {5};

        int[] arr1 = {2,4,3};
        int[] arr2 = {5,6,4};

//        int[] arr1 = {9, 8};
//        int[] arr2 = {1};
        ListNode l1 = CreatePrintLinkedListUtil.createLinkedList(arr1);
        ListNode l2 = CreatePrintLinkedListUtil.createLinkedList(arr2);
        ListNode node = addTwoNumbers(l1, l2);
        CreatePrintLinkedListUtil.printLinkedList(node);
    }
}
