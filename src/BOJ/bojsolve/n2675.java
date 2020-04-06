package BOJ.bojsolve;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n2675 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int linenum = Integer.parseInt(br.readLine());
		String[] word;
		
		for(int i=0; i<linenum; i++) {
			StringBuffer sb = new StringBuffer();
			word = br.readLine().split(" ");
			
			for(int j=0; j<word[1].length(); j++) {
				for(int k=0; k<Integer.parseInt(word[0]); k++) {
					sb.append(word[1].charAt(j));
				}
			}
			bw.write(sb.toString() + "\n");			
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
