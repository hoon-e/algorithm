package BOJ.DFS_BFS;

import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class swan {
    int x;
    int y;
    int dist;
    int num;

    swan(int x, int y, int dist, int num){
        this.x = x;
        this.y = y;
        this.dist = dist;
        this.num = num;
    }
}

public class N3197 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static char[][] lake;
    static boolean[][] vst;
    static int R;
    static int C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        lake = new char[R][C];

        for(int i=0; i<R; i++)
            lake[i] = br.readLine().toCharArray();

        melt();

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                System.out.print(lake[i][j] + " ");
            }
            System.out.println();
        }
//        while(true){
//
//            melt();
//            movingSwan();
//
//        }
    }

    static void melt(){
        vst = new boolean[R][C];
        Queue<Point> q = new LinkedList<>();;

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(vst[i][j] || lake[i][j] == '.' || lake[i][j] == 'L') continue;

                vst[i][j] = true;
                q.offer(new Point(i,j));

                while(!q.isEmpty()){
                    Point cur = q.poll();

                    for(int k=0; k<4; k++){
                        int nx = cur.x + dx[k];
                        int ny = cur.y + dy[k];

                        if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                        if(vst[nx][ny] || lake[nx][ny] == 'X' || lake[nx][ny] == 'L') continue;

                        vst[nx][ny] = true;
                        lake[cur.x][cur.y] = '.';
                        q.offer(new Point(nx, ny));
                    }
                }
            }
        }
    }

//    static void movingSwan(){
//        int n = 1;
//        for(int i=0; i<R; i++){
//            for(int j=0; j<C; j++){
//                if(lake[i][j] == 'L') {
//                    q.offer(new swan(i, j, 0, n++));
//                }
//            }
//        }
//    }
}
