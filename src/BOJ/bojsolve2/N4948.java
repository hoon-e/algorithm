package BOJ.bojsolve2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N4948 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			int count=0;
			boolean[] prime = new boolean[2*n+1];
			if(n==0)
				break;
			
			for(int i=2; i<prime.length; i++) {
				for(int j=2; i*j <prime.length; j++)
					prime[i*j] = true;
			}
			
			for(int i=n+1; i<=2*n; i++) {
				if(!prime[i])
					count++;
			}
			bw.write(count+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
