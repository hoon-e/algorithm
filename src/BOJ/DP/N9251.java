package BOJ.DP;

import java.io.*;

public class N9251 {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line1 = br.readLine();
        String line2 = br.readLine();

        dp = new int[1001][1001];

        for(int i=1; i<=line1.length(); i++){
            for(int j=1; j<=line2.length(); j++){
                if(line1.charAt(i-1) == line2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        bw.write(dp[line1.length()][line2.length()]+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
