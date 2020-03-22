package com.wuzh.algorithm.array.sort3partion;

import java.util.Arrays;

/**
 * @author wzh
 * @description 215. 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 * <p>
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * @create 2020-03-21 15:54
 */
public class FindKthLargest_215 {

    public static int findKthLargest1(int[] nums, int k) {
        //从右边往左边数第 kk 个元素（从 11 开始）
        //Arrays.sort，默认是快排方式，时间复杂度O(NlogN),空间复杂度O(1)
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    /*
    利用快排partition中，将pivot放置在了其正确的位置上的性质
     */
    public static int findKthLargest(int[] nums, int k) {

        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        System.out.println(findKthLargest1(nums,k));
    }
}
