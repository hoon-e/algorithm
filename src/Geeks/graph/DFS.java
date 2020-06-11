package Geeks.graph;

import java.io.*;
import java.util.*;

public class DFS {
    private int V;

    private LinkedList<Integer>[] adj;

    DFS(int V){
        this.V = V;
        adj = new LinkedList[V];

        for(int i=0; i<V; i++)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int v, int w){
        adj[v].add(w);
    }

    void DFSfunction(int v, boolean[] vst){
        vst[v] = true;
        System.out.println(v + " ");

        Iterator<Integer> i = adj[v].listIterator();

        while(i.hasNext()){
            int n = i.next();

            if(!vst[n])
                DFSfunction(n, vst);
        }
    }

    void DFSstart(int v){
        boolean[] vst = new boolean[V];

        DFSfunction(v, vst);
    }

    public static void main(String[] args) throws IOException {
        DFS dfs = new DFS(4);

        dfs.addEdge(0, 1);
        dfs.addEdge(0, 2);
        dfs.addEdge(1, 2);
        dfs.addEdge(2, 0);
        dfs.addEdge(2, 3);
        dfs.addEdge(3, 3);

        System.out.println("Following is DFS started with vertex 2");

        dfs.DFSstart(2);
    }
}
