package RE.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class n2206 {
	static int R, C, max = Integer.MAX_VALUE;
	static char[][] map;
	static int[][] wall;
	static boolean[][] vst;
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] read = br.readLine().split(" ");
		
		R = Integer.parseInt(read[0]);
		C = Integer.parseInt(read[1]);
		
		map = new char[R][C];
		wall = new int[R][C];
		vst = new boolean[R][C];
		
		for(int i=0; i<R; i++)
			map[i] = br.readLine().toCharArray();
		
		Queue<int[]> q = new LinkedList<>();
		
		// x, y, 거리, 벽
		q.offer(new int[] {0, 0, 1, 0});
		vst[0][0] = true;
		
		while(!q.isEmpty()){
			int[] cur = q.poll();
				
			if(cur[0] == R-1 && cur[1] == C-1) {
				max = Math.min(cur[2], max);
				continue;
			}
			
			for(int d=0; d<4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
				
				// 만약 방문한 점이더라도 뚫은 벽이 더 작다면 탐색해준다.
				if(vst[nr][nc]) {
					if(cur[3] < wall[nr][nc]) {
						// 벽을 현재로 갱신해준다.
						wall[nr][nc] = cur[3];
						q.offer(new int[] {nr, nc, cur[2]+1, cur[3]});
					}
					continue;
				}
				
				// 벽이고, 현재 부순 벽의 수가 1보다 작을 경우
				if(map[nr][nc] == '1' && cur[3] < 1) {
					wall[nr][nc] = 1;
					vst[nr][nc] = true;
					q.offer(new int[] {nr, nc, cur[2]+1, cur[3]+1});
				}
				
				// 벽이 아니고, 부순 벽의 갯수가 1보다 작거나 같은 경우
				else if(map[nr][nc] == '0' && cur[3] <= 1 ) {
					vst[nr][nc] = true;
					wall[nr][nc] = cur[3];
					q.offer(new int[] {nr, nc, cur[2]+1, cur[3]});
				}
			}
		}
		
		System.out.println(max = (max == Integer.MAX_VALUE) ? -1 : max);
	}
}
