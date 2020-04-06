package BOJ.bojsolve2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n1193 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num=Integer.parseInt(br.readLine());
		boolean dir = false;
		int x=1; // 분모
		int y=1; // 분자
		
		for(int i=1; i<=num; i++) {
			if(i==1)
				continue;
			if(dir) {
				x+=1;
				y-=1;
				if(y==0) {
					dir=!dir;
					y+=1;
				}
			}else {
				x-=1;
				y+=1;
				if(x==0) {
					dir=!dir;
					x+=1;
				}
			}
		}
		bw.write(x+"/"+y+"\n");
		bw.flush();
		br.close();
		bw.close();
	}
}