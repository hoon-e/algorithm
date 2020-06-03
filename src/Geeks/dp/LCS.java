package Geeks.dp;

import java.io.*;
import java.util.*;

// 두 개에서 겹치는 구간의 가장 긴 길이. 연속적일 필요는 없다.
// nC0 + nC1 + nC2 + .... + nCn = 2^n
// 따라서 다른 가능한 모든 subsequence의 수는 2^n-1개 이다.( 길이가 0인 경우는 세지 않는다. )
// 브루트 포스의 방식의 시간 복잡도는 O(N*2^N)이다.
public class LCS {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] X = s1.toCharArray();
        char[] Y = s2.toCharArray();

        int ans = recurLCS(X, Y, X.length, Y.length);
        int iterAns = iterLCS(X, Y, X.length, Y.length);

        out.write(ans+"\n"+iterAns);
        out.flush();
        in.close();
        out.close();
    }

    // worst : O(2^N)
    static int recurLCS(char[] X, char[] Y, int m, int n){
        if(m == 0 || n == 0)
            return 0;
        if(X[m-1] == Y[n-1])
            return 1 + recurLCS(X, Y, m-1, n-1);
        else
            return max(recurLCS(X, Y, m, n-1), recurLCS(X, Y, m-1, n));
    }

    static int max(int a, int b){
        return (a > b) ? a : b;
    }

    // worst : O(N^2)
    static int iterLCS(char[] X, char[] Y, int mLen, int nLen){
        int[][] l = new int[mLen+1][nLen+1];

        for(int i=0; i<=mLen; i++){
            for(int j=0; j<=nLen; j++){
                if(i==0 || j==0)
                    l[i][j] = 0;
                else if(X[i-1] == Y[j-1])
                    l[i][j] = l[i-1][j-1] + 1;
                else
                    l[i][j] = max(l[i-1][j], l[i][j-1]);
            }
        }

        return l[mLen][nLen];
    }
}
