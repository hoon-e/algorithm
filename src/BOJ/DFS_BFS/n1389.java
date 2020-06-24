package BOJ.DFS_BFS;

import java.io.*;
import java.util.*;

public class n1389 {
    static int N;
    static int M;
    static int[][] users;
    static int[] bacon;

    public static void main( String[] args ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        users = new int[N + 1][N + 1];
        bacon = new int[N + 1];

        for(int i=0; i<=N; i++)
            Arrays.fill(users[i], 100_000);

        for ( int i = 0; i < M ; i++ ) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            users[a][b] = 1;
            users[b][a] = 1;
        }

        for ( int k = 1; k <= N; k++ ) {
            for ( int i = 1; i <= N; i++ ) {
                for ( int j = 1; j <= N; j++ ) {
                    if ( users[i][k] + users[j][k] < users[i][j] ) {
                        users[i][j] = users[i][k] + users[j][k];
                    }
                }
            }
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(i == j) continue;
                bacon[i] += users[i][j];
            }
        }

        int idx = bacon[1];
        int ans = 1;

        for(int i=2; i<=N; i++){
            if(bacon[i] < idx){
                idx = bacon[i];
                ans = i;
            }else if(bacon[i] == idx){
                if(ans > i)
                    ans = i;
            }
        }

        out.write(ans+"");
        out.flush();
        in.close();
        out.close();
    }
}
