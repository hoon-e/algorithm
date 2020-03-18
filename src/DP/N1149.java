package DP;

import java.io.*;
import java.util.StringTokenizer;

public class N1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] color = new int[n][3];
        int[][] v = new int[n][3];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int j=0;
            while(st.hasMoreTokens()){
                color[i][j++] = Integer.parseInt(st.nextToken());
            }
        }

        v[0][0] = color[0][0];
        v[0][1] = color[0][1];
        v[0][2] = color[0][2];

        for(int i=1; i<n; i++){
            v[i][0] = Math.min(v[i-1][1], v[i-1][2]) + color[i][0];
            v[i][1] = Math.min(v[i-1][0], v[i-1][2]) + color[i][1];
            v[i][2] = Math.min(v[i-1][0], v[i-1][1]) + color[i][2];
        }

        bw.write(Math.min(v[n-1][0], Math.min(v[n-1][1], v[n-1][2]))+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
