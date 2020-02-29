package bojsolve2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N1011 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		int tc=Integer.parseInt(br.readLine());
		String[] line;
		int d=0;
		for(int i=0; i<tc; i++) {
			line = br.readLine().split(" ");
			d = Integer.parseInt(line[1])-Integer.parseInt(line[0]);
			
			int m = (int)Math.ceil(Math.sqrt(d));
			int max = m*m;
			int times = m*2-1;
			
			if( d <= max-m ) {
				times--;
			}
			bw.write(times + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
