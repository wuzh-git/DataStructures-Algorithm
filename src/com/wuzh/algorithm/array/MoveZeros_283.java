package com.wuzh.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wzh
 * @description leetcode283 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * @create 2020-03-20 22:22
 */
public class MoveZeros_283 {

    /**
     * 时间复杂度：O（n）
     * 空间复杂度：O（n）
     *
     * @param nums
     */
    public static void moveZeroes1(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                temp.add(nums[i]);
            }
        }
        for (int i = 0; i < temp.size(); i++) {
            nums[i] = temp.get(i);
        }
        for (int i = temp.size(); i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums
     */
    public static void moveZeroes2(int[] nums) {
        //k变量是非零元素下一个索引位置，即在nums中，[0,k)是非零元素
        int k = 0;
        //变量到第i个元素后，保证[0,i]中所有非0元素都按照顺序排列在[0,k)中
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }
        //把nums剩余位置[k,n)置为0
        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums
     */
    public static void moveZeroes3(int[] nums) {
        //k变量是非零元素下一个索引位置，即在nums中，[0,k)是非零元素
        int k = 0;
        //变量到第i个元素后，保证[0,i]中所有非0元素都按照顺序排列在[0,k)中
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k] = nums[i];
                if (k != i) {
                    nums[i] = 0;
                }
                k++;
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes3(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
