package com.wuzh.algorithm.dynamicProgram;

import java.util.Arrays;

/**
 * @author wzh
 * @description 198. 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * <p>
 * 示例 2:
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * @create 2020-04-06 18:45
 */
public class RobHouse_198 {
    //memo[i]表示考虑抢劫nums[i,n)所获得的最大收益
    int[] memo;

    /**
     * 递归+动态记忆
     */
    public int rob(int[] nums) {
        memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        return tryRob(nums, 0);
    }

    //尝试抢劫nums[index,nums.length())这个范围里的所有房子
    private int tryRob(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        if (memo[index] != -1) {
            return memo[index];
        }
        int max = 0;
        //从index开始抢，找出最大的金额
        for (int i = index; i < nums.length; i++) {
            max = Math.max(max, nums[i] + tryRob(nums, i + 2));
        }
        memo[index] = max;
        return max;
    }

    /**
     * 动态规划
     *
     * @return
     */
    public int rob1(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        //memory[i]表示考虑抢劫，nums[i,n-1]所能获得的最大收益
        int[] memory = new int[n];
        Arrays.fill(memory, -1);
        memory[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            //memory[i]
            for (int j = i; j < n; j++) {
                memory[i] = Math.max(memory[i], nums[j] + (j + 2 < n ? memory[j + 2] : 0));
            }
        }
        return memory[0];
    }


    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        RobHouse_198 obj = new RobHouse_198();
        int rob = obj.rob1(nums);
        System.out.println(rob);
    }
}
