package forTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n2630 {
	static int N, white, blue;
	static int[][] paper;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		paper = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++)
				paper[i][j] = Integer.parseInt(st.nextToken());
		}
		
		countPaper(0, 0, N);
		
		System.out.println(white + "\n" + blue);
	}
	
	private static void countPaper(int r, int c, int width) {
		if(width == 1) {
			if(paper[r][c] == 0) ++white;
			else ++blue;
			return;
		}
		
		int w=0, b=0;
		
		for(int i=r; i<r+width; i++) { // 종이를 센다
			for(int j=c; j<c+width; j++) {
				if(paper[i][j] == 0) ++w;
				else ++b;
			}
		}
		
		int half = width/2;
		
		if(w > 0 && b > 0) {
			countPaper(r, c, half);
			countPaper(r, c+half, half);
			countPaper(r+half, c, half);
			countPaper(r+half, c+half, half);
		} else {
			if(paper[r][c] == 0) ++white;
			else ++blue;
		}
	}
}
