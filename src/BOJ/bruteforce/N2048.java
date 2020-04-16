package BOJ.bruteforce;

import java.io.*;
import java.util.StringTokenizer;

public class N2048 {
    static class coord {
        int x;
        int y;
        boolean chk;

        coord(){};
        coord(int x, int y, boolean chk){
            this.x = x;
            this.y = y;
            this.chk = chk;
        }
        coord(coord c, boolean chk){
            this.x = c.x;
            this.y = c.y;
            this.chk = chk;
        }
    }

    static int N;
    static int[][] tile;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        tile = new int[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                tile[i][j] = Integer.parseInt(st.nextToken());
                if(tile[i][j] > max)
                    max = tile[i][j];
            }
        }

        bw.write(max+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
