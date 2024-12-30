package com.leetCode;

import java.util.ArrayList;
import java.util.List;

import com.leetCode.DsNodes.TreeNode;

public class P94 {

	public List<Integer> inorderTraversal(TreeNode root) {
        return getIndeorderTraversal(root, new ArrayList<>());
    }

    private List<Integer> getIndeorderTraversal(TreeNode root, List<Integer> inorderList) {
        if(root == null) {
            return inorderList;
        }

        getIndeorderTraversal(root.left, inorderList);
        inorderList.add(root.val);
        getIndeorderTraversal(root.right, inorderList);

        return inorderList;
    }
}
