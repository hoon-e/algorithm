package leetcode.july;

import java.io.*;
import java.util.*;

public class n18 {
    boolean[] vst;
    ArrayList<Integer>[] graph;
    ArrayList<Integer> ans;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        graph = new ArrayList[numCourses];
        ans = new ArrayList<>();

        for(int i=0; i<numCourses; i++)
            graph[i] = new ArrayList<Integer>();

        vst = new boolean[numCourses];

        for(int i=0; i<numCourses; i++)
            graph[prerequisites[i][1]].add(prerequisites[i][0]);

        for(int i=0; i<numCourses; i++) {
            if(!vst[i])
                dfs(i);
        }

        int[] empty = new int[1];
        int[] answer = new int[numCourses];

        if(ans.size() != numCourses) {
            return empty;
        } else {
            int idx = 0;
            for(int n : ans) {
                answer[idx++] = n;
            }
            return answer;
        }
    }

    public void dfs(int val) {
        vst[val] = true;
        ans.add(val);

        for(int next : graph[val]){
            if(!vst[next]) {
                dfs(next);
            }
        }
    }
}
