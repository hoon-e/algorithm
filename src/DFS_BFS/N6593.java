package DFS_BFS;

import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N6593 {
    static class point {
        int x;
        int y;
        int z;

        point(int z, int x, int y){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    static char[][][] building;
    static int[][][] dist;
    static boolean[][][] chk;
    static int[] dx = {0,0,0,-1,0,1};
    static int[] dy = {0,0,-1,0,1,0};
    static int[] dz = {1,-1,0,0,0,0};
    static int L;
    static int R;
    static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if(L == 0 && R == 0 && C == 0)
                break;

            building = new char[L][R][C];
            dist = new int[L][R][C];
            chk = new boolean[L][R][C];

            for(int i=0; i<L; i++){
                for(int j=0; j<R; j++){
                    building[i][j] = br.readLine().toCharArray();
                }
                br.readLine();
            }

            Queue<point> q = new LinkedList<>();

            // 출발지가 1층에 있다는 조건은 없다.
            for(int i=0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    for (int k = 0; k < C; k++) {
                        if (building[i][j][k] == 'S') {
                            chk[i][j][k] = true;
                            dist[i][j][k] = 0;
                            q.offer(new point(i, j, k));
                            break;
                        }
                    }
                }
            }

            boolean flag = true;
            int count = Integer.MAX_VALUE;

            while(!q.isEmpty()){
                point cur = q.poll();

                if( building[cur.z][cur.x][cur.y] == 'E' ){
                    flag = false;
                    count = Math.min(count, dist[cur.z][cur.x][cur.y]);
                }

                for(int i=0; i<6; i++){
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
                    int nz = cur.z + dz[i];

                    if(nz < 0 || nz >= L || nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                    if(chk[nz][nx][ny] || building[nz][nx][ny] == '#') continue;
                    chk[nz][nx][ny] = true;
                    dist[nz][nx][ny] = dist[cur.z][cur.x][cur.y]+1;
                    q.offer(new point(nz, nx, ny));
                }
            }

            if(flag)
                bw.write("Trapped!\n");
            else
                bw.write("Escaped in " + count + " minute(s).\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
