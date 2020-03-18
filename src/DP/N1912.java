package DP;

import java.io.*;
import java.util.StringTokenizer;

public class N1912 {
    static int[] n = new int[100001];
    static int[] d = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        int i=1; int max = Integer.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            n[i++] = Integer.parseInt(st.nextToken());
        }

        d[1] = n[1];
        for(int k=2; k<=num; k++)
            d[k] = Math.max(0, d[k-1]) + n[k];

        for(int j=1; j<=num; j++){
            if(d[j] > max)
                max = d[j];
        }

        bw.write(max+" ");
        bw.flush();
        bw.close();
        br.close();
    }
}
