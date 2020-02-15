package bojsolve;

import java.util.Scanner;

public class n10952 {
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		int[] number = new int[2];

		while(true) {
			number[0] = scn.nextInt();
			number[1] = scn.nextInt();
			scn.nextLine();
			
			if((number[0] >= 10 || number[0] <= 0 ) && (number[1] >= 10 || number[1] <= 0 )) {
				break;
			}
			System.out.println((number[0]+number[1]));
		}
		scn.close();
	}
}
