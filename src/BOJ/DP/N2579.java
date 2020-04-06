package BOJ.DP;

import java.io.*;

public class N2579 {
    static int[][] d;
    static int[] score;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        d = new int[301][2];
        score = new int[301];

        for(int i=0; i<n; i++){
            score[i] = Integer.parseInt(br.readLine());
        }

        d[0][0] = score[0];
        d[1][0] = score[1];
        d[1][1] = score[0]+score[1];

        for(int i=2; i<n; i++){
            d[i][0] = Math.max(d[i-2][0], d[i-2][1])+score[i];
            d[i][1] = d[i-1][0]+score[i];
        }
        bw.write(Math.max(d[n-1][0], d[n-1][1])+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
