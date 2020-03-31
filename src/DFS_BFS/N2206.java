package DFS_BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N2206 {
    static class coord {
        int x;
        int y;
        int cnt;
        int dist;

        coord(int x, int y, int cnt, int dist){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.dist = dist;
        }
    }

    static int N;
    static int M;
    static char[][] map;
    static int[][] chk;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N + 1][M + 1];
        chk = new int[N + 1][M + 1];
        int count = -1;

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                chk[i][j] = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        Queue<coord> q = new LinkedList<>();

        q.offer(new coord(0, 0, 0, 1));
        chk[0][0] = 0;

        while (!q.isEmpty()) {
            coord cur = q.poll();

            if(cur.x == N-1 && cur.y == M-1){
                count = cur.dist;
                break;
            }

            for (int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (chk[nx][ny] <= cur.cnt) continue;
                if (map[nx][ny] == '0') {
                    chk[nx][ny] = cur.cnt;
                    q.offer(new coord(nx, ny, cur.cnt, cur.dist+1));
                } else {
                    if (cur.cnt == 0) {
                        chk[nx][ny] = cur.cnt + 1;
                        q.offer(new coord(nx, ny, cur.cnt + 1, cur.dist+1));
                    }
                }
            }
        }

        if(count == -1)
            bw.write(count+"");
        else
            bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
