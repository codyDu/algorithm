package com.company;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Main {

    public static void main(String[] args) {
        // write your code here

    }


//    144. 二叉树的前序遍历

    //    递归写法
    List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {

        if (root == null) return res;
        res.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);

        return res;
    }

    //   迭代写法
    public List<Integer> preorderTraversal2(TreeNode root) {

        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }

        return res;

    }





//    二叉树的中序遍历
public List<Integer> inorderTraversal(TreeNode root) {
    if (root == null) return res;
    preorderTraversal(root.left);
    res.add(root.val);
    preorderTraversal(root.right);

    return res;
}


    public String reverseLeftWords(String s, int n) {
        return s.substring(n,s.length()) + s.substring(0,n);

    }


//    请完成一个函数，输入一个二叉树，该函数输出它的镜像。
//剑指 Offer 27. 二叉树的镜像
    public TreeNode mirrorTree(TreeNode root) {

        if (root == null) return null;
        TreeNode left  = mirrorTree(root.right);
         TreeNode right = mirrorTree(root.left);
         root.left = left;
         root.right = right;

        return root;
    }


//    剑指 Offer 55 - I. 二叉树的深度
    public int maxDepth(TreeNode root) {

        if (root == null) return 0;

        return Math.max(maxDepth(root.left) , maxDepth(root.right)) + 1;

    }


    public String replaceSpace(String s) {

        return s.replace(" ","%");

    }


}
