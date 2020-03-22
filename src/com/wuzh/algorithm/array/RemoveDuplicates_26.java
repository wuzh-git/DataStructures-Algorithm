package com.wuzh.algorithm.array;

/**
 * @author wzh
 * @description LeetCode 26.删除排序数组中的重复项
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 *
 *
 * 示例 1:
 *
 * 给定数组 nums = [1,1,2],函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * @create 2020-03-21 13:24
 */
public class RemoveDuplicates_26 {

    public static int removeDuplicates(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        //第一次出现的元素，做临时变量
        int tmp=nums[0];
        //记录需要插入不重复元素的下一个位置指针
        int index=1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != tmp){
                nums[index]=nums[i];
                //更换为下一轮比较数字
                tmp=nums[i];
                //指针后移一位
                index++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums= {0,0,1,1,1,2,2,3,3,4};
        int length= removeDuplicates(nums);
        System.out.println( "不重复后的数组长度" + length );
        for (int i = 0; i < nums.length; i++) {
            System.out.println( nums[i] );
        }
    }
}
