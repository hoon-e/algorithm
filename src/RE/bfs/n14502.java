package RE.bfs;

import java.awt.*;
import java.io.*;
import java.util.*;

public class n14502 {
    static int N;
    static int M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static int[][] tmpMap;
    static boolean[][] vst;
    static int maxArea = -1;
    static LinkedList<Point> que;

    public static void main( String[] args ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        tmpMap = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(in.readLine());

            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        que = new LinkedList<>();

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 2)
                    que.offer(new Point(i, j));
            }
        }

        setWall(0, 0);

        out.write(maxArea+"");
        out.flush();
        in.close();
        out.close();
    }

    static void setWall(int start, int len){
        if(len == 3) {

            for ( int i = 0; i < N; i++ ) {
                for ( int j = 0; j < M; j++ ) {
                    tmpMap[i][j] = map[i][j];
                }
            }

            vst = new boolean[N][M];

            for(Point virus : que){
                spread(virus.x, virus.y);
            }

            maxArea = Math.max(maxArea, countArea());

            return;
        }

        for(int i=start; i<N*M; i++){
            int r = i / M;
            int c = i % M;

            if(map[r][c] == 0){
                map[r][c] = 1;
                setWall(start + 1, len + 1);
                map[r][c] = 0;
            }
        }
    }

    static int countArea(){
        int cnt = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(tmpMap[i][j] == 0) ++cnt;
            }
        }

        return cnt;
    }

    static void spread(int x, int y){
        Queue<Point> virus = new LinkedList<>();

        virus.offer(new Point(x, y));
        vst[x][y] = true;

        while(!virus.isEmpty()){
            Point cur = virus.poll();

            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(vst[nx][ny] || tmpMap[nx][ny] == 1) continue;

                vst[nx][ny] = true;
                tmpMap[nx][ny] = 2;
                virus.offer(new Point(nx, ny));
            }
        }
    }
}
