package Geeks.graph;

import java.io.*;
import java.util.*;

/*
Handling a corner case.
DFS code traverses only the vertices reachable from a given source vertex.
Time Complexity : O(V+E)
Space Complexity : O(V)
 */

public class DisconnectedDFS {
    static private int V;
    static private LinkedList<Integer>[] adj;
    static private boolean[] vst;

    DisconnectedDFS(int v){
        V = v;
        adj = new LinkedList[v];
        vst = new boolean[v];

        for(int i=0; i<v; i++)
            adj[i] = new LinkedList<Integer>();
    }

    void addEdge(int u, int v){
        adj[u].add(v);
    }

    void DFS(int v){
        vst[v] = true;
        System.out.println("Visit " + v);

        Iterator<Integer> iter = adj[v].iterator();

        while(iter.hasNext()){

            int next = iter.next();
            if(!vst[next]){
                DFS(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int V = 4;
        DisconnectedDFS dfs = new DisconnectedDFS(V);

        dfs.addEdge(0, 1);
        dfs.addEdge(0, 2);
        dfs.addEdge(1, 2);
        dfs.addEdge(2, 0);
        dfs.addEdge(2, 3);
        dfs.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal");

        for(int i=0; i<V; i++){
            if(!vst[i])
                dfs.DFS(i);
        }
    }
}
