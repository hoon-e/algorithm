package BOJ.bojsolve;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n2588 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int f=Integer.parseInt(br.readLine());
		int s=Integer.parseInt(br.readLine());
		
		int s3=f*(s%10);
		int s4=(int)(f*(s%100-s%10)/10);
		int s5=(int)(f*(s/100));
		int s6=s3+s4*10+s5*100;
		
		bw.write(s3+"\n");
		bw.write(s4+"\n");
		bw.write(s5+"\n");
		bw.write(s6+"\n");
		bw.flush();
	}
}
