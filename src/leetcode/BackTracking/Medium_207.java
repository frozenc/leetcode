package leetcode.BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//课程表问题
public class Medium_207 {
    //DFS+递归，构建邻接矩阵，如果遇到当前路径走过的，说明存在环，如果遇到前面路径走过的，直接跳过
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i=0; i<numCourses; i++) {
            adjacency.add(new ArrayList<Integer>());
        }
        for (int[] cp:prerequisites) {
            adjacency.get(cp[1]).add(cp[0]);
        }
        int[] flags = new int[numCourses];
        for (int i=0; i<numCourses; i++) {
            if(!dfs(adjacency, flags, i)) return false;
        }
        return true;
    }

    public boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
        if (flags[i] == 1) return false;
        if (flags[i] == -1) return true;

        flags[i] = 1;
        for (Integer j:adjacency.get(i)) {
            if(!dfs(adjacency, flags, j)) return false;
        }
        flags[i] = -1;
        return true;
    }

    //寻找0入度的点，移除，不停移除，如果有剩余的点未能移除，说明图中存在环，即课程表无效
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i=0; i<numCourses; i++) {
            adjacency.add(new ArrayList<Integer>());
        }
        int[] indegrees = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for (int[] cp:prerequisites) {
            indegrees[cp[0]] ++;
            adjacency.get(cp[1]).add(cp[0]);
        }
        for (int i=0; i<numCourses; i++) {
            if (indegrees[i] == 0) queue.add(i);
        }
        while(!queue.isEmpty()) {
            int i = queue.poll();
            numCourses --;
            for (int j:adjacency.get(i)) {
                if(--indegrees[j] == 0) queue.add(j);
            }
        }
        return numCourses == 0;
    }
}
