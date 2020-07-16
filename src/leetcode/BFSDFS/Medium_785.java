package leetcode.BFSDFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Medium_785 {
    public final static int UNCOLOR = 0;
    public final static int RED = 1;
    public final static int GREEN = 2;

    //BFS
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, UNCOLOR);
        for (int i=0; i<n; i++) {
            if (color[i] == UNCOLOR) {
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                color[i] = RED;
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    int otherColor = color[node] == RED ? GREEN : RED;
                    for (int neighbour:graph[node]) {
                        if (color[neighbour] == UNCOLOR) {
                            color[neighbour] = otherColor;
                            queue.offer(neighbour);
                        } else if (color[neighbour] != otherColor) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean valid;
    public boolean isBipartite2(int[][] graph) {
        valid = true;
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, UNCOLOR);
        for (int i=0; i<graph.length; i++) {
            if (color[i] == UNCOLOR) {
                dfs(graph, color, i, RED);
            }
        }
        return valid;
    }

    public void dfs(int[][] graph, int[] color, int node, int c) {
        color[node] = c;
        int otherColor = c == RED ? GREEN : RED;
        for (int neighbour:graph[node]) {
            if (color[neighbour] == UNCOLOR) {
                dfs(graph, color, neighbour, otherColor);
                if(!valid) {
                    return;
                }
            } else if (color[neighbour] != otherColor) {
                valid = false;
                return;
            }
        }
    }
}
