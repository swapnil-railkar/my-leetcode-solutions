package com.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P2975 {
	public int solution(int hEnd, int vEnd, int[] hFences, int[] vFences) {
        Set<Integer> hDiffs = getLineDiffs(hEnd, hFences);
        Set<Integer> vDiffs = getLineDiffs(vEnd, vFences);

        Set<Integer> commonDiffs = new HashSet<>(hDiffs);
        commonDiffs.retainAll(vDiffs);

        long length = -1L;
        int mod = 1_000_000_007;
        for(int diff : commonDiffs) {
            length = Math.max(diff, length);
        }

        if(length == - 1L) {
            return -1;
        } else {
            long area = (length * length) % mod;
            return (int) area;
        }
    }

    private Set<Integer> getLineDiffs(int end, int[] fences) {
        List<Integer> lines = new ArrayList<>();
        Arrays.sort(fences);
        lines.add(1);
        for(int fence : fences) {
            lines.add(fence);
        }
        lines.add(end);

        Set<Integer> diffs = new HashSet<>();
        for(int i = 0; i< lines.size(); i++) {
            for(int j = i + 1; j< lines.size(); j++) {
                diffs.add(Math.abs(lines.get(j) - lines.get(i)));
            }
        }
        return diffs;
    }
}
