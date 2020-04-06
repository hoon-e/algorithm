package BOJ.bojsolve;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n2920 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] w = br.readLine().split(" ");
		int[] n = new int[w.length];
		
		boolean asc = false;
		boolean desc = false;
		
		for(int i=0; i<w.length; i++) {
			n[i] = Integer.parseInt(w[i]);
		}
		
		for(int i=1; i<w.length; i++) {
			if(n[i-1] < n[i]) {
				asc = true;
			}
			else if(n[i-1] > n[i]){
				desc = true;
			}
		}
		
		if(asc&&desc)
			bw.write("mixed");
		else {
			if(asc)
				bw.write("ascending\n");
			else
				bw.write("descending\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
