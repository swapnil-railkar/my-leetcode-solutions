package com.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class P827 {

	public int solution(int[][] grid) {
		int rows = grid.length;
		int columns = grid[0].length;
		boolean[][] visited = new boolean[rows][columns];
		List<Wrapper> allGraphs = new ArrayList<>();

		for(int row = 0; row< rows; row++) {
			for(int column = 0; column < columns; column++) {
				if(!visited[row][column] && grid[row][column] != 0) {
					Set<List<Integer>> positions = new HashSet<>();
					Queue<List<Integer>> q = new LinkedList<>();
					q.add(List.of(row, column));
					Set<List<Integer>> graph = getGraph(positions, q, grid, visited);
					if(graph.size() == rows * columns) {
						return rows*columns;
					}
					allGraphs.add(new Wrapper(graph, graph.size()));
				}
			}
		}

		return getMaxSizedGraph(allGraphs, grid);	
	}

	private Set<List<Integer>> getGraph(Set<List<Integer>> positions, Queue<List<Integer>> q, int[][] grid, boolean[][] visited) {
        if (q.isEmpty()) {
            return positions;
        } else {
            List<Integer> pos = q.remove();
            int row = pos.get(0);
            int column = pos.get(1);
            if (!visited[row][column]) {
                positions.add(List.of(row, column));
                visited[row][column] = true;

                // add neighbors to queue
                if ((row - 1) >= 0 && grid[row - 1][column] != 0 && !visited[row - 1][column]) {
                    // up
                    q.add(List.of(row - 1, column));
                }
                if ((row + 1 < grid.length) && grid[row + 1][column] != 0 && !visited[row + 1][column]) {
                    // down
                    q.add(List.of(row + 1, column));
                }
                if ((column - 1 >= 0) && grid[row][column - 1] != 0 && !visited[row][column - 1]) {
                    // left
                    q.add(List.of(row, column - 1));
                }
                if ((column + 1 < grid[0].length) && grid[row][column + 1] != 0 && !visited[row][column + 1]) {
                    // right
                    q.add(List.of(row, column + 1));
                }

            }

            return getGraph(positions, q, grid, visited);
        }
    }

	private int getMaxSizedGraph(List<Wrapper> allGraphs, int[][] grid) {
		int rows = grid.length;
		int columns = grid[0].length;
		int max = 0;
		
		Map<List<Integer>, Wrapper> map = new HashMap<>();
		for(Wrapper obj : allGraphs) {
			for(List<Integer> index : obj.graph) {
				map.put(index, obj);
			}
		}

		for(int row = 0; row< rows; row++) {
			for(int column = 0; column< columns; column++) {
				if(grid[row][column] == 0) {
					Set<Wrapper> distinctGraphs = new HashSet<>();
					int totSize = 0;
					if((row - 1) >= 0 && grid[row -1][column] != 0) {
						// up
						Wrapper graph = map.get(List.of(row -1, column));
						if(graph != null) {
							distinctGraphs.add(graph);
						}
					}
					if((row + 1 < rows) && grid[row + 1][column] != 0) {
						// down
						Wrapper graph = map.get(List.of(row +1, column));
						if(graph != null) {
							distinctGraphs.add(graph);
						}
					}
					if((column - 1 >= 0) && grid[row][column - 1] != 0) {
						// left
						Wrapper graph = map.get(List.of(row, column - 1));
						if(graph != null) {
							distinctGraphs.add(graph);
						}
					}
					if((column + 1 < columns) && grid[row][column + 1] != 0) {
						// right
						Wrapper graph = map.get(List.of(row, column + 1));
						if(graph != null) {
							distinctGraphs.add(graph);
						}
					}
					
					for(Wrapper obj : distinctGraphs) {
						totSize += obj.size;
					}
					max = Math.max(max, totSize + 1);
				}
			}
		}
		return max;
	}
	
	
	
	private static class Wrapper {
		Set<List<Integer>> graph;
		int size;
		
		Wrapper(Set<List<Integer>> graph, int size) {
			this.graph = graph;
			this.size = size;
		}
	}

}
