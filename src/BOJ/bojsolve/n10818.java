package BOJ.bojsolve;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class n10818 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		int[] number = new int[num];
		
		String[] line = br.readLine().split(" ");
		
		for(int i=0; i<num; i++) {
			number[i] = Integer.parseInt(line[i]);
		}
		Arrays.sort(number);
		bw.write(number[0]+" "+number[num-1]);
		bw.flush();
		br.close();
		bw.close();
	}
}
