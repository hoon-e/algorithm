package RE.dfs;

import java.util.*;
import java.io.*;

public class n14502 {
    static int N, M, area=-1;
    static boolean[][] chk;
    static int[][] map;
    static ArrayList<int[]> virus;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        chk = new boolean[N][M];
        virus = new ArrayList<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) virus.add(new int[]{i, j});
            }
        }

        setWall(0, 0);

        bw.write(area+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void setWall(int start, int cnt) {
        if(cnt == 3) {
            int[][] temp = new int[N][M];
            chk = new boolean[N][M];

            for(int i=0; i<N; i++) // map 복사
                System.arraycopy(map[i], 0, temp[i], 0, M);

            Queue<int[]> safe = new LinkedList<>(virus);

            for(int[] v : virus) chk[v[0]][v[1]] = true;

            while(!safe.isEmpty()) {
                int[] cur = safe.poll();

                for(int d=0; d<4; d++) {
                    int nx = cur[0] + dx[d];
                    int ny = cur[1] + dy[d];

                    if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                    if(temp[nx][ny] == 1) continue;
                    if(chk[nx][ny]) continue;

                    temp[nx][ny] = 2;
                    chk[nx][ny] = true;
                    safe.offer(new int[]{nx, ny});
                }
            }

            int count =0;
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++)
                    if(temp[i][j] == 0) ++count;
            }

            area = (area < count) ? count : area;

            return;
        }

        // 0부터 놓기 시작. ~ N*M까지 벽을 세운다.
        for(int i=start; i<N*M; i++) {
            int row = (i / M);
            int col = (i % M);

            if(map[row][col] == 0) {
                map[row][col] = 1;
                setWall(start+1, cnt+1);
                map[row][col] = 0;
            }
        }
    }
}
