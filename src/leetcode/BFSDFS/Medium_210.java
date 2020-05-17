package leetcode.BFSDFS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

//课程表
public class Medium_210 {
    //BFS拓扑排序，记录入度，入度为0进入队列，这个点指向的点入度-1，发现环队列为0
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        for (int[] pair : prerequisites) {
            indegree[pair[0]] ++;
        }

        int[] res = new int[numCourses];
        int idx = 0;

        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int c = queue.poll();
            res[idx++] = c;
            for (int[] pair : prerequisites) {
                if (pair[1] == c) {
                    indegree[pair[0]] --;
                    if (indegree[pair[0]] == 0) {
                        queue.offer(pair[0]);
                    }
                }
            }
        }
        return idx != numCourses ? new int[]{} : res;
    }
}
