package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class n1767 {
	static int T, N, len, maxCore, minLen, totalCnt;
	static int[][] map;
	static ArrayList<int[]> cores;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1}; // 상, 하, 좌, 우
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			maxCore = 0;
			minLen = Integer.MAX_VALUE;
			totalCnt = 0;
			
			cores = new ArrayList<>();
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
					if(map[i][j] == 1) {
						if(!(i == 0 || i == N-1 || j == 0 || j == N-1)) {
							cores.add(new int[] {i, j});
							++totalCnt;
						}
					}
				}
			} // map
			
			System.out.println("#" + tc + " " + minLen);
		}
	}	
	
	private static void canPlant(int index) {
		
		
		for(int d=0; d<4; d++) {
			// 해당 방향으로 전선 놓는게 가능한지 체크
			// 가능하다면 전선 돌기  // 엑시노스판에 2로 세팅
			// 다음 코어로 넘어가기
			// 놓았던 전선 지우기
		}
		
		// 해당 코어 비선택
		// 아무런 전선도 놓지 않고 다음 전선으로 넘억가기
	}
	
	// 현 코어의 위치에서 해당 방향으로 전선을 놓는게 가능한가?
	private static boolean isAvailable(int r, int c, int d) {
		int nr = r;
		int nc = c;
		
		while(true) {
			nr += dr[d];
			nc += dc[d];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) break;
			if(map[nr][nc] >= 1) return false; // 1. 코어  2. 전선
		}
		
		return true;
	}
}


/*
// 심을 수 있는지
	private static int setPlant(int row, int col, int dir, boolean flag) {
		int len = 0;
		switch(dir) {
			case 0:
				row += dx[dir];
				while(row >= 0) {
					line[row][col] = flag;
					++len;
					row += dx[dir];
				}
				break;
			case 1:
				row += dx[dir];
				while(row < N) {
					line[row][col] = flag;
					++len;
					row += dx[dir];
				}
				break;
			case 2:
				col += dy[dir];
				while(col >= 0) {
					line[row][col] = flag;
					++len;
					col += dy[dir];
				}
				break;
			case 3:
				col += dy[dir];
				while(col < N) {
					line[row][col] = flag;
					++len;
					col += dy[dir];
				}
				break;
		}
		
		return len;
	}
	
	// 심을 수 있는지
	private static boolean canPlant(int row, int col, int dir) {
		
		switch(dir) {
			case 0:
				row += dx[dir];
				while(row >= 0) {
					if(map[row][col] == 1 || line[row][col]) return false;
					row += dx[dir];
				}
				return true;
			case 1:
				row += dx[dir];
				while(row < N) {
					if(map[row][col] == 1 || line[row][col]) return false;
					row += dx[dir];
				}
				return true;
			case 2:
				col += dy[dir];
				while(col >= 0) {
					if(map[row][col] == 1 || line[row][col]) return false;
					col += dy[dir];
				}
				return true;
			case 3:
				col += dy[dir];
				while(col < N) {
					if(map[row][col] == 1 || line[row][col]) return false;
					col += dy[dir];
				}
				return true;
		}
		return false;
	}
	
	private static int min(int a, int b) {
		return (a < b) ? a : b;
	}
	
	private static void perm(int cnt, int core, int length) {
		if(cnt == len) {
			if(maxCore < core) {
				maxCore = core;
				minLen = Integer.MAX_VALUE;
				minLen = min(minLen, length);
			} else if(maxCore == core) {
				minLen = min(minLen, length); // maxCore보다 작을경우 리턴
			}
			return;
		}
		
		for(int i = 0; i < len; i++) { // core를 탐색한다.
			if(chk[i]) continue;
			
			int[] now = coord.get(i);
			int count = 0;
			int l = 0;
			
			for(int d=0; d<4; d++) { // 방향 마다 탐색해본다.
				if(canPlant(now[0], now[1], d)) {
					l = setPlant(now[0], now[1], d, true);
					chk[i] = true;
					perm(cnt+1, core+1, length+l);
					chk[i] = false;
					setPlant(now[0], now[1], d, false);
					++count;
				}
			}
			
			if(count == 0) { // 아무 방향도 갈 수 없을 경우
				chk[i] = true;
				perm(cnt+1, core, length);
				chk[i] = false;
			}
		}
	} 
*/