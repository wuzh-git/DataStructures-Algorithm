package com.wuzh.algorithm.dynamicProgram;

import java.util.Arrays;

/**
 * @author wzh
 * @description 斐波那契数列
 * @create 2020-04-05 16:47
 */
public class Fib {

    /**
     * 利用递归
     *
     * @param n
     * @return
     */
    public static int fib1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib1(n - 1) + fib1(n - 2);
    }

    //调用次数
    public static int num = 0;

    /**
     * 利用一个数组记忆化搜索
     *
     * @param n
     * @return
     */
    public static int fib2(int n) {
        int[] memo = new int[n + 1];
        //数组初始化为-1
        Arrays.fill(memo, -1);
        return fib2(n, memo);
    }

    public static int fib2(int n, int[] memo) {
        num++;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (memo[n] == -1) {
            memo[n] = fib2(n - 1, memo) + fib2(n - 2, memo);
        }
        return memo[n];
    }

    /**
     * 动态规划
     *
     * @return
     */
    public static int fib3(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] = memo[i - 2];
        }
        return memo[n];
    }

    public static void main(String[] args) {
        int n = 10;
        long startTime = System.currentTimeMillis();
        int sum = fib1(n);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + ":ms,fib=" + sum);
    }
}
