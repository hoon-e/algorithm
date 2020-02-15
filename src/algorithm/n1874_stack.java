package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class n1874_stack {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		ArrayList<String> result = new ArrayList<>();
		int in[] = new int[num+1];
		Stack <Integer> stack = new Stack<>();
		
		for(int i=1; i<=num; i++) {
			in[i] = Integer.parseInt(br.readLine());
		}
		
		int j=1;
		
		for(int i=1; i<=num; i++) {
			stack.push(i);
			result.add("+");
			
			// stack이 비어있지 않고 stack의 맨 위가 in[j]일 경우
			while(!stack.isEmpty() && stack.peek() == in[j]) {
				stack.pop();
				result.add("-");
				j++;
			}
		}
		
		if(stack.isEmpty()) {
			for(String s:result) {
				System.out.println(s);
			}
		}else {
			System.out.println("NO");
		}
	}

}

/**
* Scanner와 BufferedReader
* - Scanner
* : 사용하기는 편리하지만 속도가 느리다는 단점이 있다.
* - BufferedReader
* : 한줄을 통채로 입력받는 방법으로 비교적 빠를 수 있다는 장점이 있다. 
*/