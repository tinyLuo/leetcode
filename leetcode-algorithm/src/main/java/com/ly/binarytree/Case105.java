package com.ly.binarytree;

import com.ly.binarytree.PreOrder.TreeNode;

public class Case105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return getNode(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }

    public TreeNode getNode(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if(preStart == preEnd || inStart == inEnd) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[preStart]);
        for (int i = inStart; i < inEnd; i++) {
            if(inorder[i] == preorder[preStart]) {
                node.left = getNode(preorder, inorder, preStart+1, preStart+1+i-inStart, inStart, i);
                node.right = getNode(preorder, inorder, preStart+1+i-inStart, preEnd, i+1, inEnd);
                break;
            }
        }
        return node;
    }

}
