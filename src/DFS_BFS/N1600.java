package DFS_BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class point {
    int x;
    int y;
    int jumpCount;
    int dist;

    point(int x, int y, int jumpCount, int dist){
        this.x = x;
        this.y = y;
        this.jumpCount = jumpCount;
        this.dist = dist;
    }
}

public class N1600 {
    static int W;
    static int H;
    static int K;
    static int[][] field = new int[201][201];
    // 삼중으로 해야한다..., 말의 횟수 개 만큼 해준다.
    static boolean[][][] visit;

    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);

        K = scn.nextInt();
        W = scn.nextInt();
        H = scn.nextInt();

        visit = new boolean[201][201][31];

        // map 입력
        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                field[i][j] = scn.nextInt();
            }
        }

        System.out.println(find());
    }

    static int find(){
        int[] jx = {-1, -2, -2, -1, 1, 2, 2, 1};
        // 똑바로 씁시당... 이거
        int[] jy = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        Queue<point> q = new LinkedList<>();
        visit[0][0][0] = true; // 세로, 가로, 말 횟수
        q.offer(new point(0,0,0,0));

        while(!q.isEmpty()){
            point cur = q.poll();

            if( cur.x == H-1 && cur.y == W-1 ){
                return cur.dist;
            }

            // K를 달성하지 못했을 경우에만 넘어가는 것을 체크해준다.
            if( cur.jumpCount < K ){
                for(int i=0; i<8; i++){
                    int nx = cur.x + jx[i];
                    int ny = cur.y + jy[i];

                    if(nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
                    if(visit[nx][ny][cur.jumpCount+1] || field[nx][ny] == 1) continue;

                    visit[nx][ny][cur.jumpCount+1] = true;
                    q.offer(new point(nx, ny, cur.jumpCount+1, cur.dist+1));
                }
            }

            if( cur.jumpCount <= K) {
                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if (nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
                    if (visit[nx][ny][cur.jumpCount] || field[nx][ny] == 1) continue;

                    visit[nx][ny][cur.jumpCount] = true;
                    q.offer(new point(nx, ny, cur.jumpCount, cur.dist + 1));
                }
            }
        }

        return -1;
    }
}