package RE.sliding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n2003 {
	static int N;
	static long M;
	static int[] num;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Long.parseLong(st.nextToken());
		
		num = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		
		for(int i=0; i<N; i++)
			num[i] = Integer.parseInt(st.nextToken());
		
		int l=0, r=0, result=0;
		long sum = 0;
		
		while(true) {
			if(sum >= M) sum -= num[l++];
			else if(r == N) break;
			else sum += num[r++];
			if(sum == M) ++result;
		}
		
		System.out.println(result);
	}
}
