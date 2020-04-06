package BOJ.dijkstra;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
    int vertex;
    int weight;

    Edge(int vertex, int weight){
        this.vertex = vertex;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge e){
        return this.weight - e.weight;
    }
}

public class N1753 {
    static int E;
    static int V;
    static ArrayList<Edge>[] graph;
    static int[] dist;
    static final int INF = Integer.MAX_VALUE-100;
    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);

        V = scn.nextInt();
        E = scn.nextInt();
        dist = new int[V+1];
        graph = new ArrayList[V+1];
        int start = scn.nextInt();

        for(int i=1; i<=V; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = INF;
        }

        for(int i=0; i<E; i++){
            int e = scn.nextInt();
            int j = scn.nextInt();
            int w = scn.nextInt();

            graph[e].add(new Edge(j,w));
        }

        dijkstra(start);

        for(int i=1; i<=V; i++){
            if(dist[i] == INF)
                System.out.println("INF");
            else
                System.out.println(dist[i]);
        }
        scn.close();
    }

    public static void dijkstra(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        dist[start] = 0;

        // 다익스트라 사용시에 처음 노드를 꼭 넣어주어야한다. 아니 이거 시작점 꼭 큐에 넣어줘야된다... 아가야...
        pq.offer(new Edge(start, dist[start]));

        for(Edge n : graph[start]){
            int now = n.vertex;
            int n_dist = n.weight;
            dist[now] = n_dist;
            pq.offer(new Edge(now, dist[now]));
        }

        while(!pq.isEmpty()){
            Edge now = pq.poll();
            int curVtx = now.vertex;
            int curDist = now.weight;

            if(curDist != dist[curVtx]) continue;
            for(Edge g : graph[curVtx]){
                int nextVtx = g.vertex;
                int nextDist = g.weight;

                if(nextDist + curDist < dist[nextVtx]){
                    dist[nextVtx] = nextDist + curDist;
                    pq.offer(new Edge(nextVtx, dist[nextVtx]));
                }
            }
        }
    }
}
