package BOJ.DP;

import java.io.*;
import java.util.*;

// LCS
// LCS를 완성하는 단계를 알고 있는가?
public class n9252 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuffer sb = new StringBuffer();

        char[] c1 = in.readLine().toCharArray();
        char[] c2 = in.readLine().toCharArray();

        int len1 = c1.length;
        int len2 = c2.length;

        int[][] dp = new int[len1+1][len2+1];

        for(int i=0; i<=len1; i++){
            for(int j=0; j<=len2; j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                else if(c1[i-1] == c2[j-1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int len = dp[len1][len2];

        if(len != 0){
            int i = len1;
            int j = len2;

            while(i >= 1 && j >= 1){
                if(dp[i][j] == dp[i-1][j]){
                    --i;
                }else if(dp[i][j] == dp[i][j-1]){
                    --j;
                }else{
                    sb.append(c1[i-1]);
                    --i; --j;
                }
            }

            out.write(dp[len1][len2] + "\n" + sb.reverse().toString());
        }else{
            out.write(0+"\n");
        }

        out.flush();
        in.close();
        out.close();
    }
}
