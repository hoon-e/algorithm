package BOJ.DFS_BFS;

import java.awt.*;
import java.io.*;
import java.util.*;

public class N11967 {
    static class coord {
        int x;
        int y;
        ArrayList<Point> linked;

        coord(int x, int y) {
            this.x = x;
            this.y = y;
            linked = new ArrayList<>();
        }

        void link(int nx, int ny) {
            linked.add(new Point(nx, ny));
        }
    }

    static boolean[][] vst;
    static boolean[][] light;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int[][] make;
    static int N;
    static int M;
    static ArrayList<coord> coords;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x, y, nx, ny;
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        make = new int[N+1][N+1];
        vst = new boolean[N+1][N+1];
        light = new boolean[N+1][N+1];

        for(int i=1; i<=N; i++)
            Arrays.fill(make[i], Integer.MIN_VALUE);

        coords = new ArrayList<>();

        int idx = 0;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            nx = Integer.parseInt(st.nextToken());
            ny = Integer.parseInt(st.nextToken());

            if(make[x][y] == Integer.MIN_VALUE){
                make[x][y] = idx;
                coords.add(new coord(x,y));
                coords.get(idx).link(nx, ny);
                idx++;
            }else{
                coords.get(make[x][y]).link(nx, ny);
            }
        }

        int count = 1;

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(1,1));
        light[1][1] = true;
        vst[1][1] = true;

        while(!q.isEmpty()){
            Point cur = q.poll();

            if(make[cur.x][cur.y] != Integer.MIN_VALUE){
                for(int p=0; p < coords.get(make[cur.x][cur.y]).linked.size(); p++){
                    Point next = coords.get(make[cur.x][cur.y]).linked.get(p);
                    if(light[next.x][next.y]) continue;
                    light[next.x][next.y] = true;
                    count++;
                }
            }

            for(int k=0; k<4; k++){
                int newx = cur.x + dx[k];
                int newy = cur.y + dy[k];

                if(newx < 1 || newx > N || newy < 1 || newy > N) continue;
                if(!light[newx][newy]) continue;
                if(vst[newx][newy]) continue;
                vst[newx][newy] = true;
                q.offer(new Point(newx, newy));
            }
        }

        bw.write(count+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
