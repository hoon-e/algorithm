package Geeks.graph;

import java.io.*;
import java.util.*;

/*
Minimum spanning tree
Spanning tree란 방향이 없는 그래프에서, 모든 정점을 잇는 부분 그래프를 의미한다.
그 중에서도 가장 간선의 무게가 적게 나가는 Spanning tree를 MST라 한다.

1. 모든 간선들을 증가하지 않는 순서로 정렬한다.
2. 가장 작은 간선을 선택한다. 간선이 cycle을 형성하는 지 확인한다. cycle이 없다면, 간선을 추가한다. 아니라면, 버린다.
3. (V-1) 개의 간선이 있을 때까지 반복한다.
 */

public class MST {
    static class Edge implements Comparable<Edge> {
        int src, dst, weight;

        public int compareTo(Edge e){
            return this.weight - e.weight;
        }
    }

    static class subset {
        int parent, rank;
    }

    // 정점의 개수와, 간선의 개수
    int V, E;
    // 모든 간선들
    Edge[] edges;

    MST(int v, int e){
        V = v;
        E = e;
        edges = new Edge[E];
        for(int i=0; i<E; i++){
            edges[i] = new Edge();
        }
    }

    // Disjoint-set : find algorithm
    int Find(subset[] subsets, int val){
        if(subsets[val].parent == val)
            return val;
        else
            return subsets[val].parent = Find(subsets, subsets[val].parent);
    }

    // Union
    void Union(subset[] subsets, int x, int y){
        int px = Find(subsets, x);
        int py = Find(subsets, y);

        // Rank로 합집합을 구한다.
        if(subsets[px].rank < subsets[py].rank)
            subsets[px].parent = py;
        else if(subsets[px].rank > subsets[py].rank)
            subsets[py].parent = px;
        // Rank가 같다면, 하나를 parent로 만들고, rank를 하나 증가시킨다.
        else{
            subsets[py].parent = px;
            ++subsets[px].rank;
        }
    }

    void KruskalMST(){
        Edge[] result = new Edge[V];

        for(int i=0; i<V; i++)
            result[i] = new Edge();

        // 1. 간선의 가중치를 가지고 정렬한다.
        Arrays.sort(edges);

        // 부분 집합을 생성한다.
        subset[] subsets = new subset[V];

        for(int i=0; i<V; i++)
            subsets[i] = new subset();

        for(int v = 0; v < V; v++){
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        int e = 0;
        int i = 0;
        while(e < V-1){
            // 가장 작은 가중치를 가지는 간선을 선택한다.
            Edge nextEdge = new Edge();
            nextEdge = edges[i++];

            int px = Find(subsets, nextEdge.src);
            int py = Find(subsets, nextEdge.dst);

            // 싸이클이 존재하지 않는다면, 결과에 추가하고, result배열의 인덱스를 추가한다.
            if( px != py ){
                result[e++] = nextEdge;
                Union(subsets, px, py);
            }
        }

        System.out.println("\nResult of MST");

        for(int a=0; a<e; a++)
            System.out.println(result[a].src + " => " + result[a].dst + " = " + result[a].weight);
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int V = 4;
        int E = 5;

        MST graph = new MST(V, E);

        for(int i=0; i<E; i++){
            StringTokenizer st = new StringTokenizer(scn.nextLine());

            graph.edges[i].src = Integer.parseInt(st.nextToken());
            graph.edges[i].dst = Integer.parseInt(st.nextToken());
            graph.edges[i].weight = Integer.parseInt(st.nextToken());
        }

        graph.KruskalMST();
    }
}
