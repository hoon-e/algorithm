package RE.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n17144 {
	static int R, C, T;
	static int[][] map, tMap;
	static int[] cleaner = new int[2]; // 청소기
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
				
		int cIdx = 0;
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == -1) {
					cleaner[cIdx++] = i;
				} // 청소기
			}
		}
		
		for(int time=0; time < T; time++) { // 시간이 다 지날 떄까지
			copyMap();
			move();
		}
		
		int d = 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] != -1 && map[i][j] != 0) 
					d += map[i][j];
			}
		}
		
		System.out.println(d);
	}
	
	static void copyMap() {
		tMap = new int[R][C];
		
		// 미세먼지 확산
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] == -1 || map[i][j] == 0) continue;
				
				int dCount = 0; // 뿌린 갯수
				int dAmount = (map[i][j] / 5); // 뿌리는 양
				
				for(int d=0; d<4; d++) {
					int nr = i + dx[d];
					int nc = j + dy[d];
					
					if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
					if(map[nr][nc] == -1) continue;
					
					tMap[nr][nc] += dAmount;
					dCount++;
				}
				
				map[i][j] -= (dAmount * dCount);
				tMap[i][j] += map[i][j];
			}
		}
		
		tMap[cleaner[0]][0] = -1;
		tMap[cleaner[1]][0] = -1;
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				map[i][j] = tMap[i][j];
			}
		} // 맵 복사
	}
	
	static void move() {
		// 미세먼지 이동
		int sx1 = cleaner[0];
		int sx2 = cleaner[1];
		
		/* 위쪽 공기 청정기 */
		// 오른쪽으로 밀기
		int right = map[sx1][C-1];
		for(int s = C-1; s > 0; s--) {
			map[sx1][s] = map[sx1][s-1];
		}
		map[sx1][1] = 0;
		
		// 위로 밀기
		int up = map[0][C-1];
		for(int s = 0; s < sx1-1; s++) {
			map[s][C-1] = map[s+1][C-1];
		}
		map[sx1-1][C-1] = right;
		
		// 왼쪽으로 밀기
		int left = map[0][0];
		for(int s = 0; s < C-1; s++) {
			map[0][s] = map[0][s+1];
		}
		map[0][C-2] = up;
		
		// 아래로 밀기
		for(int s = sx1-1; s > 0; s--) {
			map[s][0] = map[s-1][0];
		}
		map[1][0] = left;
		
		/* 아래쪽 공기 청정기 */
		
		// 오른쪽 밀기
		right = map[sx2][C-1]; // 잘려들어갈 값
		for(int s = C-1; s > 1; s--) {
			map[sx2][s] = map[sx2][s-1];
		}
		map[sx2][1] = 0;
		
		// 아래로 밀기
		int down = map[R-1][C-1];
		for(int s = R-1; s > sx2; s--) {
			map[s][C-1] = map[s-1][C-1];
		}
		map[sx2+1][C-1] = right;
		
		// 왼쪽으로 밀기
		left = map[R-1][0];
		for(int i=0; i<C-1; i++) {
			map[R-1][i] = map[R-1][i+1];
		}
		map[R-1][C-2] = down;
		
		// 위쪽으로 밀기
		for(int i=sx2+1; i < R-1; i++) {
			map[i][0] = map[i+1][0];
		}
		map[R-2][0] = left;
	}
}