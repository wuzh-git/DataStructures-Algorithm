package com.wuzh.algorithm.array.twosum;

/**
 * @author wzh
 * @description 125. 验证回文串
 * <p>
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 * @create 2020-03-21 17:22
 */
public class IsPalindrome_125 {

    /**
     * 使用对撞指针，时间复杂度O(n),空间复杂度O(n)
     */
    public static boolean isPalindrome(String s) {
        //字母转小写
        s = s.toLowerCase();
        //声明左右两个指针
        int l = 0, r = s.length() - 1;
        char[] chars = s.toCharArray();
        while (l < r) {
            char lChar = chars[l];
            char rChar = chars[r];
            if ((lChar >='0' && lChar <= '9') || (lChar >= 'a' && lChar <= 'z')) {
                if ((rChar >= '0' && rChar <= '9')|| (rChar >= 'a' && rChar <= 'z')) {
                    //比较两个字符是否相等
                    if (lChar != rChar) {
                        return false;
                    }
                    //相等的话，两个指针向中间各移一位
                    l++;
                    r--;
                } else {
                    // 如果rChar不是字母，指针向左移动
                    r--;
                }
            } else {
                // 如果lChar不是字母，指针向右移动
                l++;
            }
        }
        return true;
    }

    /**
     * 使用对撞指针，时间复杂度O(n),空间复杂度O(1)
     */
    public static boolean isPalindrome1(String s) {
        //字母转小写
        s = s.toLowerCase();
        //声明左右两个指针
        int l = 0, r = s.length() - 1;
        while (l < r) {
//            char lChar = s.charAt(l);
//            char rChar = s.charAt(r);
            if ((s.charAt(l) >='0' && s.charAt(l) <= '9') || (s.charAt(l) >= 'a' && s.charAt(l) <= 'z')) {
                if ((s.charAt(r) >= '0' && s.charAt(r) <= '9')|| (s.charAt(r) >= 'a' && s.charAt(r) <= 'z')) {
                    //比较两个字符是否相等
                    if (s.charAt(l) != s.charAt(r)) {
                        return false;
                    }
                    //相等的话，两个指针向中间各移一位
                    l++;
                    r--;
                } else {
                    // 如果rChar不是字母，指针向左移动
                    r--;
                }
            } else {
                // 如果lChar不是字母，指针向右移动
                l++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        String s2 = "race a car";
        String s3="0P";
        System.out.println(isPalindrome(s3));
    }
}
