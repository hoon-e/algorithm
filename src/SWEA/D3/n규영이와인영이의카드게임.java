package SWEA.D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class n규영이와인영이의카드게임 {
	static int T, win, lose;
	static int[] gyu = new int[9];
	static boolean[] chk;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			win=0; lose=0;
			chk = new boolean[19];
			
			for(int i=0; i<9; i++) {
				gyu[i] = Integer.parseInt(st.nextToken());
				chk[gyu[i]] = true;
			}

			fight(0, 0, 0);
			
			bw.write("#" + tc + " " + win + " " + lose);
			bw.newLine();
		}
		
		bw.flush();
	}
	
	private static void fight(int g, int o, int cnt) {
		if(cnt == 9) {
			if(g > o) ++win;
			else ++lose;
			return;
		}
		
		for(int i=1; i<=18; i++) {
			if(chk[i]) continue;
			chk[i] = true;
			
			if(gyu[cnt] > i)
				fight(g + gyu[cnt] + i, o, cnt+1);
			else if(gyu[cnt] < i)
				fight(g, o + gyu[cnt] + i, cnt+1);
			else
				fight(g, o, cnt+1);
			
			chk[i] = false;
		}
	}
}
