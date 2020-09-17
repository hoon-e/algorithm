package RE.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class n8913 {
	static boolean flag;
	static int ans;
	static HashMap<String, Boolean> check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		check = new HashMap<>();
		
		for(int tc=1; tc<=T; tc++) {
			String line = br.readLine().trim();
			ans = 0;
			flag = false;
			
			popString(line);
			if(flag) ans = 1;
			
			bw.write(ans + "\n");
		}
		bw.flush();
	}
	
	private static void popString(String line) {
		if(flag) return;
		if(check.get(line) != null && check.get(line)) {
			flag = true;
			return;
		}
		if(line.equals("")) {
			flag = true;
			return;
		}
		
		int idx = 0; // 시작하는 인덱스
		int len = 0; // 시작하는 길이
		char curWord = ' '; // 해당 단어
		StringBuilder sb = new StringBuilder();
		String tmp = "";
		
		for(int i = 0; i < line.length(); i++) {
			if(i == 0) { // 첫 단어라면
				idx = i; // 인덱스를 저장한 후
				len = 1;
				curWord = line.charAt(i); // 단어를 저장한다.
				continue; // 넘긴다
			}
			
			if(curWord == line.charAt(i)) { // 이전 단어가 현재 단어와 같다면
				++len; // 길이를 증가시킨다.
			} else { // 다르다면
				if(len >= 2) { // 길이가 2 이상임을 확인한다.
					tmp = line.substring(idx, idx+len);
					
					StringBuilder newLine = new StringBuilder(sb).append(line.substring(idx+len)); 
					popString(newLine.toString());
					
					if(flag) {
						check.put(newLine.toString(), true);
						return;
					}
					sb.append(tmp); // 추가
					
				} else { // 길이가 2보다 작으면 상관없다. 안되는 단어로 체크한다.
					tmp = line.substring(idx, idx+len);
					sb.append(tmp);
				}
				curWord = line.charAt(i); // 현재 단어를 초기화하고,
				idx = i;
				len = 1;
			}
			
			popString(sb.toString());
		}
	}
}