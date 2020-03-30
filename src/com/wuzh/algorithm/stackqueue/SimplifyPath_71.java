package com.wuzh.algorithm.stackqueue;

import java.util.Iterator;
import java.util.Stack;

/**
 * @author wzh
 * @description 71. 简化路径
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
 * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
 * <p>
 * 示例 1：
 * 输入："/home/"
 * 输出："/home"
 * 解释：注意，最后一个目录名后面没有斜杠。
 * <p>
 * 示例 2：
 * 输入："/../"
 * 输出："/"
 * 解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。
 * <p>
 * 示例 3：
 * 输入："/home//foo/"
 * 输出："/home/foo"
 * 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
 * <p>
 * 示例 4：
 * 输入："/a/./b/../../c/"
 * 输出："/c"
 * <p>
 * 示例 5：
 * 输入："/a/../../b/../c//.//"
 * 输出："/c"
 * <p>
 * 示例 6：
 * 输入："/a//b////c/d//././/.."
 * 输出："/a/b/c"
 * @create 2020-03-30 20:50
 */
public class SimplifyPath_71 {

    public static String simplifyPath1(String path) {
        String[] split = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String p : split) {
            if ("..".equals(p) && !stack.isEmpty()) {
                stack.pop();
            } else if (!"".equals(p) && !".".equals(p) && !"..".equals(p)) {
                stack.push(p);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuffer simplifyPath = new StringBuffer();
        for (String p : stack) {
            simplifyPath.append("/");
            simplifyPath.append(p);
        }
        return simplifyPath.toString();
    }

    public static String simplifyPath(String path) {
        String[] split = path.split("/");
        Stack<String> stack = new Stack<>();
        stack.push("/");
        for (String p : split) {
            //空白和.则不管
            if ("".equals(p.trim()) || ".".equals(p)) {
                continue;
            }
            if ("..".equals(p)) {
                String pop = stack.pop();
                //如果到达根节点就不在继续弹栈了
                if ("/".equals(pop)) {
                    stack.push("/");
                }
                continue;
            }
            stack.push(p);
        }
        //通过栈内的元素构建路径
        String simplifyPath = "";
        //第一个弹栈不需要/
        boolean flag = true;
        while (!stack.empty()) {
            String pop = stack.pop();
            if (!"/".equals(pop) && !flag) {//不是第一个也不是最后一个
                simplifyPath = pop + "/" + simplifyPath;
            } else {
                simplifyPath = pop + simplifyPath;
                flag = false;
            }
        }
        return simplifyPath;
    }

    public static void main(String[] args) {
        String path = "/a/../../b/../c//.//";
        String simplifyPath = simplifyPath1(path);
        System.out.println(simplifyPath);
    }
}
