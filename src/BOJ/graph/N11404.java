package BOJ.graph;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N11404 {
    static int n;
    static int m;
    static int[][] floyd;
    static final int INF = 100_000_00;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        floyd = new int[n+1][n+1];
        for(int i=1; i<=n; i++)
            Arrays.fill(floyd[i], INF);

        int u,v,p;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());

            floyd[u][v] = Math.min(p, floyd[u][v]);
        }

        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    floyd[i][j] = Math.min(floyd[i][j], floyd[i][k] + floyd[k][j]);
                }
            }
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(floyd[i][j] >= INF || i == j) floyd[i][j] = 0;
                bw.write(floyd[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
