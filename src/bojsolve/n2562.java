package bojsolve;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n2562 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] number = new int[9];
		int max = 0;
		int index=0;
		
		for(int i=0; i<9; i++) {
			number[i] = Integer.parseInt(br.readLine());
			
			if(number[i] > max) {
				max = number[i];
				index = i+1;
			}
		}
		
		bw.write(max + "\n" + index);
		bw.flush();
		br.close();
		bw.close();
	}
}
