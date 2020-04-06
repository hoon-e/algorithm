package BOJ.bojsolve;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class n10809 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		/* 첫번째 풀이 - 내 풀이
		String line = br.readLine();
		
		for(int i=0; i<26; i++) {
			String w = Character.toString((char)(i+97));
			if(line.contains(w)) {
				bw.write(line.indexOf(w) + " ");
			}else {
				bw.write("-1 ");
			}
		}
		bw.write("\n");
		bw.flush();
		bw.close();
		br.close();
		*/
		
		int cnt = 0;
		int[] alphabet = new int[26];
		
		// 미리 -1을 저장
		for(int i=0; i<26; i++) {
			alphabet[i] = -1;
		}
		
		Scanner scn = new Scanner(System.in);
		String a = scn.nextLine();
		
		for(int i=0; i<a.length(); i++) {
			char ch = a.charAt(i);
			int ch2 = (int)ch;
			int ch3 = ch2-97; // 97을 빼서 0으로 변경
			
			if(alphabet[ch3]==-1) // 배열에 든 숫자가 -1이 아니라면 카운터 1씩 증가한후 배열에 삽입
				alphabet[ch3]=cnt++;
			else // 배열에 -1이 아닌 숫자가 들었을때 cnt를 1 증가
				cnt+=1;
		}
		
		for(int i=0; i<26; i++) {
			System.out.println(alphabet[i]);
			System.out.println(" ");
		}
	}
}
