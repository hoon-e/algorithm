package Geeks.graph;

import java.io.*;
import java.util.*;

/*
DFS와 위상정렬의 차이점
DFS는 인접해있는 정점들을 모두 출력한다.
위상정렬은 인접한 정점을 모두 출력하기 이전에, 출력해주어야하는 정점들을 출력을 해주어야한다.

1. 재귀적으로 위상정렬을 호출하고, 스택에 추가해주어야한다.
2. 스택에 있는 정점들을 출력해준다.( 스택에는 정점이 인접해있을 경우에만 추가해준다. )
 */

public class TopologicalSort {
    private int V;

    private ArrayList<ArrayList<Integer>> adj;

    TopologicalSort(int v){
        this.V = v;
        adj = new ArrayList<ArrayList<Integer>>(v);

        for(int i=0; i<v; i++)
            adj.add(new ArrayList<>());
    }

    void addEdge(int v, int w){
        adj.get(v).add(w);
    }

    void topologicalSortUtil(int v, boolean[] vst, Stack<Integer> stack){
        vst[v] = true;
        int i;

        for (Integer integer : adj.get(v)) {
            i = integer;
            if (!vst[i]) {
                topologicalSortUtil(i, vst, stack);
            }
        }

        stack.push(v);
    }

    void topologiclSort(){
        Stack<Integer> stack = new Stack<>();

        boolean[] vst = new boolean[V];

        for(int i=0; i<V; i++)
            vst[i] = false;

        for(int i=0; i<V; i++){
            if(!vst[i])
                topologicalSortUtil(i, vst, stack);
        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
}
