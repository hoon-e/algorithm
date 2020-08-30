package forTest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class n5014 {
	static int[] info = new int[5];
	static boolean[] chk;
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		for(int i=0; i<5; i++)
			info[i] = scn.nextInt();
		
		chk = new boolean[info[0]+1];
		int[] dir = {info[3], -info[4]};
		
		Queue<int[]> q = new LinkedList<>();
		
		chk[info[1]] = true;
		q.offer(new int[] {info[1], 0});
		
		int min = Integer.MAX_VALUE;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			if(cur[0] == info[2]) {
				min = Math.min(min, cur[1]);
			}
			
			for(int d=0; d<2; d++) {
				int next = cur[0] + dir[d];
				
				if(next <= 0 || next > info[0]) continue;
				if(chk[next]) continue;
				
				q.offer(new int[] {next, cur[1] + 1});
				chk[next] = true;
			}
		}
		
		System.out.println((min == Integer.MAX_VALUE) ? "use the stairs" : min);
	}
}
