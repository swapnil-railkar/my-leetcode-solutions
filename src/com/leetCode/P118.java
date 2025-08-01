package com.leetCode;

import java.util.ArrayList;
import java.util.List;

public class P118 {

	public List<List<Integer>> solution(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        // 1st row
        row.add(1);
        ans.add(row);
        if (numRows == 1) {
            return ans;
        } else {
            List<Integer> prev = new ArrayList<>();
            // 2nd row
            prev.add(1);
            prev.add(1);
            ans.add(prev);
            for(int i = 2; i< numRows; i++) {
                List<Integer> curr = new ArrayList<>();
                curr.add(1);
                for(int j = 1; j< prev.size(); j++) {
                    int sum = prev.get(j) + prev.get(j - 1);
                    curr.add(sum);
                }
                curr.add(1);
                ans.add(curr);
                prev = curr;
            }
        }
        return ans;
    }

}
