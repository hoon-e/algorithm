package forTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class fireTest {
	static int R, C, ans;
	static char[][] map;
	static Queue<Point> jhque, fireque;

	static class Point{
		int r;
		int c;
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		jhque = new LinkedList<>();
		fireque = new LinkedList<>();
		
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j] == 'J') {
					jhque.offer(new Point(i, j));
				}else if(map[i][j] == 'F') {
					fireque.offer(new Point(i, j));
				}
			}
		}
		ans = 0;
		bfs();
		System.out.println(ans==0?"IMPOSSIBLE":ans);
	}
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0, 0, -1,1};
	
	private static void bfs() {
		int time = 0; 
		//지훈이의 탈출 여부를 기준이므로
		while(!jhque.isEmpty()) {
			//불이 먼저 퍼짐
			int fsize = fireque.size();
			
			for (int i = 0; i < fsize; i++) {
				Point p = fireque.poll();
				for (int d = 0; d < 4; d++) {
					int nr = p.r+dr[d];
					int nc = p.c+dc[d];
					if(!check(nr,nc)) {continue;}
					
					if(map[nr][nc] == '.') {
						map[nr][nc] = 'F'; 
						fireque.offer(new Point(nr, nc));
					}
				}
			}
			
			int jsize = jhque.size();
			
			for (int i = 0; i < jsize; i++) {
				Point p = jhque.poll();
				for (int d = 0; d < 4; d++) {
					int nr = p.r+dr[d];
					int nc = p.c+dc[d];
					if(!check(nr,nc)) {continue;}
					
					//다음 움직임이 경계라면
					if(map[nr][nc]=='.' && (nr==0||nr==R-1||nc==0||nc==C-1)) {
						ans = time+2;
						return;
					}
					
					if(map[nr][nc] == '.') {
						map[nr][nc] = 'J'; 
						jhque.offer(new Point(nr, nc));
					}
				}
			}
			time++;
		}
	}
	
	private static boolean check(int nr, int nc) {
		if(nr>=0&&nr<R&&nc>=0&&nc<C) {return true;}
		else return false;
	}
}
