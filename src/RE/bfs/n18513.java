package RE.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n18513 {
	static int N;
	static long K;
	static long[] pool;
	static HashMap<Long, Boolean> check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Long.parseLong(st.nextToken());
		
		pool = new long[N];
		check = new HashMap<>();
		
		st = new StringTokenizer(br.readLine());
		
		Queue<long[]> q = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			long v = Long.parseLong(st.nextToken());
			q.offer(new long[] {v, 0});
			check.put(v, true);
		}
		
		long unlucky = 0;
		
		while(!q.isEmpty()) {
			long[] cur = q.poll();
			
			long vtx = cur[0];
			long dist = cur[1]+1;
			
			if(check.get(vtx+1) == null) {
				check.put(vtx+1, true);
				unlucky += dist;
				q.offer(new long[] {vtx+1, dist});

				if(--K == 0) break;
			}
			
			if(check.get(vtx-1) == null) {
				check.put(vtx-1, true);
				unlucky += dist;
				q.offer(new long[] {vtx-1, dist});
				
				if(--K == 0) break;
			}
		}
		
		System.out.println(unlucky);
	}
}
