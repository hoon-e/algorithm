package BOJ.DP;

import java.io.*;
import java.util.StringTokenizer;

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
            for(int j=0; j<N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                System.out.println(i + " " + j);
                for(int k=0; k<4; k++){
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                    if(map[nx][ny] > map[i][j]){
                        if(nx == 0 && ny == 0)
                            dp[i][j] = dp[nx][ny] + 1;
                        else if(dp[nx][ny] != 0)
                            dp[i][j] += dp[nx][ny];
                    }

                    if(map[nx][ny] < map[i][j] && dp[i][j] != 0) {
                        dp[nx][ny] = Math.max(dp[nx][ny], dp[nx][ny] + dp[i][j]);
                    }
                }

                for(int a=0; a<M; a++){
                    for(int b=0; b<N; b++)
                        System.out.print(dp[a][b] + " ");
                    System.out.println();
                }
            }
        }

        bw.write(dp[M-1][N-1]+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
