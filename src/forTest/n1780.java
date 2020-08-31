package forTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n1780 {
	static int N;
	static int[] number;
	static int[][] num;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		num = new int[N][N];
		number = new int[3];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++)
				num[i][j] = Integer.parseInt(st.nextToken());
		}
		
		findNum(0, 0, N);
		System.out.println(number[0] + "\n" + number[1] + "\n" + number[2]);
	}
	
	private static void findNum(int r, int c, int width) {
		if(width == 1) {
			++number[num[r][c]+1];
			return;
		}
		
		int m=0, o=0, z=0;
		for(int i=r; i<r+width; i++) {
			for(int j=c; j<c+width; j++) {
				if(num[i][j] == -1) ++m;
				else if(num[i][j] == 0) ++z;
				else ++o;
			}
		}
		
		int w = width/3;
		int n = (width*width);
		
		if(!(m == n || o == n || z == n)) {
			findNum(r, c, w);
			findNum(r, c+w, w);
			findNum(r, c+2*w, w);
			findNum(r+w, c, w);
			findNum(r+w, c+w, w);
			findNum(r+w, c+2*w, w);
			findNum(r+2*w, c, w);
			findNum(r+2*w, c+w, w);
			findNum(r+2*w, c+2*w, w);
		} else {
			++number[num[r][c]+1];
		}
	}
}
