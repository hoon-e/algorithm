package BOJ.DFS_BFS;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N7569 {
    static int[][][] tomato;
    static int[][][] chk;
    static int N;
    static int M;
    static int H;

    // 위, 아래, 좌, 우. 상, 하
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 0, 0, -1, 1};
    static int[] dz = {0, 0, -1, 1, 0, 0};

    static class coords {
        int x;
        int y;
        int z;
        coords(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static boolean check(){
        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++)
                    if(chk[i][j][k] == -1 && tomato[i][j][k] != -1){
                        return true;
                    }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        tomato = new int[110][110][110];
        chk = new int[110][110][110];
        int[][] temp = new int[N][M];
        coords lastIndex = new coords(0,0, 0);
        boolean flag = true;

        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                st = new StringTokenizer(br.readLine());
                int k =0;
                while(st.hasMoreTokens()){
                    tomato[i][j][k++] = Integer.parseInt(st.nextToken());
                }
            }
        }

        for(int i=0; i<H; i++)
            for(int j=0; j<N; j++){
                Arrays.fill(chk[i][j], -1);
            }

        for(int i=0; i<H; i++) {
            for (int j = 0; j < N; j++) {
                for(int k=0; k < M; k++){
                    if (tomato[i][j][k] == 0){
                        flag = false;
                        break;
                    }
                }
            }
        }

        Queue<coords> q = new LinkedList<>();

        if(flag){
            bw.write(0+"\n");
        }else{
            for(int i=0; i<H; i++){
                for(int j=0; j<N; j++){
                    for(int k=0; k<M; k++){
                        if(chk[i][j][k] >= 0 || tomato[i][j][k] == 0 || tomato[i][j][k] == -1)
                            continue;
                        q.add(new coords(i, j, k));
                        chk[i][j][k] = 0;
                    }
                }
            }

            while(!q.isEmpty()){
                coords cur = q.poll();
                for(int k=0; k<6; k++){
                    int nx = cur.x + dx[k];
                    int ny = cur.y + dy[k];
                    int nz = cur.z + dz[k];

                    if(nx < 0 || nx >= H || ny < 0 || ny >= N || nz < 0 || nz >= M)
                        continue;
                    if(chk[nx][ny][nz] >= 0 || tomato[nx][ny][nz] != 0)
                        continue;
                    if(tomato[nx][ny][nz] == 0)
                        tomato[nx][ny][nz] = 1;
                    chk[nx][ny][nz] = chk[cur.x][cur.y][cur.z]+1;
                    q.add(new coords(nx, ny,nz));
                    lastIndex.x = nx;
                    lastIndex.y = ny;
                    lastIndex.z = nz;
                }
            }

            if(check())
                bw.write(-1+"\n");
            else
                bw.write(chk[lastIndex.x][lastIndex.y][lastIndex.z] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
