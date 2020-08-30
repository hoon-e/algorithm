package forTest;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

// 저울 추 만들기
public class n2205 {
	static int N;
	static boolean[] chk;
	public static void main(String[] args) throws IOException {
		Scanner scn = new Scanner(System.in);
		ArrayList<Integer> l = null;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = scn.nextInt();
		int idx = 0;
		
		for(int t=0; t<N; t++) {
			int cnt = 0;
			chk = new boolean[N+1];
			l = new ArrayList<>();
			
			for(int i=(1+t); i<=(N+t); i++) {
				for(int j=1; j<=N; j++) {
					if(chk[j]) continue;
					
					int q;
					
					if(i % N == 0) q = N + j; 
					else q = (i%N) + j;
					
					if(q == (q&-q)) {
						++cnt;
						l.add(j);
						chk[j] = true;
						break;
					}
				}
			}
			
			if(cnt == N) {
				idx = t;
				break;
			}
		}
		
		for(int i=idx; i<idx+N; i++) {
			bw.write(l.get((i%N))+"\n");
		}
		
		bw.flush();
		scn.close();
	}
}
