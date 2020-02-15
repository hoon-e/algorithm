package bojsolve;

import java.util.Scanner;

public class n10950 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int num = scn.nextInt();
		scn.nextLine();
		
		int[][] number = new int[num][2];
		
		for(int i=0; i<num; i++) {
			number[i][0] = scn.nextInt();
			number[i][1] = scn.nextInt();
			System.out.println("Case #"+ (i+1) + ": " + number[i][0] + " + " + number[i][1] + " = " + (number[i][0] + number[i][1]));
			scn.nextLine();
		}
		scn.close();
	}
}
