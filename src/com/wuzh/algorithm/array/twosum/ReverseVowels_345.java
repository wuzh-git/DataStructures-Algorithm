package com.wuzh.algorithm.array.twosum;

/**
 * @author wzh
 * @description 345. 反转字符串中的元音字母
 * <p>
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 * 示例 1:
 * 输入: "hello"
 * 输出: "holle"
 * <p>
 * 示例 2:
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 说明:
 * 元音字母不包含字母"y"。
 * 元音字母有5个，分别是Aa、Ee、Ii、Oo、Uu
 * @create 2020-03-21 18:29
 */
public class ReverseVowels_345 {

    //元音字母
    public static final char[] vowels = {'A', 'a', 'E', 'e', 'I', 'i', 'O', 'o', 'U', 'u'};

    public static boolean isVowel(char c) {
        if (c == 'A' || c == 'a' || c == 'E' || c == 'e' || c == 'I' || c == 'i' || c == 'O' || c == 'o' || c == 'U' || c == 'u') {
            return true;
        }
        return false;
    }

    public static String reverseVowels(String s) {
        //定义左右两个指针向中间对撞
        int l = 0, r = s.length() - 1;
        char[] chars = s.toCharArray();
        while (l < r) {
            //不是元音字母则找下一个
            if (!isVowel(chars[l])){
                l++;
                continue;
            }
            //左边是元音字母，则找到右边相同的字母反转
            if (isVowel(chars[r])) {
                char tmp = chars[l];
                chars[l] = chars[r];
                chars[r] = tmp;
                l++;
                r--;
            } else {
                r--;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String s = "hello";
        String s2 = "leetcode";
        String s3= "A man, a plan, a canal: Panama";
//        System.out.println(reverseVowels(s));
//        System.out.println(reverseVowels(s2));
        System.out.println(reverseVowels(s3));

    }
}
