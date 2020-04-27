package BOJ.DP;

import java.io.*;

public class N2133 {
    static int[] dp = new int[31];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        dp[0] = 1;
        dp[2] = 3;
        for(int i=4; i<=num; i+=2){
            dp[i] = dp[i-2]*dp[2];
            for(int j=4; j<=i; j+=2){
                dp[i] += 2*dp[i-j];
            }
        }

        bw.write(dp[num]+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
