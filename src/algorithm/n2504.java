package algorithm;

import java.util.Scanner;
import java.util.Stack;

public class n2504 {
	public static void main(String[] args){
		
		Scanner scn = new Scanner(System.in);
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = scn.nextLine();
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
					System.out.print(0);
					System.exit(0);
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
					System.out.print(0);
					System.exit(0);
				}
			}
		}
		
		if(!s.isEmpty() || l != 0 || k != 0) {
			System.out.print(0);
		}else {
			System.out.print(sum);
		}
		
		scn.close();
	}
}
