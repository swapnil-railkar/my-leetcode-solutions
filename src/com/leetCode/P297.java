package com.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.leetCode.DsNodes.TreeNode;

public class P297 {
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (Objects.isNull(root)) {
            return "[]";
        }
        List<TreeNode> firstRow = new ArrayList<>();
        firstRow.add(root);
        List<Integer> value = new ArrayList<>();
        value.add(root.val);
        List<List<Integer>> values = new ArrayList<>();
        values.add(value);
        getLOT(firstRow, values);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (List<Integer> row : values) {
            for (Integer val : row) {
                if (Objects.isNull(val)) {
                    sb.append(",null");
                } else {
                    if(sb.length() == 1) {
                        sb.append(val);
                    } else {
                        sb.append("," + val);
                    }
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private void getLOT(List<TreeNode> currRow, List<List<Integer>> lot) {
        if (currRow.isEmpty()) {
            return;
        }
        List<Integer> values = new ArrayList<>();
        List<TreeNode> nextRow = new ArrayList<>();
        for (TreeNode node : currRow) {
            Integer leftValue = Objects.isNull(node.left) ? null : node.left.val;
            Integer rightValue = Objects.isNull(node.right) ? null : node.right.val;
            values.add(leftValue);
            values.add(rightValue);
            if (Objects.nonNull(node.left)) {
                nextRow.add(node.left);
            }
            if (Objects.nonNull(node.right)) {
                nextRow.add(node.right);
            }
        }
        lot.add(values);
        getLOT(nextRow, lot);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        StringBuilder dataStr = new StringBuilder(data);
        dataStr.deleteCharAt(0);
        dataStr.deleteCharAt(dataStr.length() - 1);
        String nodeStr = dataStr.toString();
        if (nodeStr.isEmpty()) {
            return null;
        }
        String[] nodes = nodeStr.split(",");
        List<TreeNode> tree = new ArrayList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        tree.add(root);
        populateTree(tree, nodes, 1);
        return root;
    }

    private void populateTree(List<TreeNode> currRow, String[] nodes, int index) {
        if (index >= nodes.length) {
            return;
        }
        List<TreeNode> nextRow = new ArrayList<>();
        for (TreeNode node : currRow) {
            if (index >= nodes.length) {
                break;
            } else {
                if (!nodes[index].equals("null")) {
                    TreeNode leftNode = new TreeNode(Integer.parseInt(nodes[index]));
                    node.left = leftNode;
                    nextRow.add(leftNode);
                }
                index++;
            }

            if (index >= nodes.length) {
                break;
            } else {
                if (!nodes[index].equals("null")) {
                    TreeNode rightNode = new TreeNode(Integer.parseInt(nodes[index]));
                    node.right = rightNode;
                    nextRow.add(rightNode);
                }
                index++;
            }
        }
        populateTree(nextRow, nodes, index);
    }
}
