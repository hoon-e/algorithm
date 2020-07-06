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
        num = new int[N];
        dp = new int[N];

        st = new StringTokenizer(in.readLine());

        for(int i=0; i<N; i++)
            num[i] = Integer.parseInt(st.nextToken());

        int max = -1;
        for(int i=0; i<N; i++){
            dp[i] = 1;
            int val = num[i];
            for(int j=i+1; j<N; j++){
                if(num[j] > val){
                    val = num[j];
                    dp[j] = dp[j-1] + 1;
                    max = Math.max(max, dp[j]);
                }else
                    dp[j] = dp[j-1];
            }
        }

        if(max == -1)
            out.write("1");
        else
            out.write(max+"");

        out.flush();
        in.close();
        out.close();
    }
}
