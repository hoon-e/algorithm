package BOJ.bojsolve;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n2798 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] s = br.readLine().split(" ");
		String[] card = br.readLine().split(" ");
		int[] c = new int[card.length];
		int max=Integer.parseInt(s[1]);
		int sum=0;
		int result=0;
		int length = c.length;
		// 전체 경우에서 3가지의 카드를 뽑는 경우의 수 : C(n,3)
		for(int i=0; i<length; i++) {
			c[i] = Integer.parseInt(card[i]);
		}
		
		for(int i=0; i<length; i++) {
			for(int j=i+1; j<length; j++) {
				for(int k=j+1; k<length; k++) {
					sum = c[i] + c[j] + c[k];
					if( sum <= max ) {
						if( sum >= result ) {
							result = sum;
						} 
					}
				}
			}
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
