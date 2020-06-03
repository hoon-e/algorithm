package Geeks.dp;

import java.io.*;
import java.util.*;

// Given Cost matrix cost[][] and position (m,n)
public class minCostPath {
    private static int min(int x, int y, int z){
        if(x < y)
            return (x < z) ? x : z;
        else
            return (y < z) ? y : z;
    }

    private static int minCost(int[][] cost, int m, int n){
        int[][] tc = new int[m+1][n+1];

        tc[0][0] = cost[0][0];

        // Initialize first column of total cost
        for(int i=1; i<=m; i++)
            tc[i][0] = tc[i-1][0] + cost[i][0];

        // Initialize first row of total cost
        for(int j=1; j<=n; j++)
            tc[0][j] = tc[0][j-1] + cost[0][j];

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++)
                tc[i][j] = min(tc[i-1][j-1], tc[i-1][j], tc[i][j-1]) + cost[i][j];
        }

        return tc[m][n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(in.readLine());

        int[][] cost = new int[t][t];

        for(int i=0; i<t; i++){
            StringTokenizer st = new StringTokenizer(in.readLine());

            int j = 0;
            while(st.hasMoreTokens()){
                cost[i][j++] = Integer.parseInt(st.nextToken());
            }
        }

        out.write(minCost(cost, t-1, t-1) + "\n");
        out.flush();
        in.close();
        out.close();
    }
}
