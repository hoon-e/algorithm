package SWEA.D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class nextPermGyuyeong {
	static int T, win, lose;
	static int[] gyu, in;
	static boolean[] chk;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			win=0; lose=0;
			chk = new boolean[19];
			gyu = new int[9];
			in = new int[9]; // 규영이와 인영이
			
			for(int i=0; i<9; i++) {
				gyu[i] = Integer.parseInt(st.nextToken());
				chk[gyu[i]] = true;
			}
			
			int idx = 0;
			for(int i=1; i<=18; i++) {
				if(!chk[i]) in[idx++] = i;
			}
			
			Arrays.sort(in);
			
			do {
				int gyuSum = 0;
				int inSum = 0;
				
				for(int i=0; i<9; i++) {
					int g = gyu[i];
					int e = in[i];
					
					if(g > e)
						gyuSum += (g + e);
					else if(gyu[i] < in[i])
						inSum += (g + e);
				}
				
				if(gyuSum > inSum) ++win;
				else if(gyuSum < inSum) ++lose;
			}while(nextPermutation());
			
			bw.write(String.format("#%d %d %d\n", tc, win, lose));
		}
		bw.flush();
	}
	
	static void swap(int a, int b){
		int tmp = in[a];
		in[a] = in[b];
		in[b] = tmp;
	}
	
	static boolean nextPermutation() {
		int i = in.length-1;
		
		while(i > 0 && in[i-1] >= in[i]) --i;
		if(i == 0) return false;
		
		int j = in.length-1;
		while(in[i-1] >= in[j]) --j;
		
		swap(i-1, j);
		
		int k = in.length-1;
		while(i <= k) {
			swap(i++, k--);
		}
		
		return true;
	}
}
