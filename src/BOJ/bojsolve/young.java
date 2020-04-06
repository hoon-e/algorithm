package BOJ.bojsolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class young {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		int[] number = new int[num];
		String[] line = new String[num];
		
		int sum = 0;
		int max = -1;
		boolean isPrime = true;
		
		line = br.readLine().split("");
		br.close();
		
		for(int i=0; i<num; i++) {
			number[i] = Integer.parseInt(line[i]);
		}
		
		for(int i=0; i<num; i++) {
			for(int pivot=i; pivot<num; pivot++) {
				sum = 0;
				for(int j=i; j<pivot+1; j++) {
					sum += (int)Math.pow(10, pivot-j)*number[j];
				}
				
				if(sum == 1){
					continue;
				}
				else
				{
					for(int k=2; k*k<sum; k++) {
						int mod = sum % k;
						
						if(mod == 0) {
							isPrime = false;
							break;
						}
						else
							isPrime = true;
					}
					
					if(isPrime && sum > max) {
						max = sum;	
					}
				}
			}
		}
		System.out.println(max);
	}
}
