package BOJ.bojsolve;

import java.util.Scanner;

public class n1874 {

	static public int top = 0;
	static public int r_top = -1;
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int num = scn.nextInt();
		int k = 0;
		
		int[] STACK = new int[num];
		int[] RESULT = new int[num];
		char[] OP = new char[100];
		
		// 비교 스택 초기화
		for(int i=0; i<num; i++) {
			STACK[i] = scn.nextInt();
		}
		
		// 로직
		for(int i=0; i<num; i++) {
			RESULT[++r_top] = i+1;
			OP[k++] = '+';
			if(RESULT[r_top] == STACK[top]) {
				int temp = r_top;
				for(int j=0; j<=temp; j++) {
					if(RESULT[r_top] == STACK[top]) {
						OP[k++] = '-';
						top++;
						r_top--;
					}
				}
			}
		}
		
		OP[k] = '\n';
		
		if(r_top == -1){
			int l = 0;
			while( OP[l] != '\n') {
				System.out.println(OP[l]);
				l+=1;
			}
		}else
			System.out.println("NO");
		
		scn.close();
	}
}
