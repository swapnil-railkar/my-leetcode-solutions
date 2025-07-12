package com.leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P1900 {
	public int[] earliestAndLatest(int n, int fp, int sp) {
        Set<Integer> rounds = new HashSet<>();
        List<Integer> state = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            state.add(i);
        }
        getRounds(state, 1, new HashSet<>(), rounds, fp, sp);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int round : rounds) {
            min = Math.min(min, round);
            max = Math.max(max, round);
        }
        return new int[] { min, max };
    }

    private void getRounds(List<Integer> state, int round, Set<List<Integer>> cache, Set<Integer> rounds, int fp,
            int sp) {
        if (!cache.contains(state)) {
            cache.add(state);
            int fpIndex = getIndex(fp, state);
            int spIndex = getIndex(sp, state);
            if (spIndex == (state.size() - 1) - fpIndex) {
                rounds.add(round);
            }
            List<List<Integer>> nextStates = getNextStates(state, fp, sp);
            for (List<Integer> s : nextStates) {
                getRounds(s, round + 1, cache, rounds, fp, sp);
            }
        }
    }

    private List<List<Integer>> getNextStates(List<Integer> currState, int fp, int sp) {
        if (currState.size() <= 1) {
            return Collections.emptyList();
        }
        List<List<Integer>> states = new ArrayList<>();
        int li = 0, ri = currState.size() - 1;
        while (li <= ri) {
            if (states.isEmpty()) {
                if (currState.get(li) == fp) {
                    List<Integer> lw = new ArrayList<>();
                    lw.add(currState.get(li));
                    states.add(lw);
                } else if (currState.get(ri) == sp) {
                    List<Integer> rw = new ArrayList<>();
                    rw.add(currState.get(ri));
                    states.add(rw);
                } else {
                    List<Integer> lw = new ArrayList<>();
                    lw.add(currState.get(li));
                    states.add(lw);
                    List<Integer> rw = new ArrayList<>();
                    rw.add(currState.get(ri));
                    states.add(rw);
                }
            } else {
                List<List<Integer>> newStates = new ArrayList<>();
                for (List<Integer> state : states) {
                    if (currState.get(li) == fp) {
                        List<Integer> lw = new ArrayList<>(state);
                        lw.add(currState.get(li));
                        newStates.add(lw);
                    } else if (currState.get(ri) == sp) {
                        List<Integer> rw = new ArrayList<>(state);
                        rw.add(currState.get(ri));
                        newStates.add(rw);
                    } else {
                        List<Integer> lw = new ArrayList<>(state);
                        lw.add(currState.get(li));
                        newStates.add(lw);
                        List<Integer> rw = new ArrayList<>(state);
                        rw.add(currState.get(ri));
                        newStates.add(rw);
                    }
                    states = newStates;
                }
            }
            li++;
            ri--;
        }
        for (List<Integer> state : states) {
            Collections.sort(state);
        }
        return states;
    }

    private int getIndex(int key, List<Integer> list) {
        int start = 0, end = list.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (list.get(mid) == key) {
                return mid;
            } else if (list.get(mid) < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
