package com.wuzh.algorithm.binarytree;

/**
 * @author wzh
 * @description 112. 路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 * @create 2020-04-01 22:37
 */
public class HasPathSum_112 {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root==null){
            return false;
        }
        //判断是否是没有子节点的叶子节点值是否等于sum
        if (root.left==null&&root.right==null){
            return root.val==sum;
        }
        //递归左子树能否找到满足条件
        if (hasPathSum(root.left,sum-root.val)){
            return true;
        }
        //右子树寻找
        if (hasPathSum(root.right,sum-root.val)){
            return true;
        }
        //都没找到则返回false
        return false;
    }
}
