package bojsolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n2493 {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		String[] tower = new String[num];
		int[] real_tower = new int[num];
		
		// 결과 저장
		int[] result = new int[num];
		
		tower = br.readLine().split(" ");
		
		for(int i=0; i<num; i++) {
			real_tower[i] = Integer.parseInt(tower[i]);
		}
				
		for(int j=num-1; j>=0; j--) {
			if(j == 0) {
				result[j] = 0;
				break;
			}
			
			int k = j-1;
			long cur = real_tower[j];
			
			while( k >= 0 ) {
				if( cur < real_tower[k] ) {
					result[j] = k+1;
					break;
				}
				k--;
			}
		}
		
		for(int n : result) {
			System.out.print(n + " ");
		}
	}
}