package forTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n1743 {
	static int N, M, K; // N, M, 쓰레기 갯수
	static char[][] map;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new char[N+1][M+1];
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			map[x][y] = 'x';
		}
		
		int max = -1;
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				if(map[i][j] == 'x') {
					Queue<int[]> q = new LinkedList<>();
					
					int cnt = 0;
					q.offer(new int[] {i, j});
					map[i][j] = ' ';
					
					while(!q.isEmpty()) {
						int[] cur = q.poll();
						
						++cnt;
						for(int d=0; d<4; d++) {
							int nx = cur[0] + dx[d];
							int ny = cur[1] + dy[d];
							
							if(nx >= 1 && nx <= N && ny >= 1 && ny <= M && map[nx][ny] == 'x') {
								map[nx][ny] = ' ';
								q.offer(new int[] {nx, ny});
							}
						}
					}
					
					max = Math.max(max, cnt);
				}
			}
		}
		
		System.out.println(max);
	}
}
