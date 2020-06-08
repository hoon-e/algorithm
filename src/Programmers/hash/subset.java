package Programmers.hash;

import java.io.*;
import java.util.*;

public class subset {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = 10;
        int[] cases = new int[cnt];

        // 부분집합을 만드는 코드
        // cnt가 4라면 2^4 만큼의 부분집합이 존재가능
        // 각 비트와 비트연산을 하여 1이라면, many에다가 더해주어야한다.

        for(int i=1; i<=(1<<cnt)-1; i++){
             int many = 1;

             // 부분집합
             for(int j=0; j<cnt; j++){
                 if((i & (1 << j)) != 0){
                     many *= cases[j];
                 }
             }
             answer += many;
        }

        out.flush();
        in.close();
        out.close();
    }
}
