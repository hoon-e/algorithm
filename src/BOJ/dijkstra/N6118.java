package BOJ.dijkstra;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N6118 {
    static class Edge implements Comparable<Edge> {
        int vtx;
        int weight;

        Edge(int vtx, int weight){
            this.vtx = vtx;
            this.weight = weight;
        }

        public int compareTo(Edge e){
            return weight - e.weight;
        }
    }

    static int N;
    static int M;
    static ArrayList<Edge>[] nodes;
    static int[] weight;
    static int[] ans = new int[3];
    static final int INF = 20_001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nodes = new ArrayList[N+1];

        for(int i=1; i<=N; i++) {
            nodes[i] = new ArrayList<>();
        }

        weight = new int[N+1];

        int u, v;
        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            nodes[u].add(new Edge(v, 1));
            nodes[v].add(new Edge(u, 1));
        }

        dijkstra();

        for(int i=0; i<3; i++)
            bw.write(ans[i] + " ");
        bw.flush();
        bw.close();
        br.close();
    }

    static void dijkstra(){
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        Arrays.fill(weight, INF);

        weight[1] = 0;
        pq.offer(new Edge(1, weight[1]));

        for(Edge e : nodes[1]){
            weight[e.vtx] = Math.min(weight[e.vtx], e.weight);
            pq.offer(new Edge(e.vtx, weight[e.vtx]));
        }

        while(!pq.isEmpty()){
            Edge cur = pq.poll();

            if(weight[cur.vtx] != cur.weight) continue;
            for(Edge e : nodes[cur.vtx]){
                if(weight[e.vtx] > e.weight + cur.weight){
                    weight[e.vtx] = e.weight + cur.weight;
                    pq.offer(new Edge(e.vtx, weight[e.vtx]));
                }
            }
        }

        int min = Integer.MIN_VALUE;
        int idx = Integer.MAX_VALUE;
        int count = 0;

        for(int i=1; i<=N; i++){
            if(weight[i] == INF) continue;
            min = Math.max(min, weight[i]);
        }

        for(int i=1; i<=N; i++){
            if(weight[i] == min){
                if(idx > i) idx = i;
                count++;
            }
        }

        ans[0] = idx;
        ans[1] = min;
        ans[2] = count;
    }
}
