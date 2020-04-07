package BOJ.bojsolve;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class n2493 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] tower = new int[num+1];
		// 결과 저장
		int[] result = new int[num+1];

		int idx = 1;
		while(st.hasMoreTokens()){
			tower[idx++] = Integer.parseInt(st.nextToken());
		}

		Stack<Integer> t = new Stack<>();
		Stack<Integer> index = new Stack<>();

		t.push(tower[1]);
		index.push(1);
		result[1] = 0;

		for(int i=2; i<=num; i++) {
			while(!t.isEmpty()){
				int top = t.peek();
				if( top < tower[i]){
					t.pop();
					index.pop();
				}else{
					result[i] = index.peek();
					t.push(tower[i]);
					index.push(i);
					break;
				}
			}

			if(t.isEmpty()) {
				result[i] = 0;
				t.push(tower[i]);
				index.push(i);
			}
		}

		for(int i=1; i<=num; i++)
			bw.write(result[i]+ " ");
		bw.flush();
		bw.close();
		br.close();
	}
}