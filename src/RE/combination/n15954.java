package RE.combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n15954 {
	static int N, K;
	static double pyeoncha = Double.MAX_VALUE;
	static int[] number; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		number = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int k=K; k<=N; k++) {
			for(int i=0; i<=N-k; i++) {
				double sum=0, avg=0;
				for(int j=i; j<i+k; j++) {
					sum += number[j]; // 합계
				}
				
				avg = (sum / k); // 평균
				
				double devsum = 0;
				for(int j=i; j<i+k; j++) {
					devsum += Math.pow((number[j]-avg), 2);
				}
				
				double dev = (devsum/k);
				pyeoncha = min(pyeoncha, Math.sqrt(dev));
			}
		}
		
		System.out.format("%.11f", pyeoncha);
	}
	
	public static double min(double a, double b) {
		return (a > b) ? b : a;
	}
}
