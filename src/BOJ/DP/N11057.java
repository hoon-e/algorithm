package BOJ.DP;

import java.io.*;

public class N11057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        long[][] dp = new long[num+1][num+1];

        long ans;

        for(int i=0; i<=num; i++){
            dp[i][0] = 1;

            for(int j=0; j<i; j++){

            }
        }
    }
}
