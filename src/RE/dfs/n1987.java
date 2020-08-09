package RE.dfs;

import java.util.*;
import java.io.*;

public class n1987 {
    static int R, C;
    static char[][] map;
    static boolean[][] chk;
    static int max = -1;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[] alpha = new boolean[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        chk = new boolean[R][C];

        for(int i=0; i<R; i++)
            map[i] = br.readLine().toCharArray();

        findMaxPath(0, 0, 1);

        bw.write(max+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void findMaxPath(int r, int c, int cnt) {
        if(chk[r][c] || alpha[map[r][c]-'A']) return;

        max = (max < cnt) ? cnt : max;

        for(int i=0; i<4; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];

            if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
            alpha[map[r][c]-'A'] = chk[r][c] = true;
            findMaxPath(nr, nc, cnt+1);
            alpha[map[r][c]-'A'] = chk[r][c] = false;
        }
    }
}
