package com.leetCode;

import java.util.HashMap;
import java.util.Map;

import com.leetCode.DsNodes.TreeNode;

public class P106 {
	public TreeNode solution(int[] inorder, int[] postorder) {
        Map<Integer, Integer> postOrderIndexMap = new HashMap<>();
        for(int i = 0; i< postorder.length; i++) {
           postOrderIndexMap.put(postorder[i], i); 
        }
        return buildTree(inorder, 0, inorder.length - 1, postOrderIndexMap);
    }

    private TreeNode buildTree(int[] inOrder, int start, int end, Map<Integer, Integer> postOrderIndexMap) {
        if(start == end) {
            return new TreeNode(inOrder[start]);
        }
        if(start > end) {
            return null;
        }
        int rootIndex = getRoot(inOrder, postOrderIndexMap, start, end);
        TreeNode root = new TreeNode(inOrder[rootIndex]);
        root.left = buildTree(inOrder, start, rootIndex - 1, postOrderIndexMap);
        root.right = buildTree(inOrder, rootIndex + 1, end, postOrderIndexMap);
        return root;
    }

    private int getRoot(int[] inOrder, Map<Integer, Integer> postOrderIndexMap, int start, int end) {
        int root = -1;
        int max = Integer.MIN_VALUE;
        for(int i = start; i<= end; i++) {
            if(postOrderIndexMap.get(inOrder[i]) > max) {
                max = postOrderIndexMap.get(inOrder[i]);
                root = i;
            }
        }
        return root;
    }
}
