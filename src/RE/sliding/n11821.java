package RE.sliding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n11821 {
	static int N, ret;
	static long S;
	static int[] num;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Long.parseLong(st.nextToken());
		
		num = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++){
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		find(0, 0);
		System.out.println((S == 0) ? ret-1 : ret);
	}
	
	private static void find(int cnt, long sum) {
		if(cnt == N) {
			if(sum == S) ++ret;
			return;
		}
		
		find(cnt+1, sum);
		find(cnt+1, sum + num[cnt]);
	}
}
