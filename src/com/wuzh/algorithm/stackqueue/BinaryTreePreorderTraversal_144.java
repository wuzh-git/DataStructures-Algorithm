package com.wuzh.algorithm.stackqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wzh
 * @description 144. 二叉树的前序遍历
 * 给定一个二叉树，返回它的 前序 遍历。
 *  示例:
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 时间复杂度: O(n), n为树的节点个数
 * 空间复杂度: O(h), h为树的高度
 * @create 2020-03-30 22:36
 */
public class BinaryTreePreorderTraversal_144 {

    /**
     * 递归
     */
    public static List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        preorderTraversal(root,list);
        return list;
    }

    private static void preorderTraversal(TreeNode node, List<Integer> list) {
        if (node==null){
            return;
        }
        list.add(node.val);
        preorderTraversal(node.left,list);
        preorderTraversal(node.right,list);
    }


    /**
     * 利用栈
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Stack<Command> stack=new Stack<>();
        stack.push(new Command("go",root));
        while (!stack.empty()){
            Command command = stack.pop();
            if (command.s.equals("print")){
                list.add(command.node.val);
            }else {
                assert command.s.equals("go");
                if (command.node.right!=null){
                    stack.push(new Command("go",command.node.right ));
                }
                if (command.node.left!=null){
                    stack.push(new Command("go",command.node.left ));
                }
                stack.push(new Command("print",command.node ));
            }
        }
        return list;
    }

    private static class Command{
        private String s;//go print
        private TreeNode node;

        public Command(String s, TreeNode node) {
            this.s = s;
            this.node = node;
        }
    }

    public static void main(String[] args) {
        //1,null,2,3
        TreeNode root=new TreeNode(1);
        TreeNode node1=new TreeNode(2);
        TreeNode node2=new TreeNode(3);
        node1.left=node2;
        root.right=node1;
        List<Integer> list = preorderTraversal(root);
        for (Integer val : list) {
            System.out.println(val);
        }
    }
}
