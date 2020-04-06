package BOJ.bojsolve;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class n3052 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] num = new int[10];
		Set<Integer> s = new HashSet<>();
		
		for(int i=0; i<10; i++) {
			num[i] = Integer.parseInt(br.readLine())%42;
			s.add(num[i]);
		}
		
		bw.write(s.size()+"\n");
		bw.flush();
		br.close();
		bw.close();
	}
}