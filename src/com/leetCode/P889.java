package com.leetCode;

import java.util.HashMap;
import java.util.Map;

import com.leetCode.DsNodes.TreeNode;

public class P889 {

	private Map<Integer, Integer> preOrderValueIndexMap = new HashMap<>();
	private Map<Integer, Integer> postOrderValueIndexMap = new HashMap<>();
	
	public TreeNode solution(int[] preOrder, int[] postOrder) {
		populateValueIndexMap(preOrder, preOrderValueIndexMap);
		populateValueIndexMap(postOrder, postOrderValueIndexMap);
		TreeNode root = null;
		root = buildBT(preOrder, postOrder, 0, preOrder.length - 1, root);
		return root;
	}
	
	private TreeNode buildBT(int[] preOrder, int[] postOrder, int startIndex, int endIndex, TreeNode root) {
		if(startIndex > endIndex) {
			return null;
		} else if(startIndex == endIndex) {
			return new TreeNode(postOrder[endIndex]);
		}
		root = new TreeNode(postOrder[endIndex]);
		// crazy init.
		int divideIndex = postOrderValueIndexMap.get(preOrder[preOrderValueIndexMap.get(root.val) + 1]);
		root.left = buildBT(preOrder, postOrder, startIndex, divideIndex, root.left);
		root.right = buildBT(preOrder, postOrder, divideIndex + 1, endIndex - 1, root.right);
		return root;
	}
	
	/**
	 * explaination for this : postOrderValueIndexMap.get(preOrder[preOrderValueIndexMap.get(root.val) + 1]) 
	 * pre order traversal gives root at startIndex, value at startIndex + 1 becomes left node.
	 * Similarly, pre order alse gives root at endIndex, then we can value at preOrder[startIndex + 1] to divide preorder array in left and right
	 * left will contain values from index 0 to postorder index of value for preOrder[startIndex + 1]
	 * right will contain values form postorder index of value for preOrder[startIndex + 1] + 1 to end index - 1 (value at end index is root)
	 * 
	 */
	
	private void populateValueIndexMap(int[] arr, Map<Integer, Integer> map) {
		for(int i =0; i< arr.length; i++) {
			map.put(arr[i], i);
		}
	}
}
