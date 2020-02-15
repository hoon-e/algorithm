package bojsolve;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n1316 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int line=Integer.parseInt(br.readLine());
		int count = line;
		char[][] s = new char[line][100];
		
		for(int i=0; i<line; i++) {
			s[i] = br.readLine().toCharArray();	
		}
		
		for(char[] w : s) {
			boolean[] isChecked = new boolean[26];
			for(int i=1; i<w.length; i++) {
				if(w[i-1] != w[i]) {
					if(isChecked[(int)w[i]-97] == true) {
						count--;
						break;
					}
					isChecked[(int)w[i-1]-97] = true;
				}
			}
		}
		
		bw.write(count+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
