package SWEA.before;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class choo {
	static int N, ans;
	static int[] pend;
	static boolean flag;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		int tc = 0;
		while(tc++ < T) {
			N = Integer.parseInt(br.readLine());
			pend = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<N; i++)
				pend[i] = Integer.parseInt(st.nextToken());
			
			Arrays.sort(pend);
			
			ans = 0;
			scale(0, 0, 0);
			
			System.out.println("#"+tc+" "+ans);
		}
	}

	public static void scale(int cnt, int left, int right) {
		if(cnt == N) {
			++ans;
			return;
		}
		
		for(int i=cnt; i<N; i++) {
			int temp = pend[cnt];
			pend[cnt] = pend[i];
			pend[i] = temp;
			
			scale(cnt + 1, left + pend[cnt], right);
			
			if(left >= right + pend[cnt])
				scale(cnt + 1, left, right + pend[cnt]);
			
			temp = pend[cnt];
			pend[cnt] = pend[i];
			pend[i] = temp;
		}
	}
}
