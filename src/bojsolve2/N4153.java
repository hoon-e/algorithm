package bojsolve2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class N4153 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 세 숫자가 순서대로 들어온다는 보장이 없다.
		while(true) {
			int[] cane = new int[3];
			String[] w = br.readLine().split(" ");
			
			for(int i=0; i<3; i++)
				cane[i] = Integer.parseInt(w[i]);
			
			Arrays.sort(cane);
			
			if((cane[0]==0)&&(cane[1]==0)&&(cane[2]==0))
				break;
			
			if((cane[2]*cane[2]) == ((cane[1]*cane[1])+(cane[0]*cane[0]))) {
				bw.write("right\n");
			}else
				bw.write("wrong\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
