package BOJ.DFS_BFS;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/****
 - 순열 조합을 이용하여 전체적인 3가지의 벽을 세우는 방법(백트래킹의 방식으로)
 - 조합의 방식 공부할 필요 있음.
 - i가 0 ~ n*m의 인덱스를 순회할때, ( i/m, i%m ) 의 좌표로 하게되면 전체의 모든 인덱스를 순회가능하다.
 ****/

public class N14502 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] lab;
    static int[][] temp_lab;
    static int N;
    static int M;
    static boolean[][] chk;
    static ArrayList<Point> virus;
    static int max;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lab = new int[N][M];
        temp_lab = new int[N][M];
        virus = new ArrayList<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                lab[i][j] = Integer.parseInt(st.nextToken());

                if(lab[i][j] == 2) {
                    virus.add(new Point(i, j));
                }
            }
        }

        setWall(0, 0);
        bw.write(max+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void setWall(int start, int len){
        if( len == 3 ){
            copyLab();
            
            // 초기값 설정
            cnt = 0;
            chk = new boolean[N][M];
            
            // 바이러스 퍼트리기
            for(Point p : virus){
                spread(p.x, p.y);
            }

            max = Math.max(max, findSafe());
            return;
        }

        for(int i=start; i<N*M; i++){
            int nx = i / M;
            int ny = i % M;

            if(lab[nx][ny] == 0){
                lab[nx][ny] = 1;
                setWall(i+1, len+1);
                lab[nx][ny] = 0;
            }
        }
    }

    static int findSafe(){
        int cnt=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(temp_lab[i][j] == 0)
                    cnt++;
            }
        }
        return cnt;
    }

    static void copyLab(){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++) {
                temp_lab[i][j] = lab[i][j];
            }
        }
    }

    static void spread(int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        chk[x][y] = true;

        while(!q.isEmpty()){
            Point cur = q.poll();

            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M ) continue;
                if(lab[nx][ny] == 1 || chk[nx][ny]) continue;
                temp_lab[nx][ny] = 2;
                chk[nx][ny] = true;
                q.offer(new Point(nx, ny));
            }
        }
    }
}

// 참조 블로그 : https://bcp0109.tistory.com/25
