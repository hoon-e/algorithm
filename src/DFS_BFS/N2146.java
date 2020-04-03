package DFS_BFS;

import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N2146 {
    static int[][] isl;
    static int[][] isl_num;
    static boolean[][] chk;
    static boolean[][] shore_chk;
    static int[][] bridge_cnt;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N;
    static int isln = 0;
    static int count = Integer.MAX_VALUE;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        isl = new int[N+1][N+1];
        isl_num = new int[N+1][N+1];
        chk = new boolean[N+1][N+1];
        shore_chk = new boolean[N+1][N+1];
        bridge_cnt = new int[N+1][N+1];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int j=0;
            while(st.hasMoreTokens()){
                isl[i][j++] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(chk[i][j] || isl[i][j] == 0) continue;

                chk[i][j] = true;
                isln++;
                isl_num[i][j] = isln;
                bfs(new Point(i, j));
            }
        }

        if(isln == 1){
            count = 0;
        }
        else{
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!shore_chk[i][j]) continue;
                    chk = new boolean[N+1][N+1];
                    bridge_cnt[i][j] = 0;
                    n = isl_num[i][j];
                    bridge(new Point(i,j));
                }
            }
        }
        bw.write(count+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs(Point p){
        Queue<Point> que = new LinkedList<>();
        que.offer(p);
        chk[p.x][p.y] = true;

        while(!que.isEmpty()){
            Point cur = que.poll();

            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(chk[nx][ny]) continue;
                if(isl[nx][ny] == 0){
                    shore_chk[cur.x][cur.y] = true;
                    continue;
                }
                chk[nx][ny] = true;
                isl_num[nx][ny] = isln;
                que.offer(new Point(nx, ny));
            }
        }
    }

    // 방문 체크는 큐에 넣을 때 합니다!!! <꼭 중요!!!! ★>
    public static void bridge(Point p){
        Queue<Point> shore = new LinkedList<>();
        shore.offer(p);
        chk[p.x][p.y] = true;

        while(!shore.isEmpty()){
            Point cur = shore.poll();

            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(chk[nx][ny]) continue;
                if(isl[nx][ny] == 1 && shore_chk[nx][ny]){
                    if(isl_num[nx][ny] != n){
                        chk[nx][ny] = true;
                        count = Math.min(count, bridge_cnt[cur.x][cur.y]);
                    }
                    continue;
                }else if(isl[nx][ny] == 1 && !shore_chk[nx][ny]) continue;

                chk[nx][ny] = true;
                bridge_cnt[nx][ny] = bridge_cnt[cur.x][cur.y] + 1;
                shore.offer(new Point(nx, ny));
            }
        }
    }
}
