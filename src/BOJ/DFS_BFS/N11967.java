package BOJ.DFS_BFS;

import java.awt.*;
import java.util.*;

public class N11967 {
    static boolean[][] vst;
    static boolean[][] light;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][] field;
    static int N;
    static int M;
    static ArrayList<Point>[][] d;
    static Queue<Point> q;
    static int count = 1;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int x, y, nx, ny;

        N = scn.nextInt();
        M = scn.nextInt();

        field = new int[N+1][N+1];
        light = new boolean[N+1][N+1];
        d = new ArrayList[N+1][N+1];

        for(int i=1; i<=N; i++)
            for(int j=1; j<=N; j++)
                d[i][j] = new ArrayList<>();

        for(int i=0; i<M; i++){
            x = scn.nextInt();
            y = scn.nextInt();
            nx = scn.nextInt();
            ny = scn.nextInt();
            d[x][y].add(new Point(nx, ny));
        }

        q = new LinkedList<>();
        vst = new boolean[N+1][N+1];

        q.offer(new Point(1,1));
        field[1][1] = 1;
        light[1][1] = true;
        vst[1][1] = true;

        while(!q.isEmpty()){
            Point cur = q.poll();
            lightUp(cur);
            bfs();
        }

        System.out.println(count);
        scn.close();
    }

    static void lightUp(Point cur){
        if (!d[cur.x][cur.y].isEmpty()) {
            for (int p = 0; p < d[cur.x][cur.y].size(); p++) {
                Point lgt = d[cur.x][cur.y].get(p);

                if (light[lgt.x][lgt.y]) continue;
                light[lgt.x][lgt.y] = true;
                field[lgt.x][lgt.y] = 1;
                count++;
            }
        }
    }

    static void bfs(){
        Queue<Point> rq = new LinkedList<>();
        boolean[][] chk = new boolean[N+1][N+1];

        rq.offer(new Point(1,1));
        chk[1][1] = true;

        while(!rq.isEmpty()){
            Point cur = rq.poll();

            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 1 || nx > N || ny < 1 || ny > N) continue;
                if(!light[nx][ny] || field[nx][ny] == 0 || chk[nx][ny]) continue;

                if(!vst[nx][ny]) {
                    q.offer(new Point(nx, ny));
                    vst[nx][ny] = true;
                }
                chk[nx][ny] = true;
                rq.offer(new Point(nx, ny));
            }
        }
    }
}
