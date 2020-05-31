package Geeks.dp;

import java.io.*;
import java.util.*;

// Bottom-Up 방식
// 상향식으로 테이블을 작성하고, 테이블의 마지막 값을 반환한다.

class Tabulation {
    int fibonacci(int n){
        int[] f = new int[n+1];

        f[0] = 0;
        f[1] = 1;

        for(int i=2; i<=n; i++){
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }
}

// Top-down 방식
// Lookup array를 NIL로 초기화한다. 하위 문제를 풀때, lookup 테이블을 먼저 본다.
// Lookup table이 NIL이 아니라면, 이전의 값을 반환한다.

public class memoization {
    final int MAX = 100;
    final int NIL = -1;

    int[] lookup = new int[MAX];

    void _initialize(){
        Arrays.fill(lookup, NIL);
    }

    int fibonacci(int n){
        if(lookup[n] == NIL){
            if(n <= 1)
                lookup[n] = n;
            else
                lookup[n] = fibonacci(n-1) + fibonacci(n-2);
        }
        return lookup[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        memoization m = new memoization();
        Tabulation t = new Tabulation();
        int n = 40;
        m._initialize();

        out.write(m.fibonacci(n)+" "+t.fibonacci(n)+"\n");
        out.flush();
        in.close();
        out.close();
    }
}
