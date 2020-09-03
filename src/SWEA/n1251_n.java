package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class n1251_n {
	static class money {
		int dst;
		double own;
		money next;
		
		money(int dst, double own, money next){
			this.dst = dst;
			this.own = own;
			this.next = next;
		}
	}
	
	static class isl implements Comparable<isl>{
		int dst;
		double own;
		
		isl(int dst, double own){
			this.dst = dst;
			this.own = own;
		}
		
		public int compareTo(isl i) {
			if(own > i.own) return 1;
			else if(own == i.own) return 0;
			else return -1;
		}
	}
	
	static int T, V; // 테스트 케이스
	static double real; // 부담 실수
	static double[] boodam; // 부담금
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
			money[] dist = new money[V];
			
			for(int i=0; i<2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<V; j++)
					coord[i][j] = Integer.parseInt(st.nextToken());
			} // 좌표 입력
			 
			real = Double.parseDouble(br.readLine());
			
			for(int i=0; i<V; i++) { // 정점 간의 거리 구하기
				for(int j=i+1; j<V; j++) {
					double d = (pow(coord[0][i] - coord[0][j]) + pow(coord[1][i] - coord[1][j])) * real;
					dist[i] = new money(j, d, dist[i]);
					dist[j] = new money(i, d, dist[j]);
				}
			}
			
			double result = 0.0;
			
			PriorityQueue<isl> pq = new PriorityQueue<>();
			boodam[0] = 0;
			
			pq.offer(new isl(0, 0));
			
			while(!pq.isEmpty()) {
				isl cur = pq.poll();
				int curVtx = cur.dst;
				double curMon = cur.own;
				
				if(vst[curVtx]) continue;
				vst[curVtx] = true;
				
				result += curMon;
				money head = dist[curVtx];
				
				while(head != null) {
					int nextVtx = head.dst;
					double nextMon = head.own;
					
					if(!vst[nextVtx] && nextMon < boodam[nextVtx]) {
						boodam[nextVtx] = nextMon;
						pq.offer(new isl(nextVtx, nextMon));
					}
					
					head = head.next;
				}
			}
			
			bw.write(String.format("#%d %.0f\n", tc, result));
		}
		bw.flush();
	}
}
