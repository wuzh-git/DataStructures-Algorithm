package com.wuzh.algorithm.stackqueue;

import java.util.Stack;

/**
 * @author wzh
 * @description 150. 逆波兰表达式求值
 * 根据逆波兰表示法，求表达式的值。
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * <p>
 * 说明：
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * <p>
 * 示例 1：
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: ((2 + 1) * 3) = 9
 * <p>
 * 示例 2：
 * 输入: ["4", "13", "5", "/", "+"]
 * 输出: 6
 * 解释: (4 + (13 / 5)) = 6
 * <p>
 * 示例 3：
 * 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * 输出: 22
 * 解释:
 * ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 * @create 2020-03-30 20:28
 */
public class EvalRPN_150 {

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            //遇到运算符则将栈里最上面两个数字运算，然后再将结果放回栈里
            int num1, num2;
            switch (token) {
                case "+":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    int num = num2 + num1;
                    stack.push(num);
                    break;
                case "-":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    num = num2 - num1;
                    stack.push(num);
                    break;
                case "*":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    num = num2 * num1;
                    stack.push(num);
                    break;
                case "/":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    num = num2 / num1;
                    stack.push(num);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(tokens));
    }
}
