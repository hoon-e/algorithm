package RE.simulation;

import java.util.*;
import java.io.*;

public class n2567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[101][101];
        int len = 0;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());

            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            for(int j=r; j<r+10; j++){
                for(int k=c; k<c+10; k++)
                    map[j][k] = 1;
            }
        }

        for(int i=100; i>=0; i--){
            for(int j=0; j<=100; j++){
                if(map[i][j] == 0) continue;
                int m = 0;
                for(int d=0; d<4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];

                    if(map[nx][ny] == 1) ++m;
                }

                if(m == 2) len += 2;
                else if(m == 3) len += 1;
            }
        }

        System.out.println(len);
    }
}
