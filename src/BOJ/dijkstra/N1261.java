package BOJ.dijkstra;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class newPoint implements Comparable<newPoint>{
    int x;
    int y;
    int brk;

    newPoint(int x, int y, int brk){
        this.x = x;
        this.y = y;
        this.brk = brk;
    }

    @Override
    public int compareTo(newPoint o) {
        return brk - o.brk;
    }
}

public class N1261 {
    static int N;
    static int M;
    static char[][] maze;
    static int[][] dist;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static final int INF = 10000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new char[M+1][N+1];
        dist = new int[M+1][N+1];

        for(int i=0; i<=M; i++)
            Arrays.fill(dist[i], INF);

        for(int i=1; i<=M; i++){
            String line = br.readLine();
            for(int j=0; j<N; j++)
                maze[i][j+1] = line.charAt(j);
        }

        bw.write(findMin()+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int findMin(){
        PriorityQueue<newPoint> pq = new PriorityQueue<>();

        dist[1][1] = 0;
        pq.offer(new newPoint(1,1,dist[1][1]));

        for(int i=0; i<4; i++){
            int nx = 1 + dx[i];
            int ny = 1 + dy[i];

            if(nx < 1 || nx > M || ny < 1 || ny > N) continue;
            if(maze[nx][ny] == '1') {
                if(dist[1][1] + 1 < dist[nx][ny]) {
                    dist[nx][ny] = (dist[1][1] + 1);
                }
            }else {
                if(dist[nx][ny] > dist[1][1]) {
                    dist[nx][ny] = dist[1][1];
                }
            }

            pq.offer(new newPoint(nx, ny, dist[nx][ny]));
        }

        while(!pq.isEmpty()){
            newPoint cur = pq.poll();

            int curX = cur.x;
            int curY = cur.y;
            int curBreak = cur.brk;

            if(curBreak != dist[curX][curY]) continue;
            for(int i=0; i<4; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if(nx < 1 || nx > M || ny < 1 || ny > N) continue;
                if(maze[nx][ny] == '1') {
                    if(curBreak + 1 < dist[nx][ny]) {
                        dist[nx][ny] = (curBreak + 1);
                        pq.offer(new newPoint(nx, ny, dist[nx][ny]));
                    }
                }else {
                    if(dist[nx][ny] > dist[curX][curY]) {
                        dist[nx][ny] = dist[curX][curY];
                        pq.offer(new newPoint(nx, ny, dist[nx][ny]));
                    }
                }
            }
        }
        return dist[M][N];
    }
}
