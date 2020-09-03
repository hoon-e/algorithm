package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class n1251 {
	static int T, V; // 테스트 케이스
	static double real; // 부담 실수
	static double[] boodam; // 부담금
	static double[][] dist; // 환경 부담금
	static int[][] coord; // 인접 배열 , 좌표
	
	static boolean[] vst; // 방문 체크
	static final double INF = Double.MAX_VALUE;
		
	private static double pow(double val) {
		return (val*val);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			V = Integer.parseInt(br.readLine());
			
			boodam = new double[V];
			vst = new boolean[V];
				
			Arrays.fill(boodam, INF);
			
			coord = new int[2][V];
			dist = new double[V][V]; // 부담금 정보
			
			for(int i=0; i<2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<V; j++)
					coord[i][j] = Integer.parseInt(st.nextToken());
			} // 좌표 입력
			 
			real = Double.parseDouble(br.readLine());
			
			for(int i=0; i<V; i++) { // 정점 간의 거리 구하기
				for(int j=i+1; j<V; j++) {
					double d = (pow(coord[0][i] - coord[0][j]) + pow(coord[1][i] - coord[1][j])) * real;
					dist[i][j] = d;
					dist[j][i] = d; // 거리 정보 넣기
				}
			}
			
			double min;
			int minIndex =0;
			double result = 0.0;
			
			boodam[0] = 0;
						
			for(int i=0; i<V; i++) {
				min = Double.MAX_VALUE;
				minIndex = 0;
				
				for(int j=0; j<V; j++) {
					if(!vst[j] && min > boodam[j]) {
						min = boodam[j];
						minIndex = j;
					}
				}
				
				result += min;
				vst[minIndex] = true;
				
				for(int j=0; j<V; j++) {
					if(!vst[j]
							&& dist[minIndex][j] != INF
							&& boodam[j] > dist[minIndex][j]) {
						boodam[j] = dist[minIndex][j];
					}
				}
			}
			
			bw.write(String.format("#%d %.0f\n", tc, result));
		}
		bw.flush();
	}
}
