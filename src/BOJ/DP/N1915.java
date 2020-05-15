package BOJ.DP;

import java.io.*;
import java.util.StringTokenizer;

public class N1915 {
    static int N;
    static int M;
    static char[][] map;
    static int[][] dp;
    static int MAX = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        dp = new int[N][M];

        for(int i=0; i<N; i++) {
            String line = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = line.charAt(j);
                if(map[i][j] == '1'){
                    dp[i][j] = 1;
                    MAX = 1;
                }
            }
        }

        for(int i=1; i<N; i++){
            for(int j=1; j<M; j++){
                if(map[i-1][j] == '1' && map[i-1][j-1] == '1' && map[i][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i-1][j-1]), dp[i][j-1]) + 1;
                }
                MAX = Math.max(MAX, dp[i][j]);
            }
        }

        bw.write((MAX*MAX)+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
