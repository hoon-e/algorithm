package BOJ.DP;

import java.io.*;
import java.util.StringTokenizer;

public class N11054 {
    static int N;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        dp = new int[N+1][3];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1; i<=N; i++) {
            dp[i][0] = Integer.parseInt(st.nextToken());
        }

        for(int j=1; j<=N; j++){
            dp[j][1] = 1; // 증가하는 부분
            dp[j][2] = 1; // 감소하는 부분

            for(int k=1; k<j; k++){
                if(dp[k][0] < dp[j][0]){
                    // 현재 숫자가 더 작다면 증가하는 수열 부분을 추가해준다.
                    dp[j][1] = Math.max(dp[j][1], dp[k][1]+1);
                }
                if(dp[k][0] > dp[j][0]){
                    // 현재 숫자가 더 작다면 감소하는 수열 부분을 추가해준다.
                    dp[j][2] = Math.max(dp[j][2], dp[k][2] + 1);
                    // 그리고 현재까지 증가하는 부분 수열이 있는지의 정보도 추가해주어야한다.
                    dp[j][2] = Math.max(dp[j][2], dp[k][1] + 1);
                }
            }
        }

        int ans = -1;
        for(int i=1; i<=N; i++) {
            ans = Math.max(ans, Math.max(dp[i][1], dp[i][2]));
        }

        bw.write(ans+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
