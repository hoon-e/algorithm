package forTest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class n14226 {
	static int N;
	static boolean[][] vst;
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		N = scn.nextInt();
		vst = new boolean[N+1][N+1];
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {1, 0, 0}); // 현재, 클립보드, 시간
		vst[1][0] = true;
		
		int ans = 0;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			if(cur[0] == N) {
				ans = cur[2];
				break;
			}
			
			// 제거하기
			if(cur[0]-1 > 1 && !vst[cur[0]-1][cur[1]]) {
				vst[cur[0]-1][cur[1]] = true;
				q.offer(new int[] {cur[0]-1, cur[1], cur[2]+1});
			}
			
			// 클립보드를 화면에 붙여넣기
			if(cur[0]+cur[1] <= N && !vst[cur[0]+cur[1]][cur[1]]) {
				vst[cur[0]+cur[1]][cur[1]] = true;
				q.offer(new int[] {cur[0]+cur[1], cur[1], cur[2]+1});
			}
			
			// 복사
			if(cur[0] <= N && !vst[cur[0]][cur[0]]) {
				vst[cur[0]][cur[0]] = true;
				q.offer(new int[] {cur[0], cur[0], cur[2]+1});
			}
		}
		
		System.out.println(ans);
	}
}
