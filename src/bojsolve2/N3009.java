package bojsolve2;

import java.io.IOException;
import java.util.Scanner;

public class N3009 {
	public static void main(String[] args) throws IOException {
		Scanner scn = new Scanner(System.in);
		
		int[][] d = new int[4][2];
		
		for(int i=0; i<3; i++) {
			d[i][0] = scn.nextInt();
			d[i][1] = scn.nextInt();
		}
		
		d[3][0] = d[0][0];
		d[3][1] = d[0][1];
		
		if(d[3][0] == d[1][0]) {
			d[3][0] = d[2][0];
		}else if(d[3][0] == d[2][0]) {
			d[3][0] = d[1][0];
		}
		
		if(d[3][1] == d[1][1]) {
			d[3][1] = d[2][1];
		}else if(d[3][1] == d[2][1]) {
			d[3][1] = d[1][1];
		}
		
		System.out.println(d[3][0] + " " + d[3][1]);
		scn.close();
	}
}
