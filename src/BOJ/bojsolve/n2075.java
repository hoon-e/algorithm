package BOJ.bojsolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class n2075 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer 사용
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Long> q = new ArrayList<>();
		
		// long[] arr = new long[n*n];
		long[][] arr = new long[N][N];
		
		for(int i=0; i<N; i++) {
			// st = new StringTokenizer(br.readLine());
			String[] line = br.readLine().split(" ");
			
			for(int j=0; j<N; j++) {
				arr[i][j] = Long.parseLong(line[j]);
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				q.add(arr[i][j]);
			}
		}
		
		// Arrays.sort(arr);
		q.sort(null);
		System.out.println(q.get(N*N - N));
	}
}

/**
시간을 좀 더 줄이기 위해 PriorityQueue를 사용할 수 있다.
우선순위 큐 : 우선순위를 비교해서 자동으로 정렬이 되는 자료구조이다.

정렬 조건을 직접 설정할 수도 있으며, 기본적으로 Integer 형으로 선언하면 작은 수가 제일 먼저 pop됩니다.

**/
