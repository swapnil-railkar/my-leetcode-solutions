package com.leetCode;

import java.util.ArrayList;
import java.util.List;

import com.leetCode.DsNodes.TreeNode;

public class P230 {
	
	public int solution(TreeNode root, int index) {
		List<Integer> nodes = getInOrderList(root, new ArrayList<>());
		return nodes.get(index - 1);
	}

	private List<Integer> getInOrderList(TreeNode root, List<Integer> indOrderList) {
		// TODO Auto-generated method stub
		if(root == null) {
			return indOrderList;
		}
		
		getInOrderList(root.left, indOrderList);
		indOrderList.add(root.val);
		getInOrderList(root.right, indOrderList);
		
		return indOrderList;
	}
}
