package BOJ.DP;

import java.io.*;
import java.util.*;

public class N11060 {
    static int N;
    static int[] nums;
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        nums = new int[N + 1];
        dp = new long[N + 1][N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++)
            nums[i] = Integer.parseInt(st.nextToken());

        dp[0][0] = 1;
        for(int i=1; i<=N; i++){
            if(nums[i] > 0){
                dp[i][i] = dp[i-1][i-1] + 1;
                for(int j=i+1; j<=i+nums[i]; j++){
                    if(j > N) break;
                        dp[i][j] = dp[i-1][j-1];
                }
            }
        }

        for(int i=1; i<=N; i++) {
            for (int j = 1; j <= N; j++)
                System.out.print(dp[i][j] + " ");
            System.out.println();
        }
    }
}
