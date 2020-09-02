package RE.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class n13549 {
	static class move {
		int x;
		int time;
		StringBuilder sb;
		
		move(int x, int time, StringBuilder sb){
			this.x = x;
			this.time = time;
			this.sb = new StringBuilder();
		}
	}
	
	static int N, K;
	static int[] dist = new int[100001];
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		N = scn.nextInt();
		K = scn.nextInt();
		
		scn.close();
		
		Queue<move> q = new LinkedList<>();
		q.offer(new move(N, 0, new StringBuilder()));

		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[N] = 0;
		
		int minTime = Integer.MAX_VALUE;
		StringBuilder ans = null;
		
		while(!q.isEmpty()) {
			move c = q.poll();
			int vtx = c.x;
			int time = c.time;
			StringBuilder sb = c.sb;
			
			if(vtx == K) {
				minTime = time;
				ans = new StringBuilder(sb);
				break;
			}
			
			if(vtx*2 <= 100000 && dist[vtx*2] >= time) {
				if(vtx*2 != K) { 
					dist[vtx*2] = time;
				}
				sb.append(vtx*2).append(" ");
				q.offer(new move(vtx*2, time+1, new StringBuilder(sb)));
			}
			
			if(vtx-1 >= 0 && dist[vtx-1] >= time) {
				if(vtx-1 != K) 
					dist[vtx-1] = time;
				sb.append(vtx-1).append(" ");
				q.offer(new move(vtx-1, time+1, new StringBuilder(sb)));
			}
			
			if(vtx+1 <= 100000 && dist[vtx+1] >= time) {
				if(vtx+1 != K) 
					dist[vtx+1] = time;
				sb.append(vtx+1).append(" ");
				q.offer(new move(vtx+1, time+1, new StringBuilder(sb)));
			}
		}
		
		System.out.println(minTime + "\n" + ans);
	}
}
