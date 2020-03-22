package com.wuzh.algorithm.array.twosum;

/**
 * @author wzh
 * @description 11. 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例：
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * @create 2020-03-21 19:07
 */
public class MaxArea_11 {

    public static int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int maxArea = 0;
        while (l < r) {
            //x轴
            int x = r - l;
            //y轴取两个最小高
            int y = Math.min(height[l], height[r]);
            //面积
            int area = x * y;
            //最大值
            maxArea=Math.max(area,maxArea);
            //将指向较短线段的指针向较长线段那端移动一步
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }
}
