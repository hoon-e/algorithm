package BOJ.DP;

import java.io.*;
import java.util.Arrays;

public class N9251 {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] temp = br.readLine().toCharArray();
        int len1 = temp.length;

        char[] line1 = new char[len1+1];
        if (temp.length - 1 >= 0)
            System.arraycopy(temp, 0, line1, 1, temp.length - 1);

        temp = br.readLine().toCharArray();
        int len2 = temp.length;

        char[] line2 = new char[len2+1];
        if (temp.length - 1 >= 0)
            System.arraycopy(temp, 0, line2, 1, temp.length - 1);

        dp = new int[1001][1001];

        int tp;

        for(int i=1; i<=len1; i++){
            for(int j=1; j<=len2; j++){
                if(line1[i] == line2[j]) tp = 1;
                else tp = 0;

                dp[i][j] = Math.max(dp[i][j-1], Math.max(dp[i-1][j-1]+tp, dp[i-1][j]));
            }
        }

        bw.write(dp[len1][len2]+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
