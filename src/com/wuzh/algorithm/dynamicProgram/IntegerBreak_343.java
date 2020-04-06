package com.wuzh.algorithm.dynamicProgram;

import java.util.Arrays;

/**
 * @author wzh
 * @description 343. 整数拆分
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * 示例 1:
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * <p>
 * 示例 2:
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 * @create 2020-04-06 16:21
 */
public class IntegerBreak_343 {

    //----------------------------------------------------------------------------
    private int[] memo;

    /**
     * 方式1：递归+记忆化
     *
     * @return
     */
    public int integerBreak(int n) {
        assert n > 1;
        //从下标1开始
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        //递归，拆分整数求得最大的积
        return breakInteger(n);
    }

    //将n进行拆分（至少分割成两部分），可以获得的最大乘积
    private int breakInteger(int n) {
        if (n == 1) {
            return 1;
        }
        if (memo[n] != -1) {
            return memo[n];
        }
        //最大乘积，初始化-1
        int max = -1;
        for (int i = 1; i <= n - 1; i++) {
            //i+(n-i)
            max = max3(max, i * (n - i), i * breakInteger(n - i));
        }
        memo[n] = max;
        return max;
    }

    //----------------------------------------------------------------------------
    //动态规划
    public int integerBreak1(int n) {
        assert n >= 2;
        int[] memory = new int[n + 1];
        memory[1] = 1;
        for (int i = 2; i <= n; i++) {
            //求解memory[i]
            for (int j = 1; j <= i - 1; j++) {
                //j+(i-j)
                memory[i] = max3(memory[i], j * (i - j), j * memory[i - j]);
            }
        }
        return memory[n];
    }

    //求三个数中的最大数
    private int max3(int max, int i1, int i2) {
        return Math.max(max, Math.max(i1, i2));
    }

    public static void main(String[] args) {
        int n = 10;
        IntegerBreak_343 ob = new IntegerBreak_343();
        int result = ob.integerBreak1(n);
        System.out.println(result);
    }
}
