package backtracking;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class N11559 {
    static class coord {
        int x;
        int y;

        coord(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static char[][] puyo = new char[12][6];
    static boolean[][] chk = new boolean[12][6];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] h;
    static int[] c;
    static int score;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i=0; i<12; i++){
            puyo[i] = br.readLine().toCharArray();
        }

        for(int i=11; i>=0; i--){
            for(int j=0; j<6; j++){
                if(chk[i][j] || puyo[i][j] == '.') continue;

                Stack<coord> s = new Stack<>();
                h = new int[6];
                c = new int[6];
                char now = puyo[i][j];
                chk[i][j] = true;

                Queue<coord> q = new LinkedList<>();
                q.offer(new coord(i,j));
                s.add(new coord(i,j));

                int count = 1;
                while(!q.isEmpty()){
                    coord cur = q.poll();

                    for(int k=0; k<4; k++){
                        int nx = cur.x + dx[k];
                        int ny = cur.y + dy[k];

                        if(nx < 0 || nx >= 12 || ny < 0 || ny >= 6) continue;
                        if(puyo[nx][ny] != 'x' && puyo[nx][ny] != now || chk[nx][ny]) continue;
                        chk[nx][ny] = true;
                        count++;
                        q.offer(new coord(nx, ny));
                        s.add(new coord(i,j));
                    }
                }

                if(count >= 4){
                    score++;

                    while(!s.isEmpty()){
                        coord cur = s.pop();
                        chk[cur.x][cur.y] = false;
                        h[cur.y]++;
                        if( cur.x > c[cur.y] )
                            c[cur.y] = cur.x;
                    }

                    for(int g=0; g<6; g++){
                       if(h[g] == 0) continue;

                       for(int )
                    }
                }
            }
        }
    }
}
