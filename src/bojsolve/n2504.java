package bojsolve;

import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class n2504 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String line = br.readLine();
		int sum=0; int mul=1; int l=0; int k=0;
		
		// 값 넣는 스택
		Stack<Character> s = new Stack<>();
		
		if( line.length() > 30) {
			System.out.println(0);
			System.exit(0);
		}
		
		for(int i=0; i< line.length(); i++) {
			char b = line.charAt(i);
			if( b == '(') {
				s.add(b);
				++l;
				mul *= 2;
				
				if(i+1 < line.length() && line.charAt(i+1)==')') {
					sum += mul;
				}
			}
			else if( b == '[') {
				s.add(b);
				++k;
				mul *= 3;
				
				if(i+1 < line.length() && line.charAt(i+1)==']') {
					sum += mul;
				}
			}
			else if( b == ')' ) {
				if(!s.isEmpty()) {
					if(s.peek() == '(') {
						s.pop();
						--l;
						mul /= 2;
					}
				}
				else {
					bw.write(0+"\n");
					bw.flush();
					return;
				}
			}
			else if( b == ']') {
				if(!s.isEmpty()) {
					if(s.peek()=='[') {
						s.pop();
						--k;
						mul /= 3;
					}
				}
				else {
					bw.write(0+"\n");
					bw.flush();
					return;
				}
			}
		}
		
		if(!s.isEmpty() || l != 0 || k != 0) {
			bw.write(0+"\n");
		}else {
			bw.write(sum+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
