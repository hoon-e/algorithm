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
	static int[] godola, times;
	static int[][] remain;
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		road[] roads = new road[N+1];
		times = new int[N+1];
		remain = new int[N+1][N+1];
		
		Arrays.fill(times, INF);
		
		st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		
		godola = new int[G];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<G; i++)
			godola[i] = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			roads[from] = new road(to, weight, roads[from]);
			roads[to] = new road(from, weight, roads[to]);
		}
		
		// 고돌라부터 진행시킴
		road head = roads[godola[0]];

		int time = 0;
		int idx = 1;
		int start = godola[0];
		
		while(idx < G) {
			while(head != null) {
				if(head.dst != godola[idx]) {
					head = head.link;
				}
				else break;
			}
			
			time += head.time; // 시간 더해준다.
			
			if(time > K) {
				remain[start][head.dst] = time - K;
				remain[head.dst][start] = time - K;
				time = 0;
			}
			
			start = head.dst;
			head = roads[godola[idx++]];
		}
		
		PriorityQueue<vtx> pq = new PriorityQueue<>();
		times[A] = 0;
		
		head = roads[A]; // 시작점의 노드

		while(head != null) {
			pq.offer(new vtx(head.dst, head.time));
			head = head.link;
		}
		
		int ans = 0;
		while(!pq.isEmpty()) { // pq가 비어있을 동안
			vtx cur = pq.poll();
			
			int curVtx = cur.dst;
			int curTime = cur.time;
			
			if(curVtx == B) {
				ans = times[curVtx];
				break;
			}
			
			head = roads[curVtx];
			while(head != null) {
				int nextVtx = head.dst;
				int nextTime = head.time;
				int remainTime = 0;
				
				if(remain[curVtx][nextVtx] != 0) remainTime = remain[curVtx][nextVtx] - curTime;
				if(curTime + nextTime + remainTime < times[nextVtx]) {
					times[nextVtx] = curTime + nextTime + remainTime;
					pq.offer(new vtx(nextVtx, times[nextVtx]));
				}
				
				head = head.link;
			}
		}
		
		System.out.println(ans);
	}
}
