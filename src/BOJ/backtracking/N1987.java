package BOJ.backtracking;

import java.awt.*;
import java.io.*;
import java.util.StringTokenizer;

public class N1987 {
    static int R;
    static int C;
    static char[][] alphabet;
    static int max = Integer.MIN_VALUE;
    static boolean[][] vst;
    static boolean[] chk;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        alphabet = new char[R][C];
        chk = new boolean[26];

        for(int i=0; i<R; i++)
            alphabet[i] = br.readLine().toCharArray();

        vst = new boolean[R][C];

        vst[0][0] = true;
        chk[alphabet[0][0]-'A'] = true;
        findLong(1, new Point(0, 0));

        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void findLong(int cnt, Point p){
        boolean flag = true;

        for(int i=0; i<4; i++){
            int nx = p.x + dx[i];
            int ny = p.y + dy[i];

            if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
            if(vst[nx][ny] || chk[alphabet[nx][ny] - 'A']) continue;
            flag = false;
            chk[alphabet[nx][ny] - 'A'] = true;
            findLong(cnt + 1, new Point(nx, ny));
            chk[alphabet[nx][ny] - 'A'] = false;
        }

        if(flag){
            max = Math.max(max, cnt);
        }
    }
}
