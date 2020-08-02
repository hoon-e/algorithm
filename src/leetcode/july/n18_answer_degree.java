package leetcode.july;

import java.io.*;
import java.util.*;

public class n18_answer_degree {
    // TODO: 위상정렬
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean isPossible = true;
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        int[] indegree = new int[numCourses];
        int[] topologicalOrder = new int[numCourses];

        for ( int[] prerequisite : prerequisites ) {
            int dst = prerequisite[0];
            int src = prerequisite[1];

            List<Integer> list = adjList.getOrDefault(src, new ArrayList<>());
            list.add(dst);
            adjList.put(src, list);

            ++indegree[dst];
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<numCourses; i++) {
            if(indegree[i] == 0)
                q.add(i);
        }

        int i = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            topologicalOrder[i++] = cur;

            if(adjList.containsKey(cur)) {
                for(int next : adjList.get(cur)) {
                    --indegree[next];

                    if(indegree[next] == 0) {
                        q.offer(next);
                    }
                }
            }
        }

        if(i == numCourses)
            return topologicalOrder;

        return new int[0];
    }
}
