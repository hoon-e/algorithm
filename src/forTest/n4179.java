package forTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n4179 {
	static int R, C;
	static char[][] map;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	static Queue<int[]> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		q = new LinkedList<>();
		
		int jx=0, jy=0;
		
		for(int i=0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
			
			for(int j=0; j<C; j++) {
				if(map[i][j] == 'J') {
					jx = i;
					jy = j;
				}
				if(map[i][j] == 'F') q.offer(new int[] {i, j, 1});
			}
		}
		
		q.offer(new int[] {jx, jy, 2, 0});
		
		int time = 1_000_000;
		boolean flag = false;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			if(cur[2] == 2 && (cur[0] == 0 || cur[0] == R-1 || cur[1] == 0 || cur[1] == C-1)) {
				flag = true;
				time = Math.min(time, cur[3]);
				break;
			}
			
			for(int d=0; d<4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				
				if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
				if(map[nx][ny] != '.') continue;
				
				if(cur[2] == 1) { // 불이라면
					map[nx][ny] = 'F';
					q.offer(new int[] {nx, ny, cur[2]});
				} else if(cur[2] == 2) { // 지훈이라면
					map[nx][ny] = 'J';
					q.offer(new int[] {nx, ny, cur[2], cur[3] + 1});
				}
			}
		}
		
		System.out.println(flag ? time+1 : "IMPOSSIBLE");
	}
}
