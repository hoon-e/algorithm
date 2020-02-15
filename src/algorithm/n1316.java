package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class n1316 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		ArrayList<Character> a=new ArrayList<>();
		int line=Integer.parseInt(br.readLine());
		int count=0;
		char[][] s = new char[line][100];
		
		for(int i=0; i<line; i++) {
			s[i] = br.readLine().toCharArray();	
		}
		
		for(char[] w : s) {
			for(int i=0; i<w.length; i++) {
				for(int j=i+1; j<w.length; j++) {
					
				}
			}
		}
	}
}
