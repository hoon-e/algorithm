package bojsolve;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class n2941 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		ArrayList<Character> s = new ArrayList<>();
		char[] word = br.readLine().toCharArray();
		int count = 0;
		
		for(int i=0; i < word.length; i++) {
			char w = word[i];
			int size=s.size(); // 4ms 추가됨
			if(w=='=') {
				if(s.get(size-1)=='c' || s.get(size-1)=='s') {
					s.add(w);
					continue;
				}else if(s.get(size-1)=='z') {
					if(s.size() >= 2 && s.get(size-2)=='d') {
						count-=1;
					}
					s.add(w);
				}
			}else if(w=='-') {
				if(s.get(size-1)=='c' || s.get(size-1)=='d') {
					s.add(w);
					continue;
				}
			}else if(w=='j') {
				if(s.isEmpty()) {
					s.add(w);
					count++;
				}else {
					if(s.get(size-1)=='l' || s.get(size-1)=='n') {
						s.add(w);
					}
					else
						count++;
				}
			}else {
				s.add(w);
				count++;
			}
		}
		
		bw.write(count + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
