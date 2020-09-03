package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class stemcell {
	static int T, N, M, K; // 테스트 케이스, N, M, 시간
	static int[][] map; // 맵 정보
	static int offset;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		T = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		offset = 2*K;
		
		Queue<int[]> q = new LinkedList<>();
		Queue<int[]> spread = new LinkedList<>();
		
		map = new int[N+offset][M+offset]; // 맵
		
		for(int i=offset; i<N+offset; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=offset; j<M+offset; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] != 0) {
					q.offer(new int[] {i, j, map[i][j], 2}); 
				}
			}
		}
		
		// Status : 0 죽음 1 활성 2 비활성
		int time = 0;
		
		
	}
}
