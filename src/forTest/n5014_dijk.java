package forTest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class n5014_dijk {
	static int[] info = new int[5], dist;
	static final int MAX = 10_000_000;
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		for(int i=0; i<5; i++)
			info[i] = scn.nextInt();
		
		dist = new int[info[0]+1];
		Arrays.fill(dist, MAX);
		
		// 다익스트라 이용
		// 지금 거리보다 작을 경우에만 큐에다가 넣어준다.
		Queue<Integer> q = new LinkedList<>();
		
		dist[info[1]] = 0;
		q.offer(info[1]);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			int up = cur + info[3];
			int down = cur - info[4];
			
			if(up <= info[0] && dist[cur]+1 < dist[up]) {
				dist[up] = dist[cur]+1;
				q.offer(up);
			}
			
			if(down > 0 && dist[cur]+1 < dist[down]) {
				dist[down] = dist[cur]+1;
				q.offer(down);
			}
		}
		
		System.out.println((dist[info[2]] == MAX) ? "use the stairs" : dist[info[2]]);
	}
}
