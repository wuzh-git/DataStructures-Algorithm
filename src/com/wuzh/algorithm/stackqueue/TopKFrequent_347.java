package com.wuzh.algorithm.stackqueue;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author wuzh
 * @Description: 优先队列  347. 前 K 个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * <p>
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * <p>
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * <p>
 * 说明：
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * @date 2020-04-01
 */
public class TopKFrequent_347 {

    public static List<Integer> topKFrequent(int[] nums, int k) {
        if (k <= 0) {
            throw new IllegalArgumentException("k should be greater than 0");
        }
        //统计每个元素出现的频率 K-值,V-出现次数
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (freq.containsKey(nums[i])) {
                freq.put(nums[i], freq.get(nums[i]) + 1);
            } else {
                freq.put(nums[i], 1);
            }
        }
        if (k > freq.size()) {
            new IllegalArgumentException("k should be less than the number of unique numbers in nums");
        }
        //扫描freq，维护当前出现频率最高的k个元素
        //在优先队列中，按照频率排序，所以数据对是（频率,元素）的形式
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(new PairComparator());
        for (Integer num : freq.keySet()) {
            //频次
            int numFreq = freq.get(num);
            //优先队列值维护k个元素
            if (k == pq.size()) {//当元素个数满了，需出队首比较
                if (numFreq > pq.peek().getKey()) {
                    pq.poll();
                    pq.add(new Pair<>(numFreq, num));
                }
            } else {
                pq.add(new Pair<>(numFreq, num));
            }
        }
        //从优先队列取出数据，封装返回结果
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll().getValue());
        }
        return res;
    }

    /**
     * 自定义比较器
     */
    private static class PairComparator implements Comparator<Pair<Integer, Integer>> {

        @Override
        public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
            if (p1.getKey() != p2.getKey()) {
                return p1.getKey() - p2.getKey();
            }
            return p1.getValue() - p2.getValue();
        }
    }

    public static void main(String[] args) {
        int[] nums = {4,1,-1,2,-1,-1,2,3};
        int k = 2;
        List<Integer> list = topKFrequent(nums, k);
        for (Integer num : list) {
            System.out.println(num);
        }
    }


}
