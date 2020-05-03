package BOJ.DP;

import java.io.*;
import java.util.StringTokenizer;

public class N1890 {
    static int N;
    static int[][] map;
    static long[][] dp;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        dp = new long[N+1][N+1];

        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        dp[1][1] = 1;
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(dp[i][j] == 0 || i == N && j == N) continue;
                for(int k=0; k<2; k++){
                    int nx, ny;
                    if(k == 0){
                        nx = i + (map[i][j] * dx[k]);
                        ny = j + dy[k];
                    }else{
                        nx = i + dx[k];
                        ny = j + (map[i][j] * dy[k]);
                    }

                    if(nx < 0 || nx > N || ny < 0 || ny > N ) continue;
                    dp[nx][ny] += dp[i][j];
                }
            }
        }

        bw.write(dp[N][N] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
