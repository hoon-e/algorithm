package DFS_BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1012 {
    static class coords {
        int x;
        int y;
        coords(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static int[][] field;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test = Integer.parseInt(br.readLine());

        for(int i=0; i<test; i++){
            field = new int[52][52];
            visited = new boolean[52][52];
            int worm = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int cabbage = Integer.parseInt(st.nextToken());

            for(int j=0; j<cabbage; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[x][y] = 1;
            }

            for(int a=0; a<n; a++){
                for(int b=0; b<m; b++){
                    if(field[a][b] == 0 || visited[a][b]) continue;
                    worm++;

                    Queue<coords> queue = new LinkedList<>();
                    queue.add(new coords(a,b));
                    visited[a][b] = true;
                    while(!queue.isEmpty()){
                        coords cur = queue.poll();

                        for(int dir=0; dir<4; dir++){
                            int nx = cur.x + dx[dir];
                            int ny = cur.y + dy[dir];

                            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                            if(field[nx][ny] != 1 || visited[nx][ny]) continue;
                            visited[nx][ny] = true;
                            queue.add(new coords(nx, ny));
                        }
                    }
                }
            }
            bw.write(worm + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
