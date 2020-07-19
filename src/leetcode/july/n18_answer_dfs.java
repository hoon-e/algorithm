package leetcode.july;

import java.io.*;
import java.util.*;

public class n18_answer_dfs {
    // 이 풀이에서는 색깔로 노드의 방문형태를 표현했다.
    static int WHITE = 1;
    static int GRAY = 2;
    static int BLACK = 3;

    boolean isPossible;
    Map<Integer, Integer> color;
    Map<Integer, List<Integer>> adjList;
    List<Integer> topologicalOrder;

    private void init(int numCourses) {
        this.isPossible = true;
        this.color = new HashMap<>();
        this.adjList = new HashMap<>();
        this.topologicalOrder = new ArrayList<>();

        // 노드들의 컬러를 흰색으로 초기화합니다.
        for(int i=0; i<numCourses; i++) {
            this.color.put(i, WHITE);
        }
    }

    private void dfs(int node) {
        if(!this.isPossible)
            return;

        this.color.put(node, GRAY);

        for(int next : this.adjList.getOrDefault(node, new ArrayList<>())) {
            if(this.color.get(next) == WHITE)
                this.dfs(next);
            else if(this.color.get(next) == GRAY)
                // 인접을 타고 들어가다가 GRAY인 정점이 있다면, 사이클이 존재하는 것이다.
                this.isPossible = false;
        }

        // 재귀가 끝나면, 노드의 색깔을 검은색으로 한다.
        this.color.put(node, BLACK);
        this.topologicalOrder.add(node);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        this.init(numCourses);

        for(int i=0; i<prerequisites.length; i++) {
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];

            List<Integer> list = adjList.getOrDefault(src, new ArrayList<>());
            list.add(dest);
            adjList.put(src, list);
        }

        for(int i=0; i<numCourses; i++) {
            if( this.color.get(i) == WHITE ) {
                this.dfs(i);
            }
        }

        int[] order;
        if(this.isPossible) {
            order = new int[numCourses];
            for(int i=0; i<numCourses; i++) {
                order[i] = this.topologicalOrder.get(numCourses - i - 1);
            }
        } else
            order = new int[0];

        return order;
    }
}
