package bojsolve;

import java.util.Scanner;

public class n10799 {
	public static int top = -1;
	public static int rod_top = -1;
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String line = "";
		
		int cutcount = 0;
		
		line = scn.nextLine();
		
		int len = line.length();
		
		char[] RAZOR = new char[len];
		char[] ROD = new char[len];
		
		for(int i=0; i<len; i++) {
			// ( 일경우 우선 추가한다.
			if( line.charAt(i) == '(' ) {
				if(line.charAt(i+1) == ')') { // 뒤가 바로 ) 일경우에만 RAZOR로 추가
					RAZOR[++top] = line.charAt(i);
				}
				ROD[++rod_top] = line.charAt(i); // ROD는 걍 추가
			}
			// 문자가 ) 일 경우 
			else if( line.charAt(i) == ')' ) {
					// RAZOR의 top이 (일 경우
					if( ROD[rod_top] == '(' & RAZOR[top] == '(' ) {
						RAZOR[++top] = line.charAt(i);
						
						ROD[rod_top] = '\0';
						rod_top--;
						
						int j = 0;

						while(ROD[j] == '(') {
							cutcount++;
							j++;
						}
					}
					// ROD의 top이 ( RAZOR의 top이 (가 아닐경우
					else if( ROD[rod_top] == '(' & RAZOR[top] != '(' ){
						ROD[rod_top] = '\0';
						rod_top--;
						cutcount++;
					}
			}
		}
		System.out.println(cutcount);
		scn.close();
	}
}
