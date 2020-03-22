package com.wuzh.algorithm.array.sort3partion;

/**
 * @author wzh
 * @description leetcode 88. 合并两个*有序*数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。
 * <p>
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * <p>
 * 示例:
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 输出: [1,2,2,3,5,6]
 * @create 2020-03-21 15:52
 */
public class MergeSortedArray_88 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //定义左右两个指针指向两个数组
        int p1 = m - 1, p2 = n - 1;
        //定义p指针作为下一个元素要添加的位置
        int p = m + n - 1;
        while ((p1 >= 0) && (p2 >= 0)) {
            if (nums1[p1] < nums2[p2]) {
                nums1[p] = nums2[p2];
                p2--;
                p--;
            } else if (nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
                p--;
            } else {
                //两个数组的最大元素相等则将它们都放到最后
                nums1[p] = nums1[p1];
                nums1[--p] = nums2[p2];
                p2--;
                p1--;
                p--;
            }
        }
        //还有中情况，当p1=-1时，上述循环跳出，但0至p2-1还有部分元素没有移过去，相当于nums2还有值比nums1[0]位置小，只有将这些元素放到nums1的最前面
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

    public static void main(String[] args) {
        int[] nums1 = {0,0,3,0,0,0,0,0,0};
        int[] nums2 = {-1,1,1,1,2,3};
        merge(nums1, 3, nums2, 6);
        for (int i : nums1) {
            System.out.println(i);
        }
    }
}
