package RE.dp;

import java.io.*;
import java.util.*;

public class n11053 {
    static int N;
    static int[] num;
    static int[] dp;
    public static void main( String[] args ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(in.readLine());
        num = new int[N+1];
        dp = new int[N+1];

        st = new StringTokenizer(in.readLine());

        for(int i=1; i<=N; i++)
            num[i] = Integer.parseInt(st.nextToken());

        int max = -1;

        dp[1] = 1;
        for(int i=2; i<=N; i++){
            dp[i] = 1;
            for(int j=1; j<i; j++){
                if(num[j] < num[i])
                    dp[i] = max(dp[i], dp[j] + 1);
            }
        }

        for(int i=1; i<=N; i++)
            max = max(max, dp[i]);

        out.write(max+"");
        out.flush();
        in.close();
        out.close();
    }

    static int max(int a, int b){
        return (a > b) ? a : b;
    }
}
