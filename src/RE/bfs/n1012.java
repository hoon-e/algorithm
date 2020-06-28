package RE.bfs;

import java.awt.*;
import java.io.*;
import java.util.*;

public class n1012 {
    static int T;
    static int M;
    static int N;
    static int K;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main( String[] args ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        T = Integer.parseInt(in.readLine());

        while(T-- > 0){
            st = new StringTokenizer(in.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[M][N];

            for(int a=0; a<K; a++){
                st = new StringTokenizer(in.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[x][y] = 1;
            }

            boolean[][] vst = new boolean[M][N];
            int cnt = 0;

            for(int i=0; i<M; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j] == 0 || vst[i][j]) continue;

                    vst[i][j] = true;
                    Queue<Point> bfs = new LinkedList<>();
                    bfs.offer(new Point(i, j));
                    ++cnt;

                    while(!bfs.isEmpty()){
                        Point cur = bfs.poll();

                        for(int k=0; k<4; k++){
                            int nx = cur.x + dx[k];
                            int ny = cur.y + dy[k];

                            if(nx < 0 || nx >= M || ny < 0 || ny >= N ) continue;
                            if(vst[nx][ny] || map[nx][ny] == 0) continue;

                            vst[nx][ny] = true;
                            bfs.offer(new Point(nx, ny));
                        }
                    }
                }
            }
            out.write(cnt + "\n");
        }

        out.flush();
        in.close();
        out.close();
    }
}
