package RE.bfs;

import java.io.*;
import java.util.*;

public class n2178 {
    static class point {
        int x;
        int y;
        int dist;

        point(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static int N;
    static int M;
    static char[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main( String[] args ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        boolean[][] vst = new boolean[N][M];

        for(int i=0; i<N; i++)
            map[i] = in.readLine().toCharArray();

        int cnt = Integer.MAX_VALUE;

        Queue<point> q = new LinkedList<>();
        q.offer(new point(0, 0, 1));
        vst[0][0] = true;

        while(!q.isEmpty()){
            point cur = q.poll();

            if(cur.x == N-1 && cur.y == M-1){
                cnt = Math.min(cnt, cur.dist);
            }

            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(vst[nx][ny] || map[nx][ny] == '0') continue;
                vst[nx][ny] = true;
                q.offer(new point(nx, ny, cur.dist + 1));
            }
        }

        out.write(cnt+"");
        out.flush();
        in.close();
        out.close();
    }
}
