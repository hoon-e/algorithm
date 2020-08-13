package BOJ.dijkstra;

import java.io.*;
import java.util.*;

public class N1916 {
	static class edge implements Comparable<edge>{
	    int vertex;
	    int weight;

	    edge(int vertex, int weight){
	        this.vertex = vertex;
	        this.weight = weight;
	    }

	    public int compareTo(edge e){
	        return weight - e.weight;
	    }
	}
	
    static int N;
    static int M;
    static ArrayList<edge>[] nodes;
    static int[] dist;
    static final int INF = Integer.MAX_VALUE-100_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        StringTokenizer st;

        nodes = new ArrayList[N+1];
        dist = new int[N+1];

        for(int i=1; i<=N; i++) {
            nodes[i] = new ArrayList<>();
            dist[i] = INF;
        }

        int s, e, w;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            nodes[s].add(new edge(e,w));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int ans = dijkstra1916(start, end);
        bw.write(ans+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int dijkstra1916(int start, int end){
        PriorityQueue<edge> pq = new PriorityQueue<>();

        dist[start] = 0;
        pq.offer(new edge(start, dist[start]));

        for(edge e : nodes[start]){
            if(dist[e.vertex] > e.weight)
                dist[e.vertex] = e.weight;
            pq.offer(new edge(e.vertex, dist[e.vertex]));
        }

        while(!pq.isEmpty()){
            edge cur = pq.poll();

            int curVtx = cur.vertex;
            int curDist = cur.weight;

            if(curDist != dist[curVtx]) continue;
            for(edge e : nodes[curVtx]){
                int nVtx = e.vertex;
                int nDist = e.weight;

                if(curDist + nDist <= dist[nVtx]){
                    dist[nVtx] = curDist + nDist;
                    pq.offer(new edge(nVtx, dist[nVtx]));
                }
            }
        }

        return dist[end];
    }
}
