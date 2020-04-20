package BOJ.DP;

import java.io.*;

public class N11057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        long[][] dp = new long[num+1][11];

        for(int i=0; i<=9; i++)
            dp[0][i] = 1;

        for(int i=1; i<=num; i++){
            for(int j=9; j>=0; j--){
                dp[i][j] += ((dp[i-1][j] + dp[i][j+1]) % 10007);
            }
        }

        bw.write((dp[num][0] % 10007)+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
