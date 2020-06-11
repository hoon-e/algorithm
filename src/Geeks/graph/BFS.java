package Geeks.graph;

import java.io.*;
import java.util.*;

/*
Breadth First Traversal
 */

public class BFS {
    private int V;
    private LinkedList<Integer>[] adj;

    BFS(int v){
        V = v;
        adj = new LinkedList[v];

        for(int i=0; i<v; i++)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int u, int v){
        adj[u].add(v);
    }

    void bfs(int start){
        boolean[] vst = new boolean[V];

        // Create Queue
        Queue<Integer> queue = new LinkedList<>();

        vst[start] = true;
        queue.add(start);

        while(!queue.isEmpty()){
            int cur = queue.poll();
            System.out.print(cur + " ");

            for(int next : adj[cur]){
                if(!vst[next]){
                    vst[next] = true;
                    queue.add(next);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        BFS bfs = new BFS(4);

        bfs.addEdge(0, 1);
        bfs.addEdge(0, 2);
        bfs.addEdge(1, 2);
        bfs.addEdge(2, 0);
        bfs.addEdge(2, 3);
        bfs.addEdge(3, 3);

        System.out.println("Following BFS starting from vertex 2 ");
        bfs.bfs(2);

        in.close();
        out.close();
    }
}
