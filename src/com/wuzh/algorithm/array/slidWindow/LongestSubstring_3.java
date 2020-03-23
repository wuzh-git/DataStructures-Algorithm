package com.wuzh.algorithm.array.slidWindow;

/**
 * @author wzh
 * @description 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * @create 2020-03-23 20:24
 */
public class LongestSubstring_3 {

    /**
     * 时间复杂度O(len(s))
     * 空间复杂度O(len(charset))
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        //存256个字符的ASCII码，每个字符出现的频率
        int[] freq = new int[256];
        //滑动窗口为s[l,r]
        int l = 0, r = -1;
        //最大无重复子串长度
        int len = 0;
        //整个循环从l=0,r=-1这个窗口开始向右滑动，每次循环里改变窗口，维护frep，并记录当前窗口是否找到一个最优值
        while (l < s.length()) {
            if (r + 1 < s.length() && freq[s.charAt(r + 1)] == 0) {//字符不重复，频率为0
                r++;
                freq[s.charAt(r)]++;
            } else {//r到头或者frep[r+1]==1
                freq[s.charAt(l)]--;
                l++;
            }
            //获取最小子串的最大长度
            len = Math.max(len, r - l + 1);
        }
        return len;
    }

    public static void main(String[] args) {
        String s1 = "pwwkew";
        int len = lengthOfLongestSubstring(s1);

        System.out.println(len);
    }
}
