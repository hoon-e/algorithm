package BOJ.DFS_BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1926 {
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
        int[][] pic = new int[501][501];
        boolean[][] checked = new boolean[501][501];
        int maxarea=0;
        int count=0;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int t = 0;
            while(st.hasMoreTokens()){
                pic[i][t++] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(pic[i][j] == 0 || checked[i][j]) continue;
                count++;
                Queue<coords> queue = new LinkedList<>();
                queue.add(new coords(i,j));
                checked[i][j] = true;

                int area = 0;

                while(!queue.isEmpty()){
                    area++;
                    coords cur = queue.poll();
                    // 4방향 시도
                    for(int dir=0; dir<4; dir++){
                        int nx = cur.x + dx[dir];
                        int ny = cur.y + dy[dir];

                        if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                        if(checked[nx][ny] || pic[nx][ny] != 1) continue;
                        checked[nx][ny] = true;
                        queue.add(new coords(nx,ny));
                    }
                }
                maxarea = Math.max(maxarea, area);
            }
        }

        bw.write(count + "\n" + maxarea);
        bw.flush();
        bw.close();
        br.close();
    }
}
