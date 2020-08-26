package RE.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n2615 {
	
	static int[] dx = {-1, 0, 1, 1};
	static int[] dy = {1, 1, 1, 0};
	static int[][] map = new int[20][20];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		for(int i=0; i<19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<19; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<20; i++) {
			for(int j=0; j<20; j++) {				
				if(map[i][j] != 0) {
					if(findWinner(i, j, map[i][j])) {
						System.out.println(map[i][j] + "\n" + (i+1) + " " + (j+1));
						return;
					}
				}
			}
		}
		
		System.out.println("0");
	}
	
	private static boolean findWinner(int i, int j, int flag) {
		for(int d=0; d<4; d++) {
			int cnt = 0;
			int nx = i;
			int ny = j;
			
			while(!(nx < 0 || nx >= 19 || ny < 0 || ny >= 19) && map[nx][ny] == flag) {
				++cnt;
				nx += dx[d];
				ny += dy[d];
			}
			
			if(cnt == 5) {
				int r = i - dx[d];
				int c = j - dy[d];
				
				if(r < 0 || r >= 19 || c < 0 || c >= 19) return true;
				if(map[r][c] != flag)
					return true;
			}
		}
		
		return false;
	}
}
