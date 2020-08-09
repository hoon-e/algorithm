package RE.graph;

import java.util.*;
import java.io.*;

// 크루스칼. 최소 스패닝 트리
public class n1197 {
    static class Edge implements Comparable<Edge>{
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public int compareTo(Edge e){
            return weight - e.weight;
        }
    }

    static int V, E;
    static int[] parent, rank;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        parent = new int[V+1];
        rank = new int[V+1];
        Edge[] edges = new Edge[E];

        for(int i=1; i<=V; i++) parent[i] = i;

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(from, to, weight);
        }

        Arrays.sort(edges);

        int e=0, idx=0;
        long answer = 0;

        while(e < V-1) {
            Edge cur = edges[idx++];

            int from = find(cur.from);
            int to = find(cur.to);

            if(from != to) {
                union(from, to);
                answer += cur.weight;
                ++e;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int find(int val) {
        return (val == parent[val]) ? val : (parent[val] = find(parent[val]));
    }

    private static void union(int u, int v){
        u = find(u);
        v = find(v);

        if(u == v) return;
        if(rank[u] < rank[v]) parent[u] = v;
        else parent[v] = u;
        if(rank[u] == rank[v]) ++rank[v];
    }
}
