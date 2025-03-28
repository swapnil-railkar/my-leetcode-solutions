package com.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class P2503 {

	public int[] solution(int[][] grid, int[] queries) {
		TreeSet<Integer> querySet = new TreeSet<>();
		Map<Integer, Integer> queryCountMap = new HashMap<>();
		int minReq = grid[0][0];
		for(int query : queries) {
			if(query > minReq) {
				querySet.add(query);
			}
			queryCountMap.put(query, 0);
		}

		if(!querySet.isEmpty()) {
			PriorityQueue<Wrapper> q = new PriorityQueue<>((a, b) -> Integer.compare(a.value, b.value));
            boolean[][] visited = new boolean[grid.length][grid[0].length];
			q.add(new Wrapper(grid[0][0], 0, 0));
			int prevQuery = -1;
			for(int query : querySet) {
				int count = getBfsCount(q, grid, visited, query, new ArrayList<>());
				if(prevQuery == -1) {
					queryCountMap.put(query, count);
				} else {
					queryCountMap.put(query, count + queryCountMap.get(prevQuery));
				}
				prevQuery = query;
			}		
		}

		int[] answer = new int[queries.length];
		for(int i = 0; i< answer.length; i++) {
			answer[i] = queryCountMap.get(queries[i]);
		}

		return answer;
	}

	private int getBfsCount(PriorityQueue<Wrapper> q, int[][] grid, boolean[][] visited, int key, List<Integer> members) {
		if (q.isEmpty() || q.peek().value >= key) {
			return members.size();
		}
		Wrapper node = q.remove();
		int value = node.value;
		int row = node.row;
		int column = node.column;
		if (!visited[row][column]) {
			visited[row][column] = true;
			members.add(value);
			// add neighbors to queue.
			if (row > 0) {
				// up
				int upRow = row - 1;
				if(!visited[upRow][column]) {
					q.add(new Wrapper(grid[upRow][column], upRow, column));
				}
			}
			if (row < grid.length - 1) {
				// down
				int downRow = row + 1;
				if(!visited[downRow][column]) {
					q.add(new Wrapper(grid[downRow][column], downRow, column));
				}
			}
			if (column > 0) {
				// left
				int leftColumn = column - 1;
				if(!visited[row][leftColumn]) {
					q.add(new Wrapper(grid[row][leftColumn], row, leftColumn));
				}
			}
			if (column < grid[0].length - 1) {
				// right
				int rightColumn = column + 1;
				if(!visited[row][rightColumn]) {
					q.add(new Wrapper(grid[row][rightColumn], row, rightColumn));
				}
			}
		}

		return getBfsCount(q, grid, visited, key, members);
	}
	
	private static class Wrapper {
		int value;
		int row;
		int column;

		Wrapper(int value,int row, int column) {
			this.value = value;
			this.row = row;
			this.column = column;
		}
	}
}
