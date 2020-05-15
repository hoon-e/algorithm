package BOJ.DP;

import java.io.*;
import java.util.*;

public class N11066 {
    static int[] sum;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            int t = Integer.parseInt(br.readLine());
            int size = t+1;

            sum = new int[size];
            dp = new int[size][size];

            st = new StringTokenizer(br.readLine());

            int idx = 1;
            while(st.hasMoreTokens()) {
                dp[0][idx++] = Integer.parseInt(st.nextToken());
            }

            sum[1] = dp[0][1];
            for(int j=2; j<size; j++)
                sum[j] = sum[j-1] + dp[0][j];

            for(int j=1; j<size-1; j++) {
                dp[j][j+1] = dp[0][j] + dp[0][j+1];
            }

            for(int sub=2; sub<size; sub++){
                for(int k=1; k + sub < size; k++){
                    int l = k + sub;
                    dp[k][l] = Integer.MAX_VALUE;

                    for(int index = k; index < l; index++){
                        dp[k][l] = Math.min((dp[k][index] + dp[index+1][l] + getSum(sum, k, l)), dp[k][l]);
                    }
                }
            }

            bw.write(dp[1][t]+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int getSum(int[] s, int st, int end){
        if(st == 1)
            return s[end];
        else
            return s[end] - s[st-1];
    }
}