package RE.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class n10725 {
	static int N, M, x, y, size, sX, sY, eX, eY, dir;
	static char[] w = {'.', '\\', '/'};
	
	static long ans;
	static char[][] map;
	static ArrayList<int[]> coord;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1}; // 상 우 하 좌
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		map = new char[N+2][M+2];
		coord = new ArrayList<>();
		
		for(int i=1; i<=N; i++) {
			String s = br.readLine();
			int idx=0;
			for(int j=1; j<=M; j++) {
				map[i][j] = s.charAt(idx++);
				if(map[i][j] == '?') {
					coord.add(new int[] {i, j}); // i, j 좌표를 넣는다.
				}
			}
		}
		
		size = coord.size();
		
		// 시작점과 방향 설정
		set(x, 0);
		set(y, 1);
		
		setMap(0);
		System.out.println((ans%10007));
	}
	
	private static void set(int num, int flag) {
		int i=0, j=0, d=0;
		
		if(num <= M) {
			i = 0; j = num;
			d = 2;
		} else if(num > M && num <= M+N) {
			i = (num-M); j = 0;
			d = 1;
		} else if(num > M+N && num <= M+2*N) {
			i = num-M-N; j=M+1;
			d = 3;
		} else {
			i = N+1; j = num-(2*N)-M;
			d = 0;
		}
		
		if(flag == 0) {
			sX = i;
			sY = j;
			dir = d;
		} else {
			eX = i;
			eY = j;
		}
	}
	
	private static void setMap(int cnt) {
		if(cnt == size) { // ?만큼 하면, 시작점부터 끝점까지의 경로를 구한다.
			// dir : 0 상 1 우 2 하 3 좌
			int d = dir;
			int bx = sX + dx[d];
			int by = sY + dy[d];
			
			// 범위 내에 있는 동안
			while(bx >= 1 && bx <= N && by >= 1 && by <= M) {
				 if(map[bx][by] == '/') {
					 if(d == 0) d = 1;
					 else if(d == 1) d = 0;
					 else if(d == 2) d = 3;
					 else if(d == 3) d = 2;
				 } else if(map[bx][by] == '\\'){
					 if(d == 0) d = 3;
					 else if(d == 1) d = 2;
					 else if(d == 2) d = 1;
					 else if(d == 3) d = 0;
				 }
				 
				 bx += dx[d];
				 by += dy[d];
			}
			
			if(bx == eX && by == eY)
				ans = ((ans+1) % 10007);
			
			return;
		}
		
		int[] cod = coord.get(cnt);
		int nx = cod[0];
		int ny = cod[1];
		
		for(int type=0; type<3; type++) {
			map[nx][ny] = w[type];
			setMap(cnt+1);
		}
	}
}
