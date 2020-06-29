package RE.dp;

import java.io.*;
import java.util.*;

public class n9095 {
    static int T;
    static int n;
    static int[] dp = new int[12];
    public static void main( String[] args ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(in.readLine());

        while(T-- > 0){
            n = Integer.parseInt(in.readLine());

            dp[0] = 0;
            dp[1] = 0;
            dp[2] = 1;
            dp[3] = 3;

            if( n >= 4 ){
                for(int i=1; i < n ; i++){
                    dp[n] += (dp[n-i] + dp[i]);
                }
            }

            out.write((dp[n]-1)+"\n");
        }

        out.flush();
        in.close();
        out.close();
    }
}
