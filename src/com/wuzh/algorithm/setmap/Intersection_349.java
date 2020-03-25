package com.wuzh.algorithm.setmap;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wuzh
 * @version V1.0
 * @Package com.wuzh.algorithm.setmap
 * @Description: 349. 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 示例 1:
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * <p>
 * 示例 2:
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 说明:
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 */
public class Intersection_349 {

    /**
     * 使用hashset解决。时间复杂度O(n) HashSet复杂度是O(1)底层hash表,TreeSet复杂度logn,空间复杂度O(n)
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        //存放nums1的元素
        Set<Integer> record = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            record.add(nums1[i]);
        }
        //遍历nums2，求交集,将结果存入新set
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (record.contains(nums2[i])) {
                result.add(nums2[i]);
            }
        }
        //结果封装
        int[] arr = new int[result.size()];
        int index = 0;
        for (Integer intersection : result) {
            arr[index++] = intersection;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] num1 = {4, 9, 5};
        int[] num2 = {9, 4, 9, 8, 4};
        int[] intersection = intersection(num1, num2);
        for (int i = 0; i < intersection.length; i++) {
            System.out.println(intersection[i]);
        }
    }
}
