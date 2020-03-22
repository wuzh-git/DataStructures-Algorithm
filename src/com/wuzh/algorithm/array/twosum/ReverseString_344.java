package com.wuzh.algorithm.array.twosum;

/**
 * @author wzh
 * @description 344. 反转字符串
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * <p>
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * <p>
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * <p>
 *  
 * <p>
 * 示例 1：
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * <p>
 * 示例 2：
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 * @create 2020-03-21 18:05
 */
public class ReverseString_344 {

    public static void reverseString(char[] chars) {
        if (chars.length <= 1) {
            return;
        }
        //定义两个指针
        int l = 0, r = chars.length - 1;
        while (l < r) {
            char tmp = chars[l];
            chars[l] = chars[r];
            chars[r] = tmp;
            //交换字符串后两边指针向中间对撞
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        char[] chars = {'H', 'a', 'n', 'n', 'a', 'h'};
        reverseString(chars);
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }
    }
}
