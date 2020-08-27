package SWEA.D5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class ohmy2 {
	static int R, C;
	static char[][] map;
	static int ans;
	
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {1, -1, 0, 0};
	
	static Queue<point> qSoo, qDevil;
	static int endr, endc;
	
	static class point {
		int r, c;
		
		point(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	
	// 큐를 두개를 사용해서 풀이하는 방식
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			String[] l = br.readLine().split(" ");
			
			R = Integer.parseInt(l[0]);
			C = Integer.parseInt(l[1]); // R과 C를 입력받는다.
			ans = 0;
			
			map = new char[R][];
			
			qSoo = new LinkedList<>();
			qDevil = new LinkedList<>();
			
			ans = 0;
			
			for(int i=0; i<R; i++) {
				map[i] = br.readLine().toCharArray(); // map 정보 입력받는다.
				for(int j=0; j<C; j++) {
					if(map[i][j] == 'S') {
						qSoo.offer(new point(i, j));
					} else if(map[i][j] == '*') {
						qDevil.offer(new point(i,j));
					} else if(map[i][j] == 'D') {
						endr = i;
						endc = j;
					}
				}
			}
			
			bfs();
			System.out.println("#" + tc + " " + ((ans == 0) ? "GAME OVER" : ans));
		}
	}
	
	static void bfs() {
		int time = 0;
		
		while(!qSoo.isEmpty()) {
			// 현재 큐에 있는 좌표들은 같은 시간에 이동가능한 좌표이다.
			// 걔네를 꺼내서, 다 처리하면, 1초가 흐른다.
			// 악마가 먼저 퍼져야한다.
			
			int dsize = qDevil.size();
			
			// 퍼진 악마 자리 피해서, 수연이가 1초 동안 이동해야한다.
			for(int ds=0; ds<dsize; ds++) {
				point now = qDevil.poll();
				
				for(int d=0; d<4; d++) {
					int nr = now.r + dr[d];
					int nc = now.c + dc[d];
					
					if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
					if(map[nr][nc] == '*' || map[nr][nc] == 'D' || map[nr][nc] == 'X') continue;
					qDevil.offer(new point(nr, nc));
					map[nr][nc] = '*';
				}
			}
			
			int ssize = qSoo.size();
			
			// 퍼진 악마 자리 피해서, 수연이가 1초 동안 이동해야한다.
			for(int ss=0; ss<ssize; ss++) {
				point now = qSoo.poll();
				
				for(int d=0; d<4; d++) {
					int nr = now.r + dr[d];
					int nc = now.c + dc[d];
					
					if(nr == endr && nc == endc) {
						ans = time+1;
						return;
					}
					
					if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
					if(map[nr][nc] == '.') {
						qSoo.offer(new point(nr, nc));
						map[nr][nc] = 'S';
					}
				}
			}
			
			++time;
		}
	}
}
