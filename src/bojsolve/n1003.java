package bojsolve;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n1003 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num=Integer.parseInt(br.readLine());
		
		for(int i=0; i<num; i++) {
			int h=Integer.parseInt(br.readLine());
			bw.write(fib(h) + " " + fib(h+1)+"\n");
			bw.flush();
		}
	}
	
	public static int fib(int n) {
		int z = 1;
		int o = 0;
		int zo = 1;
		
		if(n==0)
			return 1;
		else if(n==1)
			return 0;
		else {
			for(int i=1; i<=n; i++) {
				z=o;
				o=zo;
				zo=z+o;
			}
		}
		return z;
	}
}
