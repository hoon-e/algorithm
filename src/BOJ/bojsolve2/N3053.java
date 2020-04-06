package BOJ.bojsolve2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N3053 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		int rad=Integer.parseInt(br.readLine());
		double u=Math.PI*(Math.pow(rad, 2));
		double m=rad*rad*2;
		String s = String.format("%.6f", u);
		String d = String.format("%.6f", m);
		bw.write(s+"\n"+d);
		bw.flush();
		bw.close();
		br.close();
	}
}
