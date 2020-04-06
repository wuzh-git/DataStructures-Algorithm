package com.wuzh.algorithm.dynamicProgram;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author wzh
 * @description 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * <p>
 * 示例 2：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * @create 2020-04-06 11:04
 */
public class ClimbStairs_70 {

    //记忆已经计算的，避免重复计算
    int[] memo;

    /**
     * 递归
     */
    public int climbStairs(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return calcWays(n);
    }

    private int calcWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (memo[n] == -1) {
            memo[n] = calcWays(n - 1) + calcWays(n - 2);
        }

        return memo[n];
    }

    //动态规划
    public static int climbStairs1(int n) {
        int[] memory = new int[n + 1];
        Arrays.fill(memory, -1);
        //自低向上计算
        memory[0] = 1;
        memory[1] = 1;
        for (int i = 2; i <= n; i++) {
            memory[i] = memory[i - 1] + memory[i - 2];
        }
        return memory[n];
    }

    public static void main(String[] args) {
        int n=3;
        System.out.println(climbStairs1(n));
    }
}
