package bojsolve2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N2581 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int min = Integer.parseInt(br.readLine());
		int max = Integer.parseInt(br.readLine());
		int min_d=10000;
		
		int sum=0;
		int count=0;
		
		// 에라토스테네스의 체 이용?
		boolean[] prime = new boolean[max+1];
		
		prime[1] = true;
		for(int i=2; i<prime.length; i++) {
			for(int j=2; i*j < prime.length; j++) {
				prime[i*j] = true;
			}
		}
		for(int i=min; i<=max; i++) {
			if(!prime[i]) {
				if(count == 0)
					min_d = i;
				sum+=i;
				count++;
			}
		}
		
		if(count==0)
			bw.write(-1+"\n");
		else
			bw.write(sum+"\n"+min_d);
		
		bw.flush();
		bw.close();
		br.close();
	}
}

