package BOJ.backtracking;

import java.awt.*;
import java.io.*;
import java.util.StringTokenizer;

public class N2210 {
    static int[][] map = new int[5][5];
    static boolean[][] vst;
    static boolean[] chk = new boolean[1_000_000];
    static Point[] number = new Point[6];
    static int cnt;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i=0; i<5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<25; i++){
            vst = new boolean[5][5];
            findNumber(new Point(i/5, i%5), 0);
        }

        bw.write(cnt+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void findNumber(Point p, int len){
        if(len == 6){
            StringBuilder sb = new StringBuilder();

            for(int i=0; i<6; i++){
                sb.append(map[number[i].x][number[i].y]);
            }

            if(!chk[Integer.parseInt(sb.toString())]) {
                chk[Integer.parseInt(sb.toString())] = true;
                cnt++;
            }
            return;
        }

        number[len] = p;

        for(int i=0; i<4; i++){
            int nx = p.x + dx[i];
            int ny = p.y + dy[i];

            if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
            findNumber(new Point(nx, ny), len+1);
        }
    }
}
