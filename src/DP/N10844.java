package DP;

import java.io.*;

public class N10844 {
    static int[][] m = new int[101][10];
    static final int MOD = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        for(int i=1; i<=9; i++){
            m[1][i] = 1;
        }

        for(int i=2; i<=num; i++){
            for(int j=0; j<10; j++){
                m[i][j] = 0;
                if(j-1 >= 0)
                    m[i][j] += m[i-1][j-1];
                if(j+1 <= 9)
                    m[i][j] += m[i-1][j+1];

                m[i][j] %= MOD;
            }
        }

        int sum = 0;
        for(int i=0; i<10; i++){
            sum += m[num][i];
            sum %= MOD;
        }

        bw.write(sum+"");
        bw.flush();
        bw.close();
    }
}
