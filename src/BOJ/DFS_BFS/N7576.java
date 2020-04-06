package BOJ.DFS_BFS;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N7576 {
    static int[][] tomato;
    static int[][] chk;
    static int N;
    static int M;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class coords {
        int x;
        int y;
        coords(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static boolean check(){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(chk[i][j] == -1 && tomato[i][j] != -1){
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
        tomato = new int[1010][1010];
        chk = new int[1010][1010];
        coords lastIndex = new coords(0,0);
        boolean flag = true;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int j=0;
            while(st.hasMoreTokens()){
                tomato[i][j++] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++)
            Arrays.fill(chk[i], -1);

        for(int i=0; i<N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomato[i][j] == 0){
                    flag = false;
                    break;
                }
            }
        }

        Queue<coords> q = new LinkedList<>();

        if(flag){
            bw.write(0+"\n");
        }else{
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(chk[i][j] >= 0 || tomato[i][j] == 0 || tomato[i][j] == -1)
                        continue;
                    q.add(new coords(i, j));
                    chk[i][j] = 0;
                }
            }

            while(!q.isEmpty()){
                coords cur = q.poll();
                for(int k=0; k<4; k++){
                    int nx = cur.x + dx[k];
                    int ny = cur.y + dy[k];

                    if(nx < 0 || nx >= N || ny < 0 || ny >= M)
                        continue;
                    if(chk[nx][ny] >= 0 || tomato[nx][ny] != 0)
                        continue;
                    if(tomato[nx][ny] == 0)
                        tomato[nx][ny] = 1;
                    chk[nx][ny] = chk[cur.x][cur.y]+1;
                    q.add(new coords(nx, ny));
                    lastIndex.x = nx;
                    lastIndex.y = ny;
                }
            }

            if(check())
                bw.write(-1+"\n");
            else
                bw.write(chk[lastIndex.x][lastIndex.y] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
