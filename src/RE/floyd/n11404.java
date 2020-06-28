package RE.floyd;

import java.io.*;
import java.util.*;

public class n11404 {
    static final int INF = 100_000_000_1;

    public static void main( String[] args ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(in.readLine());
        int M = Integer.parseInt(in.readLine());
        long[][] city = new long[N+1][N+1];

        for(int i=1; i<=N; i++)
            Arrays.fill(city[i], INF);

        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(in.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            long w = Long.parseLong(st.nextToken());

            city[x][y] = min(city[x][y], w);
        }

        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(city[i][k] + city[k][j] < city[i][j])
                        city[i][j] = city[i][k] + city[k][j];
                }
            }
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(i == j || city[i][j] == INF)
                    out.write(0 + " ");
                else
                    out.write(city[i][j] + " ");
            }
            out.write("\n");
        }

        out.flush();
        in.close();
        out.close();
    }

    static long min(long x, long y){
        return (x < y) ? x : y;
    }
}
