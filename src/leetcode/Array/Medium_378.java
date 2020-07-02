package leetcode.Array;

import java.util.Comparator;
import java.util.PriorityQueue;

//矩阵中的第K小元素
public class Medium_378 {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>(){ //大顶堆
            @Override
            public int compare(Integer i1,Integer i2){
                return i2-i1;
            }
        });
        int m = matrix.length, n = matrix[0].length;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (maxHeap.size() == k) {
                    if (matrix[i][j] < maxHeap.peek()) {
                        maxHeap.poll();
                        maxHeap.add(matrix[i][j]);
                    }
                } else {
                    maxHeap.add(matrix[i][j]);
                }
            }
        }
        return maxHeap.peek();
    }

    //归并排序
    public int kthSmallest2(int[][] matrix, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>(){ //大顶堆
            @Override
            public int compare(int[] a, int[] b){
                return a[0]-b[0];
            }
        });
        int m = matrix.length, n = matrix[0].length;
        //存储第一列元素
        for (int i=0; i<m; i++) {
            //存储元素值以及所在行列
            minHeap.add(new int[]{matrix[i][0], i, 0});
        }

        //横向寻找元素,将前k-1个小的移出堆，剩下的就是第k小的
        for (int i=0; i<k-1; i++) {
            int[] now = minHeap.poll();
            if (now[2] != n-1) {
                int row = now[1];
                int col = now[2] + 1;
                minHeap.offer(new int[]{matrix[row][col], row, col});
            }
        }
        return minHeap.peek()[0];
    }
    //二分法
    public int kthSmallest3(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n-1][n-1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(matrix, mid, k, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int[][] matrix, int mid, int k, int n) {
        int i = n-1;
        int j = 0;
        int count = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                count += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return count >= k;
    }
}
