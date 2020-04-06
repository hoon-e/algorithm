package BOJ.bojsolve2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n2775 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		int c=Integer.parseInt(br.readLine());
		
		for(int i=0; i<c; i++) {
			int k=Integer.parseInt(br.readLine());
			int n=Integer.parseInt(br.readLine());
			
			int[] s=new int[n];
			
			for(int j=1; j<=n; j++) {
				s[j-1] = j;
			}
			
			for(int j=0; j<k; j++) {
				for(int t=0; t<n-1; t++) {
					s[t+1] += s[t];
				}
			}
			
			bw.write(s[n-1]+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
