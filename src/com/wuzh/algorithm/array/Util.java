package com.wuzh.algorithm.array;

/**
 * @author wuzh
 * @version V1.0
 * @Package com.wuzh.algorithm.array
 * @Description: 生成数组数据工具类
 * @date 2020-03-20
 */
public class Util {

    /**
     * 生成个数为n的随机数组
     *
     * @param n      个数
     * @param rangeL 最小范围
     * @param rangeR 最大范围
     * @return
     */
    public static Integer[] generateRadomArr(int n, int rangeL, int rangeR) {
        assert n > 0 && rangeL < rangeR;
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) Math.random() * (rangeR - rangeL + 1) + rangeL;
        }
        return arr;
    }

    /**
     * 生成个数为n的有序的数组
     *
     * @param n 个数
     * @return
     */
    public static Integer[] generateOrderedArr(int n) {
        assert n > 0;
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }
}
