package com.leetCode;

import java.util.HashMap;
import java.util.Map;

import com.leetCode.DsNodes.TreeNode;

public class P1028 {

	private Map<Integer, TreeNode> heightLastUpdatedNodeMap = new HashMap<>();
	
	public TreeNode solution(String traversal) {
		int height =0;
		TreeNode root = null;
		for(int i =0; i< traversal.length(); i++) {
			if(traversal.charAt(i) == '-') {
				height++;
			} else {
				StringBuilder number = new StringBuilder();
				while(i < traversal.length() && Character.isDigit(traversal.charAt(i))) {
					number.append(traversal.charAt(i));
					i++;
				}
				int value = Integer.valueOf(number.toString());
				if(root == null) {
					root = new TreeNode(value);
					heightLastUpdatedNodeMap.put(0, root);
				} else {
					updateTree(height - 1, value);
				}
				
				height = 0;
				i--;
			}
		}
		return root;
	}
	
	private void updateTree(int height, int value) {
		TreeNode node = heightLastUpdatedNodeMap.get(height);
		if(node.left == null) {
			node.left = new TreeNode(value);
			heightLastUpdatedNodeMap.put(height + 1, node.left);
		} else {
			node.right = new TreeNode(value);
			heightLastUpdatedNodeMap.put(height + 1, node.right);
		}
	}

}
