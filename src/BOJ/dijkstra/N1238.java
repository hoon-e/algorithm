package BOJ.dijkstra;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N1238 {
    static class Edge implements Comparable<Edge> {
        int vertex;
        int time;

        Edge(int vertex, int time){
            this.vertex = vertex;
            this.time = time;
        }

        public int compareTo(Edge e){
            return time - e.time;
        }
    }

    static int N;
    static int M;
    static int X;
    static ArrayList<Edge>[] nodes;
    static int[] dist;
    static int[][] ans;
    static final int INF = 1_000_000;
    static int max = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        nodes = new ArrayList[N+1];
        ans = new int[N+1][N+1];

        for(int i=1; i<=N; i++) {
            nodes[i] = new ArrayList<>();
        }

        int s, e, t;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            nodes[s].add(new Edge(e, t));
        }

        for(int i=1; i<=N; i++){
            ans[i] = dijkstra1238(i);
        }

        for(int i=1; i<=N; i++){
            max = Math.max(max, ans[i][X] + ans[X][i]);
        }

        bw.write(max+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int[] dijkstra1238(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        dist = new int[N+1];
        Arrays.fill(dist, INF);

        dist[start] = 0;
        pq.offer(new Edge(start, dist[start]));

        for(Edge e : nodes[start]){
            dist[e.vertex] = e.time;
            pq.offer(new Edge(e.vertex, e.time));
        }

        while(!pq.isEmpty()){
            Edge cur = pq.poll();

            int curVtx = cur.vertex;
            int curTime = cur.time;

            if(dist[curVtx] != curTime) continue;
            for(Edge e : nodes[curVtx]){
                int newVtx = e.vertex;
                int newTime = e.time;

                if(curTime + newTime < dist[newVtx]){
                    dist[newVtx] = curTime + newTime;
                    pq.offer(new Edge(newVtx, dist[newVtx]));
                }
            }
        }

        return dist;
    }
}
