package BOJ.bojsolve2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N1929 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		boolean[] prime = new boolean[b+1];
		
		prime[1] = true;
		
		for(int i=2; i<prime.length; i++) {
			for(int j=2; i*j<prime.length; j++) {
				prime[i*j] = true;
			}
		}
		
		for(int i=a; i<=b; i++) {
			if(!prime[i])
				bw.write(i+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
