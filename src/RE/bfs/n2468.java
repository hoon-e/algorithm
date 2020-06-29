package RE.bfs;

import java.awt.*;
import java.io.*;
import java.util.*;

public class n2468 {
    static int N;
    static int[][] area;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main( String[] args ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(in.readLine());
        area = new int[N][N];

        int maxArea = 1;
        int maxHeight = -1;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(in.readLine());
            for(int j=0; j<N; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = max(maxHeight, area[i][j]);
            }
        }

        for(int i=maxHeight-1; i>=1; i--){
            maxArea = max(maxArea, findArea(i));
        }

        out.write(maxArea+"");
        out.flush();
        in.close();
        out.close();
    }

    static int findArea(int height){
        Queue<Point> que = new LinkedList<>();
        boolean[][] vst = new boolean[N][N];

        int cnt = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(area[i][j] <= height || vst[i][j]) continue;

                vst[i][j] = true;
                que.offer(new Point(i, j));
                ++cnt;

                while(!que.isEmpty()){
                    Point cur = que.poll();

                    for(int k=0; k<4; k++){
                        int nx = cur.x + dx[k];
                        int ny = cur.y + dy[k];

                        if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                        if(area[nx][ny] <= height) continue;
                        if(vst[nx][ny]) continue;

                        vst[nx][ny] = true;
                        que.offer(new Point(nx, ny));
                    }
                }
            }
        }
        return cnt;
    }

    static int max(int a, int b){
        return a > b ? a : b;
    }
}
