package bojsolve;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n2292 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		int room=Integer.parseInt(br.readLine());
		int i=1;
		int start=0;
		int end=1;
		while(true) {
			if(room==1) {
				bw.write(1+"\n");
				break;
			}
			if(room >= start && room <= end) {
				bw.write(i+"\n");
				break;
			}
			if(start==0)
				start+=2;
			start += 6*(i-1);
			end += 6*i;
			i++;
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
