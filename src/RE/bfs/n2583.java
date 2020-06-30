package RE.bfs;

import java.awt.*;
import java.io.*;
import java.util.*;

public class n2583 {
    static int M;
    static int N;
    static int K;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static ArrayList<Integer> ans;

    public static void main( String[] args ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[M][N];

        for(int i=0; i<K; i++){
            st = new StringTokenizer(in.readLine());

            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());

            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            for(int j=x1; j<x2; j++){
                for(int k=y1; k<y2; k++){
                    map[j][k] = 1;
                }
            }
        }

        boolean[][] vst = new boolean[M][N];
        int cnt = 0;
        int area = 0;
        ans = new ArrayList<>();

        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(vst[i][j] || map[i][j] == 1) continue;

                Queue<Point> q = new LinkedList<>();
                q.offer(new Point(i, j));
                vst[i][j] = true;
                area = 0;
                ++cnt;

                while(!q.isEmpty()){
                    Point cur = q.poll();
                    ++area;

                    for(int k=0; k<4; k++){
                        int nx = cur.x + dx[k];
                        int ny = cur.y + dy[k];

                        if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                        if(vst[nx][ny] || map[nx][ny] == 1) continue;
                        vst[nx][ny] = true;
                        q.offer(new Point(nx, ny));
                    }
                }
                ans.add(area);
            }
        }

        ans.sort(Comparator.comparingInt(n -> n));
        out.write(cnt+"\n");

        for(int a : ans)
            out.write(a+" ");

        out.flush();
        in.close();
        out.close();
    }
}
