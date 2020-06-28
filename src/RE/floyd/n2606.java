package RE.floyd;

import java.io.*;
import java.util.*;

public class n2606 {
    static int N;
    static final int INF = 100_000;
    public static void main( String[] args ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(in.readLine());
        int M = Integer.parseInt(in.readLine());
        int[][] floyd = new int[N+1][N+1];

        for(int i=0; i<=N; i++)
            Arrays.fill(floyd[i], INF);

        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(in.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            floyd[x][y] = 1;
            floyd[y][x] = 1;
        }

        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(floyd[i][k] + floyd[k][j] < floyd[i][j])
                        floyd[i][j] = floyd[i][k] + floyd[k][j];
                }
            }
        }

        int cnt = 0;
        for(int i=2; i<=N; i++){
            if(floyd[1][i] != INF)
                ++cnt;
        }

        out.write(cnt+"");
        out.flush();
        in.close();
        out.close();
    }
}
