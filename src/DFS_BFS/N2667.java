package DFS_BFS;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class N2667 {
    static class coord{
        int x;
        int y;

        coord (int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static char[][] hous = new char[30][30];
    static boolean[][] chk = new boolean[30][30];

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        ArrayList<Integer> sq = new ArrayList<>();
        for(int i=0; i<N; i++){
            hous[i] = br.readLine().toCharArray();
        }

        int total = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(chk[i][j] || hous[i][j] == '0') continue;

                chk[i][j] = true;
                total++;

                Queue<coord> q = new LinkedList<>();
                q.offer(new coord(i,j));

                int val = 1;
                while(!q.isEmpty()){
                    coord cur = q.poll();

                    for(int a=0; a<4; a++){
                        int nx = cur.x+dx[a];
                        int ny = cur.y+dy[a];

                        if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                        if(chk[nx][ny] || hous[nx][ny] == '0') continue;

                        chk[nx][ny] = true;
                        q.offer(new coord(nx, ny));
                        val++;
                    }
                }
                sq.add(val);
            }
        }

        Collections.sort(sq);

        bw.write(total+"\n");
        for(int s : sq){
            bw.write(s+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
