package com.wuzh.algorithm.array;

/**
 * @author wuzh
 * @version V1.0
 * @Package com.wuzh.algorithm.array
 * @Description: 二分查找法
 * @date 2020-03-20
 */
public class BinarySearch {

    /**
     * 在升序数组中查找值为target的下标
     *
     * @param arr
     * @param n
     * @param target
     * @return
     */
    public static int binarySearch(Comparable[] arr, int n, Comparable target) {
        int l = 0, r = n - 1;//在[l,r]的范围内寻找target
        while (l <= r) {
            int mid = (l + r) / 2;
//            int mid = l + (r - 1) / 2;
            if (arr[mid].compareTo(target) == 0) {
                return mid;
            }
            if (arr[mid].compareTo(target) < 0) {
                l = mid + 1; //target在[mid+1,r]中
            } else {
                r = mid - 1; //target在[l,mid-1]中
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = (int) Math.pow(10, 7);
        Integer[] data = Util.generateOrderedArr(n);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            if (i != binarySearch(data, n, i)) {
                throw new IllegalStateException("查找i失败");
            }
            System.out.println(i);
        }
        long endTime = System.currentTimeMillis();
//        System.out.println(i);
        System.out.println("消耗时间：" + (endTime - startTime) + "ms");
    }
}
