package SWEA.D4;

import java.util.*;
import java.io.*;

public class n1868 {
    static char[][] map;
    static boolean[][] chk;
    static int n;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=t; tc++) {
            n = Integer.parseInt(br.readLine());
            map = new char[n][n];

            for (int i = 0; i < n; i++)
                map[i] = br.readLine().toCharArray();

            chk = new boolean[n][n];
            int click = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(map[i][j] == '*' || chk[i][j]) continue;

                    int cnt = 0;
                    for(int d=0; d<8; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                        if(map[nx][ny] == '*') ++cnt;
                    }

                    if(cnt == 0) {
                        chk[i][j] = true;
                        ++click;
                        for(int d=0; d<8; d++) {
                            int nx = i + dx[d];
                            int ny = j + dy[d];

                            if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                            if(chk[nx][ny]) continue;
                            findZero(nx, ny);
                        }
                    }
                }
            }

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(chk[i][j] || map[i][j] == '*') continue;
                    ++click;
                }
            }
            bw.write(String.format("#%d %d\n", tc, click));
        }
        bw.flush();
    }

    private static void findZero(int r, int c) {
        int cnt = 0;
        for(int d=0; d<8; d++) {
            int nr = r + dx[d];
            int nc = c + dy[d];

            if(nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
            if(map[nr][nc] == '*') ++cnt;
        }

        chk[r][c] = true;
        if(cnt == 0) {
            for(int d=0; d<8; d++) {
                int nr = r + dx[d];
                int nc = c + dy[d];

                if(nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                if(chk[nr][nc]) continue;
                findZero(nr, nc);
            }
        } else {
            map[r][c] = Character.forDigit(cnt, 10);
        }
    }
}
