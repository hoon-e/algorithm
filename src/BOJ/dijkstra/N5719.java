package BOJ.dijkstra;

import java.io.*;
import java.util.*;

class Road implements Comparable<Road> {
    int vertex;
    int dist;

    Road(int vertex, int dist){
        this.vertex = vertex;
        this.dist = dist;
    }

    public int compareTo(Road r){
        return r.dist - dist;
    }
}

public class N5719 {
    static int N;
    static int M;
    static int S;
    static int D;
    static int[][] nodes;
    static int[] dist;
    static ArrayList<Integer>[] traceback;
    static final int INF = 500_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int u,v,p;
        while(true){
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if(N == 0 && M == 0) break;

            nodes = new int[N][N];
            traceback = new ArrayList[N];

            for(int i=0; i<N; i++){
                Arrays.fill(nodes[i], INF);
                traceback[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());

            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                u = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());
                p = Integer.parseInt(st.nextToken());

                nodes[u][v] = p;
            }

            dijkstra5719();
            traceBack();
            bw.write(dijkstra5719()+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int dijkstra5719(){
        dist = new int[N];

        Arrays.fill(dist, INF);

        PriorityQueue<Road> pq = new PriorityQueue<>();
        dist[S] = 0;
        pq.offer(new Road(S, dist[S]));

        while(!pq.isEmpty()){
            Road cur = pq.poll();

            if(dist[cur.vertex] != cur.dist) continue;
            for(int next = 0; next < N; next++){
                if(nodes[cur.vertex][next] == INF) continue;
                if(cur.dist + nodes[cur.vertex][next] <= dist[next]){
                    dist[next] = cur.dist + nodes[cur.vertex][next];
                    pq.offer(new Road(next, dist[next]));
                    traceback[next].add(cur.vertex);
                }
            }
        }

        return dist[D] >= INF ? -1 : dist[D];
    }

    static void traceBack(){
        Queue<Integer> q = new LinkedList<>();
        q.offer(D);

        // ★ 인접행렬로도 푸는 연습!!!
        while(!q.isEmpty()){
            int cur = q.poll();

            for(int pre : traceback[cur]){
                if(nodes[pre][cur] != INF && dist[pre] + nodes[pre][cur] == dist[cur]){
                    q.offer(pre);
                    nodes[pre][cur] = INF;
                }
            }
        }
    }
}
