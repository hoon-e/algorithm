package RE.backtracking;

import java.util.Scanner;

public class n9663 {
	static int N;
	static int[] column;
	static int answer;
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		N = scn.nextInt();
		column = new int[N+1];
		
		setQueen(1);
		
		System.out.println(answer);
		scn.close();
	}
	
	// 퀸을 현재 row 에 놓기
	private static void setQueen(int row) {
		if(row > N) {
			++answer;
			return;
		}
//		// 완탐의 방식이라면
//		if(row > N) {
//			// 답을 탐색해주는 코드가 필요하다.
//			return;
//		}
		
		// 가능한 선택지는 (1열 ~ N열)
		// 여기서, 다른 조건지를 걸러주는 방식을 사용한다.
		for(int col=1; col<=N; col++) {
			column[row] = col;
			if(checking(row)) setQueen(row+1);
			// 초기화를 해줘야하는가?
			// 필요없다 -> 왜냐? 이차원이 아니라 일차원 배열이기 때문이다.
		}
	}
	
	private static boolean checking(int row) {
		// column[row] == column[i] : 같은 열 체크
		// Math.abs(colums[row] - column[i]) == row - i;
		for(int i=1; i < row; i++) {
			if( (column[row] == column[i]) || Math.abs(column[row] - column[i]) == row - i) 
				return false;
		}
		
		return true;
	}
}
