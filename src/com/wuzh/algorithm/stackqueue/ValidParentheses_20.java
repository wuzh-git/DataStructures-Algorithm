package com.wuzh.algorithm.stackqueue;

import java.util.Stack;

/**
 * @author wuzh
 * @Description: 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * 输入: "()"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 * <p>
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 * <p>
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 * <p>
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 * @date 2020-03-30
 */
public class ValidParentheses_20 {

    /**
     * 利用栈
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            //左括号入栈
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.size() == 0) {
                    return false;
                }
                //遇到右括号则出栈栈顶元素对比
                char match;
                if (c == ')') {
                    match = '(';
                } else if (c == ']') {
                    match = '[';
                } else {
                    match = '{';
                }
                //取出栈顶元素对比
                Character pop = stack.pop();
                if (pop != match) {
                    return false;
                }
            } else {
                //非法字符
                return false;
            }
        }
        //循环结束了，栈里还剩余未出栈元素，也说明不是有效字符
        if (stack.size() > 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "}";
        System.out.println(isValid(s));
    }
}
