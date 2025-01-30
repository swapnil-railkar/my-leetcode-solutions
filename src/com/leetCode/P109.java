package com.leetCode;

import com.leetCode.DsNodes.ListNode;
import com.leetCode.DsNodes.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class P109 {

    public static void main(String[] args) {

        int[] arr = {-10,-3,0,5,9};
        ListNode head = new ListNode(arr[0]);
        ListNode prev = head;
        for (int i =1; i< arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            prev.next = node;
            prev = node;
        }

        TreeNode root = sortedListToBST(head);
        P102_2 op = new P102_2();
        op.printTree(root);

    }

    private static TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = getArrayFromList(head);
        return convertListToTree(list, null, 0, list.size() - 1);
    }

    private static TreeNode convertListToTree(List<Integer> list, TreeNode root, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return root;
        }

        if (endIndex == startIndex + 2) {
            int mid = (startIndex + endIndex) / 2;
            TreeNode subTree = new TreeNode(list.get(mid));
            subTree.left = new TreeNode(list.get(startIndex));
            subTree.right = new TreeNode(list.get(endIndex));
            return subTree;
        } else if (endIndex == startIndex + 1) {
            TreeNode subTree = new TreeNode(list.get(endIndex));
            subTree.left = new TreeNode(list.get(startIndex));
            return subTree;
        } else if (startIndex == endIndex) {
            return new TreeNode(list.get(startIndex));
        }

        int mid;
        if ((startIndex + endIndex) %2 == 0) {
            mid = (startIndex + endIndex) / 2;
        } else {
            mid = ((startIndex + endIndex) / 2) + 1;
        }

        if (Objects.isNull(root)) {
            root = new TreeNode(list.get(mid));
        }

        root.left = convertListToTree(list, root.left,startIndex, mid -1);
        root.right = convertListToTree(list, root.right, mid + 1, endIndex);

        return root;
    }

    private static List<Integer> getArrayFromList(ListNode head) {
        List<Integer> list = new ArrayList<>();

        while (head.next != null) {
            list.add(head.val);
            head = head.next;
        }
        list.add(head.val);

        return list;
    }
}
