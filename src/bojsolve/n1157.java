package bojsolve;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n1157 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] alpha = new int[26];
		int max = 0;
		boolean same = false;
		
		String line = br.readLine();
		line = line.toLowerCase();
		
		for(int i=0; i<26; i++)
			alpha[i] = 0;
		
		for(int j=0; j<line.length(); j++) {
			int n = ((int)line.charAt(j))-97;
			alpha[n]++;
			
			if( alpha[n] > alpha[max] ) {
				max = n;
				same = false;
			}else if( alpha[n] == alpha[max] && (n != max) ) {
				same = true;
			}else if( alpha[n] == alpha[max] && (n == max)) {
				max = n;
				same = false;
			}
		}
		
		if(same)
			bw.write("?");
		else
			bw.write((char)(max+65));
		
		bw.flush();
		bw.close();
		br.close();
	}
}
