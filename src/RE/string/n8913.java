package RE.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class n8913 {
	static ArrayList<int[]> idxs;
	static boolean flag;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			String line = br.readLine();
			
			idxs = new ArrayList<>();
			
			int len = 1, idx = 0;
			char word = line.charAt(0);
			flag = false;
			
			for(int i=1; i<line.length(); i++) {
				if(word != line.charAt(i)) { // 단어가 다르면
					if(len >= 2) idxs.add(new int[]{idx, idx+len}); // 만약 지금까지의 길이가 2보다 크다면 인덱스 ArrayList에 추가
					idx = i; // 지금으로 idx 수정
					word = line.charAt(i); // 단어를 지금 단어로 수정
					len = 1; // 길이도 수정
				} else {
					++len;
				}
			}
			
			
			
			if(flag) bw.write("1\n");
			else bw.write("0\n");
		}
		
		bw.flush();
	}
}
