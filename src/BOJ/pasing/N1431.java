package BOJ.pasing;

import java.io.*;
import java.util.*;

/*
기타를 시리얼 번호 순서대로 정렬하고자 한다.
모든 시리얼 번호는 알파벳 대문자 (A-Z)와 숫자 (0-9)로 이루어져 있다.
시리얼번호 A가 시리얼번호 B의 앞에 오는 경우는 다음과 같다.

A와 B의 길이가 다르면, 짧은 것이 먼저 온다.
만약 서로 길이가 같다면, A의 모든 자리수의 합과 B의 모든 자리수의 합을 비교해서 작은 합을 가지는 것이 먼저온다. (숫자인 것만 더한다)
만약 1,2번 둘 조건으로도 비교할 수 없으면, 사전순으로 비교한다. 숫자가 알파벳보다 사전순으로 작다.
 */

public class N1431 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(in.readLine());
        String[] serial = new String[N];

        for(int i=0; i<N; i++){
            serial[i] = in.readLine();
        }

        Arrays.sort(serial, (o1, o2) -> {
            if(o1.length() != o2.length()) {
                return o1.length() - o2.length();
            }else {
                int s1=0; int s2=0;
                for(int i=0; i<o1.length(); i++){
                    if(Character.isDigit(o1.charAt(i))){
                       s1 += o1.charAt(i)-'0';
                    }
                    if(Character.isDigit(o2.charAt(i))){
                        s2 += o2.charAt(i)-'0';
                    }
                }

                if( s1 == s2 ){
                    return o1.compareTo(o2);
                }else
                    return s1 - s2;
            }
        });

        for(int i=0; i<N; i++)
            out.write(serial[i]+"\n");
        out.flush();
        in.close();
        out.close();
    }
}
