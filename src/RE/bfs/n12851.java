package RE.bfs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class n12851 {
	static int N, K;
	static int[] dist = new int[100001];
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		N = scn.nextInt();
		K = scn.nextInt();
		
		scn.close();
				
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {N, 0});

		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[N] = 0;
		
		int minTime = Integer.MAX_VALUE;
		int ans = 0;
		
		while(!q.isEmpty()) {
			int[] c = q.poll();
			int vtx = c[0];
			int time = c[1];
			
			if(time > minTime) break;
			if(vtx == K) {
				if(minTime > time) minTime = time;
				if(time == minTime) {
					++ans;
				}
			}
			
			if(vtx*2 <= 100000 && dist[vtx*2] >= time) {
				if(vtx*2 != K) 
					dist[vtx*2] = time;
				q.offer(new int[] {vtx*2, time+1});
			}
			
			if(vtx-1 >= 0 && dist[vtx-1] >= time) {
				if(vtx-1 != K) 
					dist[vtx-1] = time;
				q.offer(new int[] {vtx-1, time+1});
			}
			
			if(vtx+1 <= 100000 && dist[vtx+1] >= time) {
				if(vtx+1 != K) 
					dist[vtx+1] = time;
				q.offer(new int[] {vtx+1, time+1});
			}
		}
		
		System.out.println(minTime + "\n" + ans);
	}
}
