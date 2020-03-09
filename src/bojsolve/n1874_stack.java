package bojsolve;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class n1874_stack {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(br.readLine());
		
		Stack <Integer> stack = new Stack<>();

		int[] in = new int[num+1];
		for(int i = 1; i<=num; i++) {
			in[i] = Integer.parseInt(br.readLine());
		}
		
		int j=1;
		
		for(int i=1; i<=num; i++) {
			stack.push(i);
			bw.write("+\n");
			
			// stack이 비어있지 않고 stack의 맨 위가 in[j]일 경우
			while(!stack.isEmpty() && stack.peek() == in[j]) {
				stack.pop();
				bw.write("-\n");
				j++;
			}
		}

		if (!stack.isEmpty()) {
			bw.write("NO");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}

/**
* Scanner와 BufferedReader
* - Scanner
* : 사용하기는 편리하지만 속도가 느리다는 단점이 있다.
* - BufferedReader
* : 한줄을 통채로 입력받는 방법으로 비교적 빠를 수 있다는 장점이 있다. 
*/