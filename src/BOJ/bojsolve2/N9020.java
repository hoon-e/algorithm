package BOJ.bojsolve2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N9020 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int test=Integer.parseInt(br.readLine());
		boolean[] prime = new boolean[10000];
		
		prime[2] = true;
		
		for(int i=2; i<prime.length; i++) {
			for(int j=2; i*j<prime.length; j++) {
				prime[i*j] = true;
			}
		}
		
		for(int i=0; i<test; i++) {
			int tnum=Integer.parseInt(br.readLine());
			int[] min = {0, 10000};
			
			for(int j=2; j<tnum; j++) {
				if(!prime[j] && !prime[tnum-j]) {
					if(j>tnum-j) {
						if( 2*j-tnum <= min[1]-min[0] ) {
							min[0] = tnum-j;
							min[1] = j;
						}
					}else {
						if( tnum-2*j <= min[1]-min[0] ) {
							min[0] = j;
							min[1] = tnum-j;
						}
					}
				}
			}
			bw.write(min[0] + " " + min[1]+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
