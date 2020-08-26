package RE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 선분을 잇는다... 교집합이 있는가?
// Union Find의 아이디어

public class n17619 {
	static int N, Q;
	static int[][] coord;
	static int[] rank, parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		coord = new int[N][3];
		rank = new int[N];
		parent = new int[N];
		
		for(int i=0; i<N; i++)
			parent[i] = i;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++)
				coord[i][j] = Integer.parseInt(st.nextToken());
			coord[i][2] = i;
		}
		
		Arrays.sort(coord, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[0] - b[0];
			}
		});
		
		int f = 0, s = 1;
		while(f < N && s < N) {
			if(coord[s][0] <= coord[f][1]) {
				union(coord[s][2], coord[f][2]);
				++s;
			} else
				++f;
		}
		
		for(int i=0; i<Q; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			if(parent[start-1] == parent[end-1]) 
				bw.write("1\n");
			else 
				bw.write("0\n");
		}
		
		bw.flush();
	}
	
	private static int find(int val) {
		return (val == parent[val]) ? val : (parent[val] = find(parent[val]));
	}
	
	private static void union(int u, int v) {
		int nu = find(u);
		int nv = find(v);
		
		if(nu == nv) return;
		if(rank[nu] > rank[nv]) parent[nv] = nu;
		else parent[nu] = nv;
		if(rank[nu] == rank[nv]) rank[nv]++;
	}
}
