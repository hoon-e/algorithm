package DFS_BFS;

import java.io.*;
import java.util.*;

public class N2468 {

    static class coord {
        int x;
        int y;

        coord(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[][] isl;
    static boolean[][] chk;

    static int[] dx = {-1, 0,1,0};
    static int[] dy = {0, 1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        isl = new int[N+2][N+2];

        Set<Integer> h = new HashSet<>();
        int max = 0;

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int j=0;
            while(st.hasMoreTokens()){
                int t = Integer.parseInt(st.nextToken());
                isl[i][j++] = t;
                h.add(t);
            }
        }

        for(int height : h){
            chk = new boolean[N+2][N+2];
            int count = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(chk[i][j] || isl[i][j] < height) continue;

                    chk[i][j] = true;
                    Queue<coord> q = new LinkedList<>();
                    q.offer(new coord(i,j));
                    count++;

                    while(!q.isEmpty()){
                        coord cur = q.poll();

                        for(int k=0; k<4; k++){
                            int nx = cur.x + dx[k];
                            int ny = cur.y + dy[k];

                            if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                            if(chk[nx][ny] || isl[nx][ny] < height ) continue;
                            chk[nx][ny] = true;
                            q.offer(new coord(nx, ny));
                        }
                    }
                }
            }
            max = Math.max(max, count);
        }
        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
