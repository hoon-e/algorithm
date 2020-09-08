package RE.bfs;

import java.util.*;
import java.io.*;

public class n2638 {
    static int N, M;
    static int[][] map, vst;

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1}; // 4방
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M]; // 맵 정보 입력

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        while(!isRemoved()) {
            ++time;
            vst = new int[N][M];

            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{0, 0});
            vst[0][0] = -1;

            while(!q.isEmpty()){
                int[] cur = q.poll();

                int r = cur[0];
                int c = cur[1];

                for(int d=0; d<4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                    if(map[nr][nc] == 1 || vst[nr][nc] == -1) continue;
                    vst[nr][nc] = -1;
                    q.offer(new int[]{nr, nc});
                }
            } // 공기 퍼짐

            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(map[i][j] != 0) {
                        int cnt = 0;

                        for(int d=0; d<4; d++) {
                            int nr = i + dr[d];
                            int nc = j + dc[d];

                            if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                            if(vst[nr][nc] == 0) continue;
                            ++cnt;
                        }

                        if(cnt >= 2)
                            map[i][j] = 0;
                    }
                }
            } // 치즈 삭제
        }

        System.out.println(time);
    }

    private static boolean isRemoved() {
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] != 0)
                    return false;
            }
        }
        return true;
    }
}
