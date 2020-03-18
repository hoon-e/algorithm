package DP;

import java.io.*;

public class prefixSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n+1];
        int[] dist = new int[2*n];

        dist[0] = 0;
        for(int i=1; i<=n; i++){
            num[i] = Integer.parseInt(br.readLine());
            dist[i] = dist[i-1] + num[i];
        }

        int min = Integer.MIN_VALUE;
        for(int i=1; i<=n; i++)
            for(int j=i; j<=n; j++)
                min = Math.min(min, dist[j]-dist[i-1]);
    }
}
