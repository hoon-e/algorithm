package RE.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class n2982 {
	static class road {
		int dst;
		int time;
		road link;
		
		road(int dst, int time, road link){
			this.dst = dst;
			this.time = time;
			this.link = link;
		}
	}
	
	static class vtx implements Comparable<vtx>{
		int dst;
		int time;
		
		vtx(int dst, int time){
			this.dst = dst;
			this.time = time;
		}
		
		public int compareTo(vtx v) {
			return time - v.time;
		}
	}
	
	static int N, M, A, B, K, G;
	static int[][] adj, godula;
	static int[] times, route;
	
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		road[] roads = new road[N+1];
		adj = new int[N+1][N+1]; // 인접
		times = new int[N+1]; // 시간
		route = new int[N+1]; // 고두라의 경로
		godula = new int[N+1][N+1]; // 고두라의 시간
		
		Arrays.fill(times, INF);
		
		st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<G; i++) {
			route[i] = Integer.parseInt(st.nextToken());
		}

		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			roads[from] = new road(to, weight, roads[from]);
			roads[to] = new road(from, weight, roads[to]);
			
			adj[from][to] = weight;
			adj[to][from] = weight;
		}
		
		int start = 0;
		for(int i=0; i<G-1; i++) {
			godula[route[i]][route[i+1]] = start;
			godula[route[i+1]][route[i]] = start;
			
			start += adj[route[i]][route[i+1]];
		}

		PriorityQueue<vtx> pq = new PriorityQueue<>();
		times[A] = K;
		
		pq.offer(new vtx(A, K));
		
		int ans = 0;
		while(!pq.isEmpty()) { // pq가 비어있을 동안
			vtx cur = pq.poll();
			
			int curVtx = cur.dst;
			int curTime = cur.time;
			
			if(curVtx == B) {
				ans = times[curVtx];
				break;
			}
			
			if(times[curVtx] != curTime) continue;
			
			road head = roads[curVtx];
			while(head != null) {
				int nextVtx = head.dst;
				int nextTime = head.time;
				int startTime = godula[curVtx][nextVtx];
				int endTime = adj[curVtx][nextVtx];
				int totalTime = startTime + endTime;
				
				if(startTime <= curTime && 
						curTime <= totalTime) {
					nextTime += totalTime - curTime;
				}
				
				if(curTime + nextTime < times[nextVtx]) {
					times[nextVtx] = curTime + nextTime;
					pq.offer(new vtx(nextVtx, times[nextVtx]));
				}
				
				head = head.link;
			}
		}
		
		System.out.println(ans - K);
	}
}
