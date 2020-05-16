package BOJ.DP;

import java.io.*;
import java.util.*;

public class N5557 {
    static int[] numbers;
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        numbers = new int[num+1];
        dp = new long[num+1][21];
        int val = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        int idx=1;
        while(st.hasMoreTokens()){
            numbers[idx++] = Integer.parseInt(st.nextToken());
        }
        val = 0;

        dp[1][numbers[1]] = 1;

        for(int i=2; i<=num-1; i++){
            for(int j=0; j<=20; j++){
                if(dp[i-1][j] > 0){
                    val = j + numbers[i];

                    if(val >= 0 && val <= 20)
                        dp[i][val] += dp[i-1][j];

                    val = j - numbers[i];

                    if(val >= 0 && val <= 20)
                        dp[i][val] += dp[i-1][j];
                }
            }
        }

        bw.write(dp[num-1][numbers[num]]+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
