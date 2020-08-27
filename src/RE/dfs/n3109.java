package RE.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n3109 {
	static int R, C;
	static char[][] map;
	static boolean flag;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String w[] = in.readLine().split(" ");
		
		R = Integer.parseInt(w[0]);
		C = Integer.parseInt(w[1]);
		
		map = new char[R][C];
		
		for(int i=0; i<R; i++)
			map[i] = in.readLine().toCharArray();
		
		int ans = 0;
		for(int row=0; row<R; row++) {
			flag = false;
			dfs(row, 0);
			if(flag)
				ans += 1;
		}
		
		System.out.println(ans);
	}
	
	static private void dfs(int row, int col) {
		if(flag) return;
		if(row < 0 || row >= R || col < 0 || col >= C || map[row][col] == 'x') return;
		if(col == C-1) {
			flag = true;
			return;
		}
		
		// 방문체크할 경우의 수가 있는 경우에, 이런 식으로 해줘도 괜찮다...
		// 이미 있는 내용을 가지고 체크를 해주는것..!
		map[row][col] = 'x';
		
		dfs(row-1, col+1); // 위쪽 방향으로 탐색해야 최선의 결과
		dfs(row, col+1);
		dfs(row+1, col+1);
	}
}
