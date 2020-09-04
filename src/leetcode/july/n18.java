package leetcode.july;

import java.io.*;
import java.util.*;

public class n18 {
    ArrayList<Integer>[] graph;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] degree = new int[numCourses+1];
        graph = new ArrayList[numCourses];

        for(int i=0; i<numCourses; i++)
            graph[i] = new ArrayList<>();

        for ( int[] prerequisite : prerequisites ) {
            graph[prerequisite[1]].add(prerequisite[0]);
            degree[prerequisite[0]]++;
        }

        Queue<Integer> result = topologicalSort(degree, numCourses);
        int[] ans;

        if(result.size() != numCourses) {
            ans = new int[0];
        } else {
            int idx = 0;
            ans = new int[numCourses];
            for(int n : result) {
                ans[idx++] = n;
            }
        }
        return ans;
    }

    public Queue<Integer> topologicalSort(int[] degree, int n) {
        Queue<Integer> queue = new LinkedList<Integer>();
        Queue<Integer> result = new LinkedList<Integer>();

        for(int i=0; i<n; i++) {
            if( degree[i] == 0 )
                queue.offer(i);
        }

        /* 큐에서 값을 꺼내고, 해당 노드가 가리키는 노드의 degree를 1감소
        만약 degree가 0이되면 큐에 넣는다. 큐가 빌때까지 반복한다.
        */

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            result.offer(cur);

            for(int next : graph[cur]) {
                degree[next]--;

                if(degree[next] == 0)
                    queue.offer(next);
            }
        }

        return result;
    }
}
