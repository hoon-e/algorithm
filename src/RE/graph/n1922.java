package RE.graph;

import java.util.*;
import java.io.*;

public class n1922 {
    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int weight;

        Edge() {}
        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public int compareTo(Edge e){
            return weight - e.weight;
        }
    }

    static int N, M;
    static int[] parent, rank;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        Edge[] edges = new Edge[M];
        parent = new int[N+1];
        rank = new int[N+1];

        for(int i=0; i<M; i++) { // 간선 정보 입력
            StringTokenizer st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(from, to, weight);
        }

        Arrays.sort(edges);

        for(int i=1; i<=N; i++) parent[i] = i;

        int e=0, idx=0, weight=0;
        while(e < N-1) {
            Edge cur = edges[idx++];

            int nx = find(cur.from);
            int ny = find(cur.to);

            if(nx != ny) {
                union(nx, ny);
                weight += cur.weight;
                e++;
            }
        }

        bw.write(weight+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int find(int val) {
        return (val == parent[val]) ? val : (parent[val] = find(parent[val]));
    }

    private static void union(int u ,int v) {
        u = find(u);
        v = find(v);

        if(u == v) return;
        if(rank[u] < rank[v]) parent[u] = v;
        else parent[v] = u;
        if(rank[u] == rank[v]) ++rank[v];
    }
}
