package RE.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class KMP {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// 찾으려고 하는 문자열
		char[] text = in.readLine().toCharArray();
		
		// 찾으려고 하는 패턴
		char[] pattern = in.readLine().toCharArray();
		
		int tLength = text.length;	  // 문자열의 길이
		int pLength = pattern.length; // 페턴의 길이
		
		// 실패함수 만들기 : KMP의 아이디어를 똑같이 적용
		// W에서 W를 찾는 듯한 행위를 해서...
		int[] fail = new int[pLength];
		
		// i:접미사 포인터(i=1부터 시작: 우리는 실패함수를 만드는게 목적이므로 첫글자 틀리면 0위치로 가야하므로.)
		// j:접두사 포인터
	    for(int i=1, j=0; i<pLength; i++){
	        while(j > 0 && pattern[i] != pattern[j]) {
	        	j = fail[j-1];  
	        }
	        if(pattern[i] == pattern[j]) fail[i] = ++j;
	    }
		
		int cnt = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		// i : 텍스트 포인터 , j: 패턴 포인터 
		for(int i=0,j=0; i<tLength; ++i) { 	
			while(j>0 && text[i] != pattern[j]) 
				j = fail[j-1]; 
			
			//두 글자 일치
			if(text[i] == pattern[j]) {
				// j가 패턴의 마지막 인덱스라면
				if(j == pLength-1) {  
					cnt++; // 카운트 증가
					list.add((i+1)-pLength+1); 
					j = fail[j]; 
				}else {
					j++;
				}
			}
		}
		
		System.out.println(cnt);
		
		if(cnt > 0) {
			System.out.println(list);
		}
	}
}