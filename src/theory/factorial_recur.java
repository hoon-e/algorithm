package theory;

import java.util.Scanner;

public class factorial_recur {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt();
		scn.nextLine();
		
		System.out.println(fac(n));
		scn.close();
	}
	
	static int fac(int num) {
		if(num == 1)
			return num;
		else
			return num * fac(num-1);
	}
}
