package bojsolve2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class n2869 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		int day=1; // 걸리는 시간
		int climb=a-b; // 하루에 올라갈 수 있는
		
		v -= a; // 전체 거리에서 마지막 올라가야하는 거리를 빼줌.
		
		int howmany = v/climb; 
		
		if(v-(howmany*climb) <= 0) {
			day += howmany;
		}else {
			day += howmany+1;
		}
		bw.write(day+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
