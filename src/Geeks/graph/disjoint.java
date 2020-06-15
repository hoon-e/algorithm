package Geeks.graph;

import java.io.*;
import java.util.*;

/*
Disjoint Set 자료구조는 겹치지 않는 부분집합으로 요소들을 나누는 알고리즘이다.
union-find 알고리즘을 사용한다.

find : 어떤 부분집합의 요소인지를 파악한다. 두 개의 요소가 같은 부분집합에 속하는지 파악한다.
union : 두개의 부분집합을 하나의 부분집합으로 합친다.
 */

public class disjoint {
    static class Edge {
        int src;
        int dest;
    }

    int V, E;
    Edge[] edge;

    disjoint(int v, int e){
        V = v;
        E = e;
        edge = new Edge[E];

        for(int i=0; i<E; i++)
            edge[i] = new Edge();
    }

    // i의 부모를 찾는 함수
    int find(int[] parent, int i){
        if(parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }

    // 두개의 부분집합을 합치는 함수
    void union(int[] parent, int x, int y){
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }

    int isCycle(disjoint graph){
        int[] parent = new int[graph.V];

        Arrays.fill(parent, -1);

        for(int i=0; i<graph.E; i++){
            int x = graph.find(parent, graph.edge[i].src);
            int y = graph.find(parent, graph.edge[i].dest);

            if(x == y)
                return 1;

            graph.union(parent, x, y);
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int V = 3, E = 3;

        disjoint graph = new disjoint(V, E);

        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;

        graph.edge[1].src = 1;
        graph.edge[1].dest = 2;

        graph.edge[2].src = 0;
        graph.edge[2].dest = 2;

        if(graph.isCycle(graph) == 1)
            System.out.println("graph contains cycle");
        else
            System.out.println("graph doesn't contain cycle");

        in.close();
        out.close();
    }
}
