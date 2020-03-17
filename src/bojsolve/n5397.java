package bojsolve;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class n5397 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int lineNum = Integer.parseInt(br.readLine());
		
		Stack<Character> s1 = new Stack<>();
		Stack<Character> s2 = new Stack<>();
		
		for(int i=0; i<lineNum; i++) {
			char[] line = br.readLine().toCharArray();
			StringBuffer sb = new StringBuffer();

			s1.clear();
			s2.clear();
			
			for(char s : line) {
				switch(s) {
					case '<':
						if(!s2.isEmpty()) {
							s1.push(s2.pop());
						}
						break;
					case '>':
						if(!s1.isEmpty()) {
							s2.push(s1.pop());
						}
						break;
					case '-':
						if(!s2.isEmpty()) {
							s2.pop();
						}
						break;
					default:
						if( s != '<' && s != '>' && s != '-') {
							s2.push(s);
						}
						break;
				}
			}
			
			while(!s1.isEmpty()) {
				s2.push(s1.pop());
			}
			
			for(char c : s2) {
				sb.append(c);
			}
			
			bw.write(sb+"\n");
			bw.flush();
		}
		
		bw.close();
		br.close();
		/* StringTokenizer 사용하면 더 편할 것같아서 찾아봄
		 * 
		 * countTokens() 토큰의 갯수를 리턴
		 * nextToken() 다음 토큰 리턴, 이전 토큰 제거
		 * nextToken(String delim)
		 * hasMoreTokens() 리턴할 다음 토큰이 있으면 true, 없으면 false 리턴
		 */
		
		/**
		 * StringBuilder vs StringBuffer
		 */
		/* ArrayList로 생각해본 방법 -> 시간초과가 발생한다.
		 * 문자열의 이동과 관련된 문제는 Stack을 사용하는 것이 시간이 빠르다.
		 * 또한 StringBuilder를 사용하면 시간을 단축할 수 있다.
		for(int i=0; i<lineNum; i++) {
			char[] line = br.readLine().toCharArray();
			int index = 0;
			StringBuffer sb = new StringBuffer();
			int len = sb.length();
			
			for(char s : line) {
				if( s == '<') {
					if(index <= 0 ) {
						index = 0;
						continue;
					}
					else {
						index--;
					}
				}
				else if( s == '>') {
					if(index >= len) {
						index = len;
					}
					else {
						index++;
					}
				}
				else if( s == '-') {
					if(index <= 0) {
						index=0;
						continue;
					}
					index--;
					sb.deleteCharAt(index);
				}
				else {
					sb.insert(index, s);
					index++;
				}
			}
			bw.write(sb+"\n");
			bw.flush();
		}
		br.close();
		bw.close();
		*/
	}
}
