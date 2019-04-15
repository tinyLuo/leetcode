package com.ly.binarytree;

import com.ly.binarytree.PreOrder.TreeNode;

public class Case101 {
    
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetryTree(root.left, root.right);
    }
    
    public boolean isSymmetryTree(TreeNode LTree, TreeNode RTree) {
        if (LTree == null && RTree == null) {
            return true;
        }
        if (LTree != null && RTree != null && LTree.val == RTree.val) {
            return isSymmetryTree(LTree.left, RTree.right) && isSymmetryTree(LTree.right, RTree.left);
        }
        return false;
    }
    
}
