package BOJ.DFS_BFS;

import java.awt.*;
import java.util.*;

public class N11967 {
    static boolean[][] vst;
    static boolean[][] light;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int[][] make;
    static int N;
    static int M;
    static ArrayList<Point>[][] d;
    static int count = 1;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int x, y, nx, ny;

        N = scn.nextInt();
        M = scn.nextInt();

        make = new int[N+1][N+1];
        light = new boolean[N+1][N+1];

        for(int i=1; i<=N; i++)
            Arrays.fill(make[i], Integer.MIN_VALUE);

        d = new ArrayList[N+1][N+1];

        for(int i=1; i<=N; i++)
            for(int j=1; j<=N; j++)
                d[i][j] = new ArrayList<>();

        for(int i=0; i<M; i++){
            x = scn.nextInt();
            y = scn.nextInt();
            nx = scn.nextInt();
            ny = scn.nextInt();

            d[x][y].add(new Point(nx, ny));
        }

        vst = new boolean[N+1][N+1];

        while(true){
            if(!findRoom())
                break;
        }

        System.out.println(count);
        scn.close();
    }

    static boolean findRoom(){
        boolean flag = false;

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                // i=1, j=1이 아니고, 불이 켜져있지 않으면 넘김
                if(!(i == 1 && j == 1) && !light[i][j]) continue;
                // 방문한 지점이면 넘김
                if(vst[i][j]) continue;

                Queue<Point> q = new LinkedList<>();
                q.offer(new Point(i,j));
                vst[i][j] = true;

                while(!q.isEmpty()){
                    Point cur = q.poll();
                    System.out.print(cur.x + " " + cur.y + " =>  ");
                    // 연결되어있는 스위치가 있어야 스위치를 켬
                    if(!d[cur.x][cur.y].isEmpty()){
                        for(int p=0; p < d[cur.x][cur.y].size(); p++){
                            Point next = d[cur.x][cur.y].get(p);
                            if(light[next.x][next.y]) continue;
                            System.out.print(next.x + " " + next.y + " / ");
                            light[next.x][next.y] = true;
                            count++;
                            flag = true;
                        }
                    }

                    System.out.println();

                    for(int k=0; k<4; k++){
                        int newx = cur.x + dx[k];
                        int newy = cur.y + dy[k];

                        if(newx < 1 || newx > N || newy < 1 || newy > N) continue;
                        if(vst[newx][newy]) continue;
                        if(!light[newx][newy]) continue;
                        System.out.print(" " + newx + " " + newy + " / ");
                        vst[newx][newy] = true;
                        q.offer(new Point(newx, newy));
                    }
                    System.out.println();
                }
            }
        }
        return flag;
    }
}
