package BOJ.bojsolve;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class n9935 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuffer sb = new StringBuffer();
		Stack<Character> s = new Stack<>();
		
		// 넣어야 하는 인덱스
		int size = 0;
		
		String line = br.readLine();
		String bomb = br.readLine();
		
		for(int i=0; i<line.length(); i++) {
			s.push(line.charAt(i));
			int j=bomb.length();
			
			// 뒤에서 부터 비교를 시작하고
			if(line.charAt(i) == bomb.charAt(j-1)) { // C4중 4부터 비교를 시작한다.
				boolean check = false;
				size = bomb.length();
				
				// bomb의 길이만큼 비교를 해주어야한다.
				for(int k=1; k<=size; k++) {
					if((s.size()-k) >= 0 && s.get(s.size()-k) == bomb.charAt(--j)) {
						check = true;
					}
					else
					{
						check = false;
						break;
					}
				}
				
				if(check) {
					for(int k=0; k<size; k++)
						s.pop();
				}
			}
		}
		
		if(s.isEmpty()) {
			bw.write("FRULA");
		}
		else {
			for(char word : s) {
				sb.append(word);
			}
			
			bw.write(sb+"\n");
			bw.flush();
		}
		br.close();
		bw.close();
	}
}
/*
public class n9935 {
	public static void main(String[] args) throws IOException{ 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		String bomb = br.readLine();

//		ArrayList<Character> no;
//		ArrayList<Character> yes;
//		ArrayList<Character> fin;

		int j=0;
		
		StringBuffer fin = new StringBuffer();
		StringBuffer yes;
		StringBuffer no;
		
//		fin = new ArrayList<>();
		
		for(int i=0; i<line.length(); i++) {
			fin.append(line.charAt(i));
		}
		
		// 해결 못한 이유 : 문자열이 다 찾아졌는지를 어떻게 확인하는가?
		while(fin.toString().contains(bomb)) {
			no = new StringBuffer();
			yes = new StringBuffer();
			
			for(int i=0; i<fin.length(); i++) {
				if(fin.charAt(i) == bomb.charAt(j)) {
					yes.append(fin.charAt(i));
					j++;
					
					if(j == bomb.length()) {
						j = 0;
						yes.setLength(0);
					}
				}else if(j < bomb.length() && !(yes.length() == 0)){
					no.append(yes.charAt(0));
					yes.setLength(0);
				}
				else {
					no.append(fin.charAt(i));
				}
			}
			
			fin = no;	
		}
		
		if(fin.length() == 0) {
			bw.write("FRULA\n");
		}else {
			bw.write(fin+"\n");
			bw.flush();
		}
		
		br.close();
		bw.close();
	}
}
*/

/**
 * @param args
 * @throws IOException
 * 
 * 1. 문자열에서 어떻게 같은 값을 찾을 것인가
 * 2. 문자열을 반복해서 어떻게 검색할 것 인가
 */

