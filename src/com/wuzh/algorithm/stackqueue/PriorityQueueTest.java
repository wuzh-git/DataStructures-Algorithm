package com.wuzh.algorithm.stackqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author wuzh
 * @Description: 优先队列
 * @date 2020-04-01
 */
public class PriorityQueueTest {

    public static void main(String[] args) {
        //默认优先队列底层是最小堆
        test1();
        System.out.println("-----------------------");
        //修改比较方式，底层为最大堆
        test2();
        System.out.println("-----------------------");
        //使用自定义的Comparator,创建个性化的PriorityQueue
        test3();
    }

    //使用自定义的Comparator,创建个性化的PriorityQueue
    private static void test3() {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new MyComparator());
        for (int i = 0; i < 10; i++) {
            int num = (int) (Math.random() * 100);
            pq.add(num);
            System.out.println("insert " + num + " in priority queue");
        }
        //遍历输出
        while (!pq.isEmpty()) {
            Integer num = pq.poll();
            System.out.println(num + " ");
        }
    }

    /**
     * 自定义比较器，只比较数字的个位数大小
     */
    static class MyComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer a, Integer b) {
            if (a % 10 != b % 10) {
                return a % 10 - b % 10;
            }
            //个位数相同则比较两个数字大小
            return a - b;
        }
    }


    //默认优先队列底层是最小堆
    private static void test1() {
        //Java默认的优先队列，底层是最小堆（顶节点小于叶子节点的二叉树）
        PriorityQueue<Integer> pq = new PriorityQueue();
        for (int i = 0; i < 10; i++) {
            int num = (int) (Math.random() * 100);
            pq.add(num);
        }
        //遍历,升序输出
        while (!pq.isEmpty()) {
            Integer num = pq.poll();
            System.out.println(num + " ");
        }
    }

    //修改比较方式，底层为最大堆
    private static void test2() {
        //修改比较方式，使用lambda表达式，创建底层是最大堆的PriorityQueue
        PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int i = 0; i < 10; i++) {
            int num = (int) (Math.random() * 100);
            pq2.add(num);
        }
        //遍历,降序输出
        while (!pq2.isEmpty()) {
            Integer num = pq2.poll();
            System.out.println(num + " ");
        }
    }
}
