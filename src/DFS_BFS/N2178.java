package DFS_BFS;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N2178 {
    static class coords {
        int x;
        int y;

        coords(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    // 상하좌우
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] maze = new char[101][101];
        int[][] dist = new int[101][101];

        for(int i=0; i<n; i++){
            maze[i] = br.readLine().toCharArray();
        }

        for(int i=0; i<n; i++)
            Arrays.fill(dist[i], -1);

        Queue<coords> queue = new LinkedList<>();
        queue.add(new coords(0,0));
        dist[0][0] = 0;

        while(!queue.isEmpty()){
            coords cur = queue.poll();
            for(int dir=0; dir<4; dir++){
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(dist[nx][ny] >= 0 || maze[nx][ny] != '1') continue;
                dist[nx][ny] = dist[cur.x][cur.y]+1;
                queue.add(new coords(nx, ny));
            }
        }
        bw.write((dist[n-1][m-1]+1)+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
