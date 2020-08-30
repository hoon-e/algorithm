package forTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n1992 {
	static int N;
	static char[][] map;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		for(int i=0; i<N; i++)
			map[i] = br.readLine().toCharArray();
		
		quadTree(0, 0, N);
		
		System.out.println(sb.toString());
	}
	
	private static void quadTree(int r, int c, int width) {
		if(width == 1) {
			sb.append(map[r][c]);
			return;
		}
		
		int z = 0, o = 0;
		for(int i=r; i<r+width; i++) {
			for(int j=c; j<c+width; j++) {
				if(map[i][j] == '0') ++z;
				else ++o;
			}
		}
		
		int half = width/2;
		
		if(o > 0 && z > 0) {
			sb.append('(');
			quadTree(r, c, half);
			quadTree(r, c+half, half);
			quadTree(r+half, c, half);
			quadTree(r+half, c+half, half);
			sb.append(')');
		} else
			sb.append(map[r][c]);
	}
}
