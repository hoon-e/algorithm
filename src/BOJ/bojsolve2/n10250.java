package BOJ.bojsolve2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n10250 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num=Integer.parseInt(br.readLine());
		
		for(int i=0; i<num; i++) {
			String[] b=br.readLine().split(" ");
			int[] h=new int[3];
			for(int j=0; j<3; j++) {
				h[j]=Integer.parseInt(b[j]);
			}
			
			int s=h[2]%h[0];
			int r=h[2]/h[0]+1;
			if(s == 0) {
				r-=1;
				s=h[0];
			}
			// 100을 곱해서 더해주면 된다. 사이 0은 알아서 추가됨
			bw.write((s*100+r)+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
