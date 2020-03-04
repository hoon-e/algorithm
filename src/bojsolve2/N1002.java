package bojsolve2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N1002 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

		int test=Integer.parseInt(br.readLine());

		for(int i=0; i<test; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());

			double r = Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1),2));

			if(x1 == x2 && y1 == y2 && r1 == r2){
				bw.write(-1+"\n");
			}else if((x1 == x2 && y1 == y2 && r1 != r2) || (r > r1+r2) || (r < Math.abs(r1-r2))){
				bw.write(0+"\n");
			}else if((r == (r1+r2)) || Math.abs(r1-r2) == r){
				bw.write(1+"\n");
			}else{
				bw.write(2+"\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
