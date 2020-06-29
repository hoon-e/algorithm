package RE.bfs;

import java.awt.*;
import java.io.*;
import java.util.*;

public class n10026 {
    static int N;
    static char[][] area;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main( String[] args ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(in.readLine());
        area = new char[N][N];

        for(int i=0; i<N; i++)
            area[i] = in.readLine().toCharArray();

        out.write(notBlind() + " " + Blind());
        out.flush();
        in.close();
        out.close();
    }

    static int notBlind(){
        Queue<Point> que = new LinkedList<>();
        boolean[][] vst = new boolean[N][N];
        int cnt = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(vst[i][j]) continue;

                vst[i][j] = true;
                que.offer(new Point(i, j));
                ++cnt;

                while(!que.isEmpty()){
                    Point cur = que.poll();

                    for(int k=0; k<4; k++){
                        int nx = cur.x + dx[k];
                        int ny = cur.y + dy[k];

                        if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                        if(area[cur.x][cur.y] != area[nx][ny]) continue;
                        if(vst[nx][ny]) continue;

                        vst[nx][ny] = true;
                        que.offer(new Point(nx, ny));
                    }
                }
            }
        }

        return cnt;
    }

    static int Blind(){
        Map<Character, Integer> type = new HashMap<>();
        type.put('R', 1);
        type.put('G', 1);
        type.put('B', 2);

        Queue<Point> que = new LinkedList<>();
        boolean[][] vst = new boolean[N][N];
        int cnt = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(vst[i][j]) continue;

                vst[i][j] = true;
                que.offer(new Point(i, j));

                ++cnt;

                while(!que.isEmpty()){
                    Point cur = que.poll();
                    int curType = type.get(area[cur.x][cur.y]);

                    for(int k=0; k<4; k++){
                        int nx = cur.x + dx[k];
                        int ny = cur.y + dy[k];

                        if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                        int newType = type.get(area[nx][ny]);

                        if(curType != newType) continue;
                        if(vst[nx][ny]) continue;

                        vst[nx][ny] = true;
                        que.offer(new Point(nx, ny));
                    }
                }
            }
        }

        return cnt;
    }
}
