package BOJ.bojsolve;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class n2941 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Stack<Character> s = new Stack<>();
		char[] word = br.readLine().toCharArray();
		int count = 0;

		for(int i=0; i < word.length; i++) {
			char w = word[i];
			if(w=='=') {
				if(s.get(s.size()-1)=='c' || s.get(s.size()-1)=='s') {
					s.add(w);
				}else if(s.get(s.size()-1)=='z') {
					if(s.size() >= 2 && s.get(s.size()-2)=='d') {
						count-=1;
					}
					s.add(w);
				}
			}else if(w=='-') {
				if(s.get(s.size()-1)=='c' || s.get(s.size()-1)=='d') {
					s.add(w);
				}
			}else if(w=='j') {
				if(s.isEmpty()) {
					s.add(w);
					count++;
				}else {
					if(s.get(s.size()-1)=='l' || s.get(s.size()-1)=='n') {
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