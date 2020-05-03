package BOJ.DP;

import java.io.*;
import java.util.StringTokenizer;

public class N1937 {
    static int N;
    static int[][] map;
    static int[][] dp;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    // maxDay는 1이다.
    static int max = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new int[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(dp[i][j] == -1)
                    eatBamboo(i, j);
            }
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int eatBamboo(int x, int y){
        if(dp[x][y] == -1) {
            dp[x][y] = 1;
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                int temp = 1;
                if (map[x][y] < map[nx][ny]) {
                    temp += eatBamboo(nx, ny);
                    dp[x][y] = Math.max(temp, dp[x][y]);
                    max = Math.max(max, dp[x][y]);
                }
            }
        }
        return dp[x][y];
    }
}
