package com.leetCode;

import com.leetCode.DsNodes.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P105 {
    public static void main(String[] args) {
        int[] inOrder = {2,1};
        int[] preOrder = {1,2};
        P102 lot = new P102();
        TreeNode root = getTree(preOrder, inOrder, null);
    }

    private static TreeNode getTree(int[] preOrder, int[] inOrder, TreeNode root) {
        if (inOrder.length == 1) {
            root.val = inOrder[0];
            return root;
        }

        List<int[]> nodeInfo = getNode(inOrder, preOrder);
        if (root == null) {
            root = new TreeNode(nodeInfo.get(0)[0]);
        }
        root.val = nodeInfo.get(0)[0];
        if(nodeInfo.get(1).length > 0) {
            root.left = getTree(preOrder, nodeInfo.get(1), new TreeNode());
        }
        if(nodeInfo.get(2).length > 0) {
            root.right = getTree(preOrder, nodeInfo.get(2), new TreeNode());
        }

        return root;
    }

    /**
     *  List[0] -> root value
     *  List[1] -> left candidates
     *  List[2] -> right candidates
     */
    private static List<int[]> getNode(int[] inOrder, int[] preOrder) {
        List<int[]> list = new ArrayList<>();
        for (int p=0 ; p< preOrder.length; p++) {
            for (int i = 0; i < inOrder.length; i++) {
                if (preOrder[p] == inOrder[i]) {
                    // Root array.
                    int[] root = new int[1];
                    root[0] = inOrder[i];

                    // Left candidates
                    int[] leftCandidates = new int[i];
                    for (int k = 0; k < i; k++) {
                        leftCandidates[k] = inOrder[k];
                    }

                    //Right candidates
                    int[] rightCandidates = new int[inOrder.length - (i+1)];
                    int l =0;
                    for (int k = i+1 ; k < inOrder.length; k++) {
                        rightCandidates[l] = inOrder[k];
                        l++;
                    }

                    list.add(root);
                    list.add(leftCandidates);
                    list.add(rightCandidates);
                    return list;
                }
            }
        }

        return null;
    }
}
