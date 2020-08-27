package RE.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n1987_2 {
	static int R, C;
    static char[][] map;
    static boolean[][] chk;
    static int max = -1;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    
    static boolean[] alpha = new boolean[26];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for(int i=0; i<R; i++)
            map[i] = br.readLine().toCharArray();

        findMaxPath(0, 0, 1);

        System.out.println(max);
    }

    private static void findMaxPath(int r, int c, int cnt) {
        if(max < cnt) max = cnt;
        if(cnt == 26) return;
        
        alpha[map[r][c]-'A'] = true;
        for(int i=0; i<4; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];
            
            if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
            if(alpha[map[nr][nc]-'A']) continue;
            findMaxPath(nr, nc, cnt+1);
        }
        alpha[map[r][c]-'A'] = false;
    }
}
