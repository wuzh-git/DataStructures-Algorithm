package com.wuzh.algorithm.binarytree;

/**
 * @author wzh
 * @description 226. 翻转二叉树
 * 翻转一棵二叉树。
 *
 * 示例：
 * 输入：
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 *
 * 输出：
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * @create 2020-04-01 22:05
 */
public class InvertTree_226 {

    public TreeNode invertTree(TreeNode root) {
        if (root==null){
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);
        //左右节点反转
        TreeNode tmp = root.left;
        root.left=root.right;
        root.right=tmp;
        return root;
    }

}
