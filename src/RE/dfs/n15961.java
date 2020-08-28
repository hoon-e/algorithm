package RE.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n15961 {
	static int N, d, k, c, answer = -1; // 접시의 수, 초밥 갯수, 연속 접시 수, 쿠폰번호 
	static int[] line, chobab; // 회전 라인 / dp

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		line = new int[N];
		chobab = new int[d+1];
		
		for(int i=0; i<N; i++) {
			line[i] = Integer.parseInt(br.readLine());
		}
		
		++chobab[c]; // 쿠폰을 추가해준다.
		
		int ans = 1;
		for(int i=0; i<k; i++) {
			if(chobab[line[i]]++ == 0) ++ans;
			// 먹은 초밥의 갯수를 계산해준다.
		}
		
		int answer = ans; // 초기값 설정
		
		for(int i=k; i<N+k; i++) { // 한 칸씩 밀면서 값을 찾아준다.
			if(--chobab[line[i-k]] == 0)
				--ans;
			
			if(chobab[line[i%N]]++ == 0)
				++ans;
			
			answer = Math.max(answer, ans);
		}
		
		System.out.println(answer);
	}
}
