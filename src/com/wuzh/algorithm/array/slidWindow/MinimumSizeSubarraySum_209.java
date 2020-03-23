package com.wuzh.algorithm.array.slidWindow;

/**
 * @author wzh
 * @description 209. 长度最小的子数组(滑动窗口方式解决)
 * <p>
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。
 * 如果不存在符合条件的连续子数组，返回 0。
 * <p>
 * 示例: 
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * <p>
 * 进阶:
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 * @create 2020-03-22 22:43
 */
public class MinimumSizeSubarraySum_209 {

    /**
     * 使用两个指针完成滑动窗口，时间复杂度O(n),空间复杂度O(1)
     *
     * @param s
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int s, int[] nums) {
        //定义滑动窗口的左右指针  nums[l,r] 作为我们得滑动窗口
        int l = 0, r = -1;
        //子数组的和
        int sum = 0;
        //最小长度，初始定义比数组长度+1表示初始最大，却不是正确解，的后面计算和len求最小值
        int len = nums.length + 1;
        while (l < nums.length) {
            //确保r指针不越界,sum小于s则r指针右移
            if (r + 1 < nums.length && sum < s) {
                r++;
                sum += nums[r];
            } else {
                //sum>=s,表示找到子数组，但要找最小子数组，则需要sum先减l,l指针在右移
                sum -= nums[l];
                l++;
            }
            //如果找打子数组和>=s则比对长度，取最小值
            if (sum >= s) {
                len = Math.min(len, r - l + 1);
            }
        }
        //如果整个循环完都没找到子数组>=s，则返回0
        if (len == nums.length + 1) {
            return 0;
        }
        return len;
    }

    public static void main(String[] args) {
        /*int[] nums = {2, 3, 1, 2, 4, 3};
        int s = 7;*/
        int[] nums = {1, 4, 4};
        int s = 4;
        int length = minSubArrayLen(s, nums);
        System.out.println(length);
    }
}
