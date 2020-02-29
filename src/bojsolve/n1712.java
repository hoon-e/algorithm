package bojsolve;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n1712 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] line = br.readLine().split(" ");
		long[] n = new long[line.length];
		
		for(int i=0; i<line.length; i++){
			n[i] = Long.parseLong(line[i]);
		}
		
		if(n[2]-n[1] > 0) {
			long c = (long)(n[0]/(n[2]-n[1]));
			bw.write((c+1)+"\n");
		}else {
			bw.write(-1+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
