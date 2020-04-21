package BOJ.DP;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N2294 {
    static int n;
    static int k;
    static int[] coin;
    static int[] dp;
    static final int FLAG = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        coin = new int[n];
        dp = new int[100001];

        Arrays.fill(dp, FLAG);

        for(int i=0; i<n; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }

        for(int j=0; j<n; j++)
            dp[coin[j]] = 1;

        for(int i=1; i<=k; i++){
            for(int j=0; j<n; j++){
                if(i < coin[j]) continue;
                if(dp[i] == FLAG) {
                    if(dp[i - coin[j]] == FLAG) continue;
                    dp[i] = (dp[coin[j]] + dp[i - coin[j]]);
                }
                else {
                    if(dp[i - coin[j]] == FLAG) continue;
                    dp[i] = Math.min(dp[i], (dp[coin[j]] + dp[i - coin[j]]));
                }
            }
        }

        if(dp[k] == FLAG)
            bw.write("-1\n");
        else
            bw.write(dp[k]+"\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
