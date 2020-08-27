package SWEA.D5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class ohmygoddess {
	static int R, C, ans, sX, sY; // R, C, 악마의 x, y
	static char[][] map; // map 정보
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			String[] l = br.readLine().split(" ");
			
			R = Integer.parseInt(l[0]);
			C = Integer.parseInt(l[1]); // R과 C를 입력받는다.
			ans = 0;
			
			map = new char[R][];
			
			Queue<int[]> q = new LinkedList<>();
			
			for(int i=0; i<R; i++) {
				map[i] = br.readLine().toCharArray(); // map 정보 입력받는다.
				for(int j=0; j<C; j++) {
					if(map[i][j] == 'S') {
						sX = i;
						sY = j;
					}
					if(map[i][j] == '*') {
						q.offer(new int[] {i, j, 2}); // 악마를 먼저 넣는다.
					}
				}
			}
			
			q.offer(new int[] {sX, sY, 1, 0});
			
			a : while(!q.isEmpty()) {
				int[] cur = q.poll();
				
				for(int d=0; d<4; d++) {
					int nx = cur[0] + dx[d];
					int ny = cur[1] + dy[d];
					
					if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
					
					char pro = map[nx][ny];
					if(pro == 'X' || pro == '*') continue;
					
					if(cur[2] == 1) {
						if(pro == 'S') continue;
						if(pro == 'D') {
							ans = cur[3]+1;
							break a;
						}
						
						map[nx][ny] = 'S';
						q.offer(new int[] {nx, ny, 1, cur[3]+1});
						
					} else if(cur[2] == 2) {
						if(pro == 'D') continue;
						map[nx][ny] = '*';
						q.offer(new int[] {nx, ny, 2});
					}
				}
			}
			
			System.out.println("#" + tc + " " + ((ans == 0) ? "GAME OVER" : ans));
		}
	}
}

//q.offer(new int[] {i, j, 1, 0}); // x, y, 타입을 저장 - 수연이 부터
