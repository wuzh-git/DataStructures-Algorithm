package com.wuzh.algorithm.array.twosum;

/**
 * @author wzh
 * @description 167. 两数之和 II - 输入**有序**数组
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * <p>
 * 说明:
 * **返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * <p>
 * 示例:
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * @create 2020-03-21 16:05
 */
public class TwoSum_167 {

    //解法1：使用双重循环暴力求解，时间复杂度O(n^2)
    public static int[] twoSum1(int[] numbers, int target) {
        int[] indexs = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    //返回的下标值（index1 和 index2）不是从零开始的。
                    indexs[0] = i + 1;
                    indexs[1] = j + 1;
                }
            }
        }
        return indexs;
    }

    //解法2：使用单层循环+二分查找法求解，时间复杂度O(Nlog(n))
    public static int[] twoSum2(int[] numbers, int target) {
        int[] indexs = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            //查找相加的另外一个值
            int num = target - numbers[i];
            //二分查找[l,r]区间查找,复杂度O(log(n))
            int l = i + 1, r = numbers.length - 1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (numbers[mid] == num && mid != i) {
                    //查找到，就返回结果，由于不是从0开始，所以结果+1
                    indexs[0] = i + 1;
                    indexs[1] = mid + 1;
                    return indexs;
                } else if (numbers[mid] < num) {//说明在右半区，即[mid+1,r]
                    l = mid + 1;
                } else {
                    //说明在左半区，即[l,mid+1]
                    r = mid - 1;
                }
            }
        }
        return indexs;
    }

    //解法3：对撞指针法：左右两个指针向中间移动，时间复杂度O(n),空间复杂度O(1)
    public static int[] twoSum3(int[] numbers, int target) {
        if (numbers.length < 2 /*|| !isSorted(numbers)*/) {
            throw new IllegalArgumentException("Illegal argument numbers");
        }
        int[] indexs = new int[2];
        //定义左右两个指针，分别从最前和最后
        int l = 0, r = numbers.length - 1;
        //指针两边向中间移动，直到找到目标
        while (l < r) {
            //找到
            if (numbers[l] + numbers[r] == target) {
                indexs[0] = l + 1;
                indexs[1] = r + 1;
                break;
            } else if (numbers[l] + numbers[r] < target) {
                //相加小于目标值，只有移动左边，让左边数字变大
                l++;
            } else {
                //相加大于目标值，只有移动右边，让右边数字变小
                r--;
            }
        }
        return indexs;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 4, 9, 56, 90};
        int target = 8;
        int[] result = twoSum3(numbers, target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
