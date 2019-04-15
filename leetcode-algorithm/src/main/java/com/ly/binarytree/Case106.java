package com.ly.binarytree;

import com.ly.binarytree.PreOrder.TreeNode;

public class Case106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return realTree1(inorder, postorder, 0, inorder.length, 0, postorder.length);
    }

    // public TreeNode realTree(int[] inorder, int instart, int inend, int[]
    // postorder, int poststart, int postend) {
    // if (instart == inend || poststart == postend)
    // return null;
    // TreeNode node = new TreeNode(postorder[postend - 1]);
    // for (int i = instart; i < inend; i++) {
    // if (inorder[i] == postorder[postend - 1]) {
    // node.left = realTree(inorder, instart, i, postorder, poststart, i + poststart
    // - instart);
    // node.right = realTree(inorder, i + 1, inend, postorder, i + poststart -
    // instart, postend - 1);
    // break;
    // }
    // }
    // return node;
    // }

    public TreeNode realTree1(int[] inorder, int[] postorder, int instart, int inend, int poststart, int postend) {
        if(instart == inend || poststart == postend) {
            return null;
        }
        TreeNode node = new TreeNode(postorder[postend - 1]);
        for(int i = instart;i < inend ; i++) {
            if(inorder[i] == postorder[postend-1]) {
                node.left = realTree1(inorder, postorder, instart, i, poststart, poststart + i - instart);
                node.right = realTree1(inorder, postorder, i + 1, inend, poststart + i - instart, postend - 1);
                break;
            }
        }
        return node;
    }

}
