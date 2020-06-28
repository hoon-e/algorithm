package RE.bfs;

import java.awt.*;
import java.io.*;
import java.util.*;

public class n7576 {
    static int M; // 세로
    static int N; // 가로
    static int[][] box;
    static int[][] day;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main( String[] args ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(in.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M];
        day = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(in.readLine());

            for(int j=0; j<M; j++){
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if(isAll()){
            out.write("0\n");
        }else{
            boolean[][] vst = new boolean[N][M];
            Queue<Point> ripe = new LinkedList<>();

            for(int i=0; i<N; i++) {
                for ( int j = 0; j < M; j++ ) {
                    if ( box[i][j] == 1 ) {
                        ripe.offer(new Point(i, j));
                        day[i][j] = 1;
                        vst[i][j] = true;
                    }else if( box[i][j] == -1 )
                        day[i][j] = -1;
                }
            }

            while(!ripe.isEmpty()){
                Point cur = ripe.poll();

                for(int i=0; i<4; i++){
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                    if(vst[nx][ny] || box[nx][ny] == -1) continue;

                    vst[nx][ny] = true;
                    day[nx][ny] = (day[cur.x][cur.y] + 1);
                    ripe.offer(new Point(nx, ny));
                }
            }

            int ans = findDay();
            out.write(ans+"");
        }

        out.flush();
        in.close();
        out.close();
    }

    static boolean isAll(){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(box[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    static int findDay(){
        int ans  = -1;

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(day[i][j] == -1) continue;
                if(day[i][j] == 0) return -1;
                ans = Math.max(ans, day[i][j]);
            }
        }
        return ans - 1;
    }
}
