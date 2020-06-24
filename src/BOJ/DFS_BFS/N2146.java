package BOJ.DFS_BFS;

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
                // 방문한 정점이거나, 0인 경우는 방문하지 않는다.
                if(chk[i][j] || isl[i][j] == 0) continue;

                chk[i][j] = true; // 방문체크
                isln++; // 섬의 개수 증가
                isl_num[i][j] = isln; // 섬의 번호
                bfs(new Point(i, j)); // 해당 섬 BFS로 찾음
            }
        }

        // 섬의 개수가 한개이면 다리를 지을 수 없다.
        if(isln == 1){
            count = 0;
        }
        else{
            // 다리를 갯수를 찾는 함수
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    // 해변가가 아니라면 통과
                    if(!shore_chk[i][j]) continue;

                    // 방문 체크 배열 초기화
                    chk = new boolean[N+1][N+1];

                    // 다리의 갯수를 0으로 초기화
                    bridge_cnt[i][j] = 0;
                    // n을 현재 섬의 번호로 초기화한다.
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

    // BFS로 섬의 범위 찾는 함수
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
                if(chk[nx][ny]) continue; // 방문한 점이면 통과
                if(isl[nx][ny] == 0){ // 만약 0이라면 해변가이다.
                    shore_chk[cur.x][cur.y] = true;
                    continue;
                }

                // 방문해주고 체크하고, 섬 번호 초기화해준다.
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

        // 현재 정점부터 BFS 시작ㄴ
        while(!shore.isEmpty()){
            Point cur = shore.poll();

            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(chk[nx][ny]) continue; // 방문한 점이라면 통과
                // 섬에 존재하고, 해변가라면
                if(isl[nx][ny] == 1 && shore_chk[nx][ny]){
                    // 방문한 점이 다른 섬이라면
                    if(isl_num[nx][ny] != n){
                        chk[nx][ny] = true;
                        // count를 최소 다리의 길이로 초기화해준다.
                        count = Math.min(count, bridge_cnt[cur.x][cur.y]);
                    }
                    continue;
                // 만약 섬인데 해변가가 아니라면 통과한다.
                }else if(isl[nx][ny] == 1 && !shore_chk[nx][ny]) continue;

                // 방문 체크를 해주고
                chk[nx][ny] = true;
                // 다리의 길이를 현재의 길이보다 증가시켜서 저장합니다.
                bridge_cnt[nx][ny] = bridge_cnt[cur.x][cur.y] + 1;
                shore.offer(new Point(nx, ny));
            }
        }
    }
}
