package BOJ.DFS_BFS;

import java.io.*;
import java.util.StringTokenizer;

public class n2573_2 {
    static int N, M;
    static int[][] mount;
    static boolean[][] chk;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        mount = new int[N+1][M+1];
        int time = 0;
        boolean flag = true;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int j=0;
            while(st.hasMoreTokens()){
                mount[i][j++] = Integer.parseInt(st.nextToken());
            }
        }

        while(true) {
            chk = new boolean[N + 1][M + 1];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (mount[i][j] == 0 || chk[i][j]) continue;
                    melt(i, j);
                }
            }

            time++;
            if (check() >= 2) {
                System.out.println(time);
                break;
            }
            else {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (mount[i][j] != 0) {
                            flag = false;
                            break;
                        }
                    }
                }

                if(flag) {
                    System.out.println("0");
                    break;
                }
            }
        }
    }

    static int check(){
        chk = new boolean[N + 1][M + 1];
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (mount[i][j] == 0 || chk[i][j]) continue;
                cnt++;
                dfs(i, j);
            }
        }
        return cnt;
    }

    static void dfs(int i, int j) {
        if(mount[i][j] == 0 || chk[i][j]) return;
        chk[i][j] = true;

        for(int k=0; k<4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            dfs(nx, ny);
        }
    }

    static void melt(int i, int j) {
        if(chk[i][j] || mount[i][j] == 0) return;

        chk[i][j] = true;
        int cnt = 0;
        for(int k=0; k<4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if(!chk[nx][ny] && mount[nx][ny] == 0) cnt++;
        }

        mount[i][j] -= cnt;
        if(mount[i][j] < 0) mount[i][j] = 0;
    }
}
