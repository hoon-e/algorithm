package BOJ.DP;

import java.io.*;
import java.util.StringTokenizer;

// memoization
public class N1520 {
    static int M;
    static int N;
    static int[][] map;
    static int[][] dp;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        dp = new int[M][N];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        bw.write(downWay(0, 0)+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int downWay(int row, int col){
        if(row == M-1 && col == N-1)
            return 1;

        if(dp[row][col] == -1){
            dp[row][col] = 0;

            for(int i=0; i<4; i++){
                int nrow = row + dx[i];
                int ncol = col + dy[i];

                if(nrow < 0 || nrow >= M || ncol < 0 || ncol >= N) continue;
                if(map[row][col] > map[nrow][ncol])
                    dp[row][col] += downWay(nrow, ncol);
            }
        }
        return dp[row][col];
    }
}
