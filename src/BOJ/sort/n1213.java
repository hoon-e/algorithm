package BOJ.sort;

import java.io.*;
import java.util.*;

// 팰린드롬
// 모든 문자가 짝수개 있는 경우
// 하나의 문자가 홀수 개 있고, 나머지 문자들이 짝수개 있다.
public class n1213 {
    static int[] alpha = new int[26];
    public static void main( String[] args ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] input = in.readLine().toCharArray();
        int len = input.length;

        for ( char c : input )
            ++alpha[c - 'A'];

        // 길이가 짝수 - 모든 알파벳의 갯수가 짝수여야 한다.
        // 길이가 홀수 - 하나의 알파벳만 홀수여야 한다.

        int oddCount = 0, oddVal = 0;

        for(int i=0; i<26; i++){
            if(alpha[i] % 2 == 1){
                ++oddCount;
                oddVal = i;
            }
        }

        // 길이가 짝수인데, 홀수 갯수의 알파벳이 있는 경우 || 길이가 홀수인데, 홀수 갯수인 알파벳이 한개가 아닌 경우
        if(((len%2 ==0) && oddCount > 0) || ((len%2 ==1) && oddCount != 1)){
            out.write("I'm Sorry Hansoo");
        }else {
            for(int i=0; i<26; i++){
                for(int j=0; j<alpha[i]/2; j++){
                    out.write((i+'A'));
                }
            }

            if(len % 2 == 1)
                out.write((oddVal+'A'));

            for(int i=25; i>=0; i--){
                for(int j=0; j<alpha[i]/2; j++)
                    out.write((i+'A'));
            }
        }

        out.flush();
        in.close();
        out.close();
    }
}
