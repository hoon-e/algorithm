package RE.simulation;

import java.io.*;
import java.util.*;

public class n1449 {
    static int N;
    static int M;
    static int[][] map;
    static int x;
    static int y;
    static int K;
    // 동, 서, 북, 남
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public static void main( String[] args ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(in.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(in.readLine());

        while(st.hasMoreTokens()){
            int dir = Integer.parseInt(st.nextToken());

            // 1 : 동, 2 : 서, 3 : 북, 4 : 남

        }

        out.flush();
        in.close();
        out.close();
    }
}
