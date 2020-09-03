package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class n1767_n {
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
			
			canPlant(0, 0);
			System.out.println("#" + tc + " " + minLen);
		}
	}	
	
	private static int getLength() {
		int len = 0;
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(map[r][c] == 2) ++len;
			}
		}
		
		return len;
	}
	
	private static void canPlant(int index, int core) {
		if(index == totalCnt) {
			int len = getLength();
			if(maxCore < core) {
				maxCore = core;
				minLen = len;
			} else if(maxCore == core) {
				if(minLen > len) minLen = len;
			}
			
			return;
		}
		
		int[] cur = cores.get(index);
		int r = cur[0];
		int c = cur[1];
		
		for(int d=0; d<4; d++) {
			// 해당 방향으로 전선 놓는게 가능한지 체크
			// 가능하다면 전선 돌기 
			if(isAvailable(r, c, d)) {
			 // 엑시노스판에 2로 세팅
			 // 다음 코어로 넘어가기
			 // 놓았던 전선 지우기
				setLine(r, c, d, 2);
				canPlant(index+1, core+1);
				setLine(r, c, d, 0);
			}
		}
		
		// 해당 코어 비선택
		// 아무런 전선도 놓지 않고 다음 전선으로 넘억가기
		canPlant(index+1, core);
	}
	
	private static void setLine(int r, int c, int d, int val) {
		int nr = r;
		int nc = c;
		
		while(true) {
			nr += dr[d];
			nc += dc[d];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) break;
			map[nr][nc] = val;
		}
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
