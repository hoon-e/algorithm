package BOJ.dijkstra;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N4485 {
    static class Edge implements Comparable<Edge> {
        int x;
        int y;
        int rupee;

        Edge(int x, int y, int rupee){
            this.x = x;
            this.y = y;
            this.rupee = rupee;
        }

        public int compareTo(Edge e){
            return rupee - e.rupee;
        }
    }

    static int N;
    static int[][] cave;
    static int[][] sum;
    static ArrayList<Edge>[] nodes;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static final int INF = 2000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int test = 0;

        while(true){
            test++;
            N = Integer.parseInt(br.readLine());
            if(N == 0)
                break;

            nodes = new ArrayList[N+1];
            cave = new int[N+1][N+1];

            for(int i=0; i<=N; i++)
                nodes[i] = new ArrayList<>();

            for(int i=1; i<=N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=1; j<=N; j++){
                    cave[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            bw.write("Problem " + test + ": " + dijkstra4485() + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int dijkstra4485(){
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        sum = new int[N+1][N+1];

        for(int i=1; i<=N; i++)
            Arrays.fill(sum[i], INF);

        sum[1][1] = cave[1][1];
        pq.offer(new Edge(1,1, sum[1][1]));
        for(int i=0; i<4; i++){
            int nx = 1 + dx[i];
            int ny = 1 + dy[i];

            if(nx < 1 || nx > N || ny < 1 || ny > N) continue;
            if( sum[nx][ny] > sum[1][1] + cave[nx][ny] ){
                sum[nx][ny] = sum[1][1] + cave[nx][ny];
                pq.offer(new Edge(nx, ny, sum[nx][ny]));
            }
        }

        while(!pq.isEmpty()){
            Edge cur = pq.poll();

            if(sum[cur.x][cur.y] != cur.rupee) continue;
            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 1 || nx > N || ny < 1 || ny > N) continue;
                if( sum[nx][ny] > cur.rupee + cave[nx][ny] ){
                    sum[nx][ny] = cur.rupee + cave[nx][ny];
                    pq.offer(new Edge(nx, ny, sum[nx][ny]));
                }
            }
        }

        return sum[N][N];
    }
}
