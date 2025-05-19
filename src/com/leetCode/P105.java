package com.leetCode;

import com.leetCode.DsNodes.TreeNode;
import java.util.HashMap;
import java.util.Map;

public class P105 {
	public TreeNode solution(int[] preorder, int[] inorder) {
        Map<Integer, Integer> preOrderIndexMap = new HashMap<>();
        for(int i = 0; i< preorder.length; i++) {
            preOrderIndexMap.put(preorder[i], i);
        }
        return constructTree(0, inorder.length - 1, inorder, preOrderIndexMap);
    }
    
    private TreeNode constructTree(int left, int right, int[] inorder, Map<Integer, Integer> preOrderIndexMap) {
    	if(left > right) {
            return null;
        }
    	if(left == right) {
            return new TreeNode(inorder[left]);
        }
        int rootIndex = getRootIndex(left, right, inorder, preOrderIndexMap);
        TreeNode root = new TreeNode(inorder[rootIndex]);
        root.left = constructTree(left, rootIndex-1, inorder, preOrderIndexMap);
        root.right = constructTree(rootIndex + 1, right, inorder, preOrderIndexMap);
        return root;
    }
    
    private int getRootIndex(int left, int right, int[] inorder, Map<Integer, Integer> preOrderIndexMap) {
        int minPreIndex = Integer.MAX_VALUE;
        int minInIndex = Integer.MAX_VALUE;
        for(int i = left; i <= right; i++) {
            if(preOrderIndexMap.get(inorder[i]) < minPreIndex) {
            	minPreIndex = preOrderIndexMap.get(inorder[i]);
            	minInIndex = i;
            }
        }
        return minInIndex;
    }
}
