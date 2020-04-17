package BOJ.DFS_BFS;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/****
 - 순열 조합을 이용하여 전체적인 3가지의 벽을 세우는 방법
 - i가 0 ~ n*m의 인덱스를 순회할때, ( i/m, i%m ) 의 좌표로 하게되면 전체의
 ****/
public class N14502 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] map;
    static int N;
    static int M;
    static int[][] chk;
    static ArrayList<Point> virus;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        chk = new int[N][M];
        virus = new ArrayList<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 2) {
                    virus.add(new Point(i, j));
                }
            }
        }


        bw.write(BFS()+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int BFS(){
        while(!q.isEmpty()){
            coord cur = q.poll();

            if(cur.x == N-1 && cur.y == M-1)
                return cur.dist;

            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || nx > N || ny < 0 || ny > M) continue;
                if(cur.wall >= 3) continue;
                if(map[nx][ny] == 0){
                    chk[nx][ny] = cur.wall;
                    q.offer(new coord(nx, ny, cur.wall, cur.dist+1));
                }else{
                    chk[nx][ny] = cur.wall + 1;
                    q.offer(new coord(nx, ny, cur.wall+1, cur.dist+1));
                }
            }
        }

        return -1;
    }
}
