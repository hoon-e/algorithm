package SWEA.D5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class optimalPath {
	static int T, n, ans, comX, comY, homeX, homeY, sub;
	static int[][] test;
	static int[] chk;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = null;
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=10; tc++) {
			n = Integer.parseInt(br.readLine());
			
			test = new int[n][2];
			chk = new int[n];
			
			sub = (1<<n)-1;
			
			st = new StringTokenizer(br.readLine());
			
			comX = Integer.parseInt(st.nextToken());
			comY = Integer.parseInt(st.nextToken());
			
			homeX = Integer.parseInt(st.nextToken());
			homeY = Integer.parseInt(st.nextToken());
			
			for(int i=0; i<n; i++) {
				test[i][0] = Integer.parseInt(st.nextToken());
				test[i][1] = Integer.parseInt(st.nextToken());
			}
			
			ans = Integer.MAX_VALUE;
			
			dfs(0, comX, comY, 0);
			
			bw.write(String.format("#%d %d", tc, ans));
			bw.newLine();
		}
		
		bw.flush();
	}
	
	private static int abs(int a, int b) {
		return (a > b) ? (a-b) : (b-a);
	}
	
	private static int min(int a, int b) {
		return (a < b) ? a : b;
	}
	
	private static void dfs(int flag, int w, int c, int sum) {
		if(sum >= ans) return;
		if(flag == sub) {
			sum += abs(w, homeX) + abs(c, homeY);
			ans = min(ans, sum);
			return;
		}
		
		for(int i=0; i<n; i++) {
			if((flag & (1<<i)) != 0) continue;
			dfs((flag | (1<<i)), test[i][0], test[i][1], sum + (abs(w, test[i][0]) + abs(c, test[i][1])));
		}
	}
}
