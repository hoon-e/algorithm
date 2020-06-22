package BOJ.graph;

import java.io.*;
import java.util.*;

// MST
public class n1922 {
    static class edge implements Comparable<edge>{
        int src;
        int dst;
        int weight;

        public int compareTo(edge e){
            return this.weight - e.weight;
        }
    }

    static int N;
    static int M;
    static int[] parent;
    static edge[] edges;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(in.readLine());
        M = Integer.parseInt(in.readLine());
        parent = new int[N+1];

        edges = new edge[M];

        for(int i=0; i<M; i++)
            edges[i] = new edge();

        for(int i=1; i<=N; i++)
            parent[i] = i;

        for(int i=0; i<M; i++){
            st = new StringTokenizer(in.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges[i].src = v;
            edges[i].dst = u;
            edges[i].weight = w;
        }

        out.write(kruskal()+"");
        out.flush();
        in.close();
        out.close();
    }

    static int kruskal(){
        edge[] result = new edge[N];

        for(int i=0; i<N; i++)
            result[i] = new edge();

        Arrays.sort(edges);

        int e = 0;
        int i = 0;

        while(e < N-1){
            edge nextEdge = edges[i++];

            int px = find(nextEdge.src);
            int py = find(nextEdge.dst);

            if(px != py){
                result[e++] = nextEdge;
                union(px, py);
            }
        }

        int sum = 0;
        for(edge ed : result){
            sum += ed.weight;
        }

        return sum;
    }

    static int find(int val){
        if(val == parent[val])
            return val;
        else
            return parent[val] = find(parent[val]);
    }

    static void union(int u, int v){
        u = parent[u];
        v = parent[v];

        if(u != v){
            parent[v] = u;
        }
    }
}
