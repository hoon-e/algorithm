package DFS_BFS;

import javax.print.attribute.standard.SheetCollate;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N2573 {
    static class coord {
        int x;
        int y;

        coord(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static int M;
    static int[][] mount;
    static boolean[][] chk;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        mount = new int[N+1][M+1];
        int time = 0;
        boolean flag = false;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int j=0;
            while(st.hasMoreTokens()){
                mount[i][j++] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            chk = new boolean[N + 1][M + 1];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (mount[i][j] == 0 || chk[i][j]) continue;
                    chk[i][j] = true;
                    melt(new coord(i, j));
                }
            }

            time++;
            if(Check() >= 2){
                break;
            }else{
                if(isZero()) {
                    flag = true;
                    break;
                }
            }
        }

        if(flag)
            bw.write(0+"\n");
        else
            bw.write(time+"");
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean isZero() {
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++) {
                if (mount[i][j] != 0)
                    return false;
            }
        }
        return true;
    }

    static int Check(){
        chk = new boolean[N + 1][M + 1];
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (mount[i][j] == 0 || chk[i][j]) continue;
                chk[i][j] = true;
                cnt++;
                Queue<coord> q = new LinkedList<>();

                q.offer(new coord(i, j));
                while(!q.isEmpty()){
                    coord cur = q.poll();

                    for(int k=0; k<4; k++){
                        int nx = cur.x + dx[k];
                        int ny = cur.y + dy[k];

                        if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                        if(mount[nx][ny] == 0 || chk[nx][ny]) continue;
                        chk[nx][ny] = true;
                        q.offer(new coord(nx, ny));
                    }
                }
            }
        }
        return cnt;
    }

    static void melt(coord pos){
        Queue<coord> q = new LinkedList<>();

        q.offer(pos);

        while(!q.isEmpty()){
            coord cur = q.poll();
            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(chk[nx][ny]) continue;
                if(mount[nx][ny] == 0){
                    if(mount[cur.x][cur.y] != 0)
                        mount[cur.x][cur.y] -= 1;
                    continue;
                }

                chk[nx][ny] = true;
                q.offer(new coord(nx, ny));
            }
        }
    }
}
