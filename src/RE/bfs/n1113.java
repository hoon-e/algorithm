package RE.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n1113 {
	static int N, M, maxHeight=-1;
	static int[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+2][M+2];
		
		for(int i=1; i<=N; i++) {
			char[] line = br.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				map[i][j+1] = line[j]-'0';
				maxHeight = (maxHeight < map[i][j+1]) ? map[i][j+1] : maxHeight;
			}
		}
		
		int pool = 0;
		
		for(int height=1; height <= maxHeight; height++) {
			Queue<int[]> q = new LinkedList<>();
			
			q.offer(new int[] {0, 0});
			map[0][0] = height;
			
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				
				for(int d=0; d<4; d++) {
					int nx = cur[0] + dx[d];
					int ny = cur[1] + dy[d];
					
					if(nx < 0 || nx >= N+2 || ny < 0 || ny >= M+2) continue;
					if(map[nx][ny] < height) {
						map[nx][ny] = height;
						q.offer(new int[] {nx, ny});
					}
				}
			}
			
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=M; j++) {
					if(map[i][j] < height) {
						pool += (height - map[i][j]++);
					}
				}
			}
		}
		
		System.out.println(pool);
	}
}
