package BOJ.bojsolve;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n5622 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] dial = {3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,8,9,9,9,10,10,10,10};
		int sum=0;
		char[] line = br.readLine().toCharArray();
		
		for(int i=0; i<line.length; i++){
			sum += dial[(int)line[i]-65];
		}
		
		bw.write(sum + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
