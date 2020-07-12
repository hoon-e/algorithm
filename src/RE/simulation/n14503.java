package RE.simulation;

import java.io.*;
import java.util.*;

public class n14503 {
    static int N;
    static int M;
    static char[][] map;
    static boolean[][] cleaned;
    // 북, 동, 남, 서
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[] direction = {'↑', '→', '↓', '←'};
    static int r;
    static int c;
    static int dir;
    public static void main( String[] args ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        cleaned = new boolean[N][M];

        st = new StringTokenizer(in.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(in.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        cleaned[r][c] = true;
        int clean = 1;
        int rotate = 0;

        while(true) {
            // 왼쪽으로 회전하고, 회전한 후의 청소 구역을 표현
            int tempDir = (dir - 1 < 0) ? 3 : dir - 1;

            // 네 방향이 모두 청소가 되어있거나, 벽이라면
            if( rotate == 4 ){
                if( map[r - dx[dir]][c - dy[dir]] == '1' ) break;
                else {
                    r -= dx[dir];
                    c -= dy[dir];
                    rotate = 0;
                    continue;
                }
            }

            int nx = r + dx[tempDir];
            int ny = c + dy[tempDir];

            // 만약 청소가 되어있거나, 벽이라면
            if(map[nx][ny] == '1' || cleaned[nx][ny]) {
                dir = tempDir; // 방향 전환
                ++rotate;
                continue;
            }

            cleaned[nx][ny] = true;
            dir = tempDir;

            r = nx;
            c = ny;
            rotate = 0; // 회전 수 초기화
            ++clean;
        }

        out.write(clean+"");
        out.flush();
        in.close();
        out.close();
    }
}