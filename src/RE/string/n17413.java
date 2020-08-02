package RE.string;

import java.util.*;
import java.io.*;

public class n17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 알파벳 소문자('a'-'z'), 숫자('0'-'9'), 공백, 특수문자로 이루어져있다.
        // 문자열의 시작과 끝은 공백이 아니다.

        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        int idx = 0;
        int startIdx = 0;
        boolean f = false;

        if(line.contains("<")) {
            for(int i=0; i<line.length(); i++) {
                if(line.charAt(i) == '<') {
                    String[] s = line.substring(startIdx, startIdx+idx).split(" ");
                    for(int b=0; b<s.length; b++){
                        for(int a=s[b].length()-1; a>=0; a--)
                            sb.append(s[b].charAt(a));
                        if(b < s.length-1) sb.append(" ");
                    }
                    f = false;
                    idx = 0;

                    while(line.charAt(i) != '>') {
                        sb.append(line.charAt(i++));
                    }
                    sb.append(line.charAt(i));
                } else {
                    if(!f) {
                        f = true;
                        startIdx = i;
                    }
                    ++idx;
                }
            }

            String[] s = line.substring(startIdx, idx+startIdx).split(" ");
            for(int b=0; b<s.length; b++){
                for(int a=s[b].length()-1; a>=0; a--)
                    sb.append(s[b].charAt(a));
                if(b < s.length-1) sb.append(" ");
            }
        } else {
            String[] w = line.split(" ");

            for (String s : w) {
                for (int j = s.length() - 1; j >= 0; j--)
                    sb.append(s.charAt(j));
                sb.append(" ");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
