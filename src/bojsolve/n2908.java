package bojsolve;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n2908 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] num = br.readLine().split(" ");
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		
		for(int i=2; i>=0; i--){
			sb1.append(num[0].charAt(i));
			sb2.append(num[1].charAt(i));
		}
		
		if(Integer.parseInt(sb1.toString()) - Integer.parseInt(sb2.toString()) > 0)
			bw.write(sb1 + "\n");
		else
			bw.write(sb2 + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
