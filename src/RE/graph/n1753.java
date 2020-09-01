package RE.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class n1753 {
	static class Edge implements Comparable<Edge>{
		int dst;
		int weight;
		
		Edge(int dst, int weight){
			this.dst = dst;
			this.weight = weight;
		}
		
		public int compareTo(Edge e) {
			return weight - e.weight;
		}
	}
	
	static int V, E, start;
	static List<Edge>[] adj;
	static final int INFINITY = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		start = Integer.parseInt(br.readLine());
		
		adj = new ArrayList[V+1];
		
		for(int i=1; i<=V; i++)
			adj[i] = new ArrayList<>();
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adj[u].add(new Edge(v, w));
		}
		
		int[] dist = new int[V+1];

		Arrays.fill(dist, INFINITY);
		
		boolean[] chk = new boolean[V+1];
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		dist[start] = 0;
		pq.offer(new Edge(start, 0));

		for(Edge n : adj[start]){
		    int now = n.dst;
		    int n_dist = n.weight;
		    
		    dist[now] = n_dist;
		    pq.offer(new Edge(now, dist[now]));
		}

		while(!pq.isEmpty()){
		    Edge now = pq.poll();
		    int curVtx = now.dst;
		    int curDist = now.weight;

		    if(curDist != dist[curVtx]) continue;
		    for(Edge g : adj[curVtx]){
		        int nextVtx = g.dst;
		        int nextDist = g.weight;

		        if(nextDist + curDist < dist[nextVtx]){
		            dist[nextVtx] = nextDist + curDist;
		            pq.offer(new Edge(nextVtx, dist[nextVtx]));
		        }
		    }
		}
	
		for(int i=1; i<=V; i++) {
			if(dist[i] == INFINITY) System.out.println("INF");
			else System.out.println(dist[i]);
		}
	}
}

//for(int i=1; i<=V-1; i++) {
//	int min = INFINITY;
//	int index = -1;
//	
//	for(int j=1; j<=V; j++) {
//		if(!chk[j] && (min > dist[j])) {
//			min = dist[j];
//			index = j;
//		}
//	}
//	
//	if(index == -1) break;
//	
//	for(Edge next : adj[index]) {
//		if(!chk[next.dst] && dist[next.dst] > dist[index] + next.weight) {
//			dist[next.dst] = dist[index] + next.weight;
//		}
//	}
//	chk[index] = true;
//}
