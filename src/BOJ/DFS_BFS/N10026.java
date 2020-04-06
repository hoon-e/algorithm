package BOJ.DFS_BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class N10026 {
    static class coord {
        int x;
        int y;

        coord(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static char[][] tile = new char[102][102];
    static boolean[][] chk;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            tile[i] = br.readLine().toCharArray();
        }

        bw.write(notGR() + " " + yesGR());
        bw.flush();
        bw.close();
        br.close();
    }

    static int yesGR(){
        int result = 0;
        chk = new boolean[102][102];
        char[] not = new char[2];

        for(int i=0; i<num; i++){
            for(int j=0; j<num; j++){
                if(chk[i][j]) continue;
                char t = tile[i][j];

                if(t == 'R' || t == 'G'){
                    not[0] = 'B';
                    not[1] = 'B';
                }
                else if( t == 'B'){
                    not[0] = 'R';
                    not[1] = 'G';
                }

                Queue<coord> q = new LinkedList<>();
                chk[i][j] = true;
                result++;

                q.offer(new coord(i, j));

                while(!q.isEmpty()){
                    coord cur = q.poll();

                    for(int k=0; k<4; k++){
                        int nx = cur.x + dx[k];
                        int ny = cur.y + dy[k];

                        if(nx < 0 || nx >= num || ny < 0 || ny >= num) continue;
                        if(chk[nx][ny] || tile[nx][ny] == not[0] ||  tile[nx][ny] == not[1]) continue;
                        chk[nx][ny] = true;
                        q.offer(new coord(nx, ny));
                    }
                }
            }
        }
        return result;
    }

    static int notGR(){
        int result = 0;
        chk = new boolean[102][102];
        char[] not = new char[2];

        for(int i=0; i<num; i++){
            for(int j=0; j<num; j++) {
                char t = tile[i][j];
                if (chk[i][j]) continue;
                result++;

                if (t == 'R') {
                    not[0] = 'G';
                    not[1] = 'B';
                } else if(t == 'G'){
                    not[0] = 'R';
                    not[1] = 'B';
                } else{
                    not[0] = 'R';
                    not[1] = 'G';
                }

                Queue<coord> q = new LinkedList<>();
                chk[i][j] = true;

                q.offer(new coord(i, j));

                while (!q.isEmpty()) {
                    coord cur = q.poll();

                    for (int k = 0; k < 4; k++) {
                        int nx = cur.x + dx[k];
                        int ny = cur.y + dy[k];

                        if (nx < 0 || nx >= num || ny < 0 || ny >= num) continue;
                        if (chk[nx][ny] || tile[nx][ny] == not[0] || tile[nx][ny] == not[1]) continue;
                        chk[nx][ny] = true;
                        q.offer(new coord(nx, ny));
                    }
                }
            }
        }
        return result;
    }
}
