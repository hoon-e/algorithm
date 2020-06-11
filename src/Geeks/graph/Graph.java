package Geeks.graph;

import java.io.*;
import java.util.*;

// 노드라고 불리는 정점들의 유한한 집합이다.
// 순서가 있는 쌍인 (u, v) 의 유한한 집합을 edge라고 부른다.
// 방향이 있는 그래프에서 (u, v)와 (v, u)는 각각 다르다.

// 다음 두가지 방법으로 그래프를 나타낼 수 있다.
// 1. 인접 행렬 2. 인접 리스트
public class Graph {

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static void printGraph(ArrayList<ArrayList<Integer>> adj){
        for(int i=0; i<adj.size(); i++){
            System.out.println("\nAdjacency list of vertex " + i);
            System.out.print("head");
            for(int j=0; j<adj.get(i).size(); j++){
                System.out.print(" -> " + adj.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int V = 5;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);

        for(int i=0; i<V; i++)
            adj.add(new ArrayList<>());

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 4);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);

        printGraph(adj);

        out.flush();
        in.close();
        out.close();
    }
}
