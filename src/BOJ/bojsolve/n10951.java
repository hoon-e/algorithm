package BOJ.bojsolve;

import java.util.Scanner;

/**
 * @author kjhch
 * EOF에 관련된 문제
 * hasNext~함수를 이용한다.
 */

public class n10951 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		while(scn.hasNextInt()) {
			int a = scn.nextInt();
			int b = scn.nextInt();
			System.out.println(a+b);
		}
	}
}
