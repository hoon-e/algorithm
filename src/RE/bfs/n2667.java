package RE.bfs;

import java.awt.*;
import java.io.*;
import java.util.*;

public class n2667 {
    static int N;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] map;
    public static void main( String[] args ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(in.readLine());
        map = new char[N][N];

        for(int i=0; i<N; i++)
            map[i] = in.readLine().toCharArray();

        boolean[][] vst = new boolean[N][N];

        Queue<Point> q;
        ArrayList<Integer> ans = new ArrayList<>();
        int dong = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == '0' || vst[i][j]) continue;

                int cnt = 0;

                q = new LinkedList<>();
                q.offer(new Point(i, j));
                vst[i][j] = true;

                ++dong;

                while(!q.isEmpty()){
                    Point cur = q.poll();
                    cnt++;

                    for(int k=0; k<4; k++){
                        int nx = cur.x + dx[k];
                        int ny = cur.y + dy[k];

                        if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                        if(vst[nx][ny] || map[nx][ny] == '0') continue;
                        vst[nx][ny] = true;
                        q.offer(new Point(nx, ny));
                    }
                }
                ans.add(cnt);
            }
        }

        out.write(dong+"\n");
        ans.sort(Comparator.comparingInt(n -> n));

        for(int a : ans)
            out.write(a + "\n");

        out.flush();
        in.close();
        out.close();
    }
}
