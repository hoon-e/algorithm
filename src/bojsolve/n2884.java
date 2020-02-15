package bojsolve;

import java.util.Scanner;

public class n2884 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int h = scn.nextInt();
		int m = scn.nextInt();
		int wh=0, wm=0;
		scn.nextLine();
		
		if(m-45 < 0) {
			wm = m+15;
			wh = h-1;
			
			if(wh < 0) {
				wh+=24;
			}
		}
		else {
			wm = m-45;
			wh = h;
		}
		
		System.out.println(wh + " " + wm);
	}
}
