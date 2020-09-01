package RE.combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// nextPermutation을 이용한 풀이
public class n14889 {
	static int N, min = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[] check;
	
	public static int abs(int a, int b) {
		return (a > b) ? a - b : b - a;
	}
	
	public static int min(int a, int b) {
		return (a < b) ? a : b;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		check = new boolean[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 맵 입력
					
		getCombination(0, 0);
		
		System.out.println(min);
	}
	
	private static void getCombination(int start, int cnt) {
		if(cnt == N/2) {		
			int lsum = 0, rsum = 0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(i == j) continue;
					if(check[i] && check[j]) 
						lsum += map[i][j];
					else if(!check[i] && !check[j])
						rsum += map[i][j];
				}
			}
			
			min = min(min, abs(lsum, rsum));
			return;
		}
		
		for(int i=start; i<N; i++) {
			if(check[i]) continue;
			check[i] = true;
			getCombination(i + 1, cnt + 1);
			check[i] = false;
		}
	}
}
