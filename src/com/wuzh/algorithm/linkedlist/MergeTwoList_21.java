package com.wuzh.algorithm.linkedlist;

/**
 * @author wuzh
 * @Description: 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * @date 2020-03-26
 */
public class MergeTwoList_21 {

    /**
     * 迭代：利用指针
     * 时间复杂度：N(m+n)
     * 空间复杂度O(1）
     *
     * @return
     */
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        //虚拟头指针
        ListNode dummyNode = new ListNode(0);
        if (l1 == null) {
            return l2;
        }
        dummyNode.next = l1;
        ListNode curNode1 = dummyNode;
        ListNode curNode2 = l2;
        while (curNode1.next != null && curNode2 != null) {
            if (curNode1.next.val <= curNode2.val) {
                curNode1 = curNode1.next;
            } else {
                ListNode tmpNode = curNode1.next;
                //第二个的节点添加到第一个中
                curNode1.next = curNode2;
                //第二个链表指针后移
                curNode2 = curNode2.next;
                curNode1.next.next = tmpNode;
                curNode1 = curNode1.next;
            }
            //如果第一个链表变量到了最后一个，而第二个链表还没遍历完，直接将剩余的第二个链表添加到第一个后面
            if (curNode1.next == null) {
                curNode1.next = curNode2;
                break;
            }
        }
        return dummyNode.next;
    }


    /**
     * 向上递归方式，复杂度分析
     * <p>
     * 时间复杂度：O(n + m)O(n+m)。 因为每次调用递归都会去掉 l1 或者 l2 的头元素（直到至少有一个链表为空），函数 mergeTwoList 中只会遍历每个元素一次。所以，时间复杂度与合并后的链表长度为线性关系。
     * 空间复杂度：O(n + m)O(n+m)。调用 mergeTwoLists 退出时 l1 和 l2 中每个元素都一定已经被遍历过了，所以 n + mn+m 个栈帧会消耗 O(n + m)O(n+m) 的空间。
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

    /**
     * 迭代
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        //虚拟头指针
        ListNode dummyNode = new ListNode(0);
        if (l1 == null) {
            return l2;
        }
        ListNode preNode = dummyNode;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                preNode.next = l1;
                l1 = l1.next;
            } else {
                preNode.next = l2;
                l2 = l2.next;
            }
            preNode = preNode.next;
        }
        //查看l1或者l2谁还有剩余节点，有就接到preNode的后面
        preNode.next = l1 == null ? l2 : l1;
        return dummyNode.next;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4};
        int[] arr2 = {1, 3, 4};
        ListNode l1 = CreatePrintLinkedListUtil.createLinkedList(arr1);
        ListNode l2 = CreatePrintLinkedListUtil.createLinkedList(arr2);
        ListNode node = mergeTwoLists3(l1, l2);
        CreatePrintLinkedListUtil.printLinkedList(node);
    }
}
