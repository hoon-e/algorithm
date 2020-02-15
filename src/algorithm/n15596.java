package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n15596 {
	public static long sum(int[] arr) {
		long sum=0;
		for(int i=0; i<arr.length; i++) {
			sum += arr[i];
		}
		
		return sum;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] word = br.readLine().split(" ");
		int[] num = new int[word.length];
		
		for(int i=0; i<num.length; i++) {
			num[i] = Integer.parseInt(word[i]);
		}
		
		bw.write(sum(num)+"\n");
		bw.flush();
		br.close();
		bw.close();
	}
}
