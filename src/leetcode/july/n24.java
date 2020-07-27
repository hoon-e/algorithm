package leetcode.july;

import java.util.*;

// Source to Destination
// 간단한 재귀와 DFS를 이용한 아이디어 문제.
public class n24 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();

        dfs(graph, 0, graph.length-1, new ArrayList<Integer>(), ans);

        return ans;
    }

    public void dfs(int[][] graph, int src, int dest, List<Integer> temp, List<List<Integer>> ans) {
        if(src == dest)
            ans.add(temp);

        temp.add(src);

        for(int next : graph[src]) {
            // DFS에서 다음으로 넘겨주는 링크드리스트를, 현재의 링크드 리스트 말고 복사본을 넘겨주는 것이 트릭이다.
            ArrayList<Integer> linkNext = new ArrayList<>(temp);
            dfs(graph, next, dest, linkNext, ans);
        }
    }
}
