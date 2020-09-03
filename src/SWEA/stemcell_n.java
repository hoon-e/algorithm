package SWEA;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class stemcell_n {
	static int N, M, K, offset;
	static int[][] map;
	static ArrayList<Cell> alive; // 활성 + 비활성
	static PriorityQueue<Cell> active; // 동시에 번식해야 하는 애들 따로 모은다.
	
	static int[] di = {-1, 0, 1, 0};
	static int[] dj = {0, -1, 0, 1};
	static class Cell implements Comparable<Cell>{
		int i, j;
		int now;  // 태어나고 흐른 시간
		int life; // 고정 생명력
		
		Cell(int i, int j, int now, int life){
			this.i = i;
			this.j = j;
			this.now = now;
			this.life = life;
		}
		
		public int compareTo(Cell c) {
			return c.life - life;
		}
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int TC = scn.nextInt();
		
		for(int tc=1; tc<=TC; tc++) {
			N = scn.nextInt();
			M = scn.nextInt();
			K = scn.nextInt();
			
			offset = 2*K;
			
			map = new int[N+offset][M+offset];
			alive = new ArrayList<>();
			active = new PriorityQueue<>();
			
			for(int i=K; i<N+K; i++) {
				for(int j=K; j<M+K; j++) {
					map[i][j] = scn.nextInt();
					if(map[i][j] > 0) {
						alive.add(new Cell(i, j, 0, map[i][j]));
					}
				}
			} // 입력
			
			for(int time=1; time<=K; time++) {
				for(Cell c : alive) {
					c.now++; // 1시간이 지났으니 세포도 나이를 먹는다.
					if(c.now > c.life) { // 활성 시간이 생명력보다 커졌을 때 번식한다.
						active.add(c);
					}
				}
				
				while(!active.isEmpty()) {
					Cell c = active.poll();
					
					for(int d=0; d<4; d++) {
						int ni = c.i + di[d];
						int nj = c.j + dj[d];
						
						if(map[ni][nj] == 0) {
							map[ni][nj] = c.life;
							alive.add(new Cell(ni, nj, 0, c.life));
						}
					}
				} // 지금 동시에 번식하는 세포들은 다 번식한다.
				
				// 죽어야 되는 세포들 죽는다.
				for(int i=0; i<alive.size(); i++) {
					Cell c = alive.get(i);
					
					if(c.life*2 == c.now) {
						alive.remove(i);
						map[c.i][c.j] = -1;
						i--;
					}
				}
			}
			
			int cnt = 0;
			for(int[] row : map) {
				for(int num : row) {
					if(num > 0) ++cnt;
				}
			}
			
			System.out.format("#%d %d", tc, cnt);
		}
	}
}