package RE.bfs;

import java.util.*;
import java.io.*;

public class n17142 {
    static int N, M, ans=Integer.MAX_VALUE, vCnt; // N, R, 시간, 바이러스 갯수
    static int[][] map, cpy; // 원래 맵, 복사본

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1}; // 4방향

    static int[][] virus; // 바이러스 위치
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); // 크기 입력받음

        map = new int[N][N]; // 맵
        virus = new int[10][2]; // 바이러스 위치(최대 10개)

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    virus[vCnt][0] = i;
                    virus[vCnt++][1] = j;
                } // 2일 때 바이러스의 위치 넣어줌
            }
        }

        setLab(0, 0);
        System.out.println(ans);
    }

    private static boolean isAll() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++){
                if(cpy[i][j] == 0) return false;
            }
        }
        return true;
    }

    private static void setLab(int start, int cnt) {
        if(cnt == M) {
            cpy = new int[N][N]; // 복사할 맵

            Queue<int[]> q = new LinkedList<>();
            Queue<int[]> nq = new LinkedList<>();

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++) {
                    cpy[i][j] = map[i][j];
                    if(map[i][j] == 3)
                        q.offer(new int[]{i, j}); // 활성된 바이러스 추가
                }
            }

            int time = 0;
            while(!isAll()) {
                if(!nq.isEmpty()) {
                    q.addAll(nq);
                    nq.clear();
                }
                while(!q.isEmpty()) {
                    int[] cur = q.poll();

                    int x = cur[0];
                    int y = cur[1];

                    for(int d=0; d<4; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];

                        if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                        if(cpy[nx][ny] != 0) continue;

                        if(map[nx][ny] == 2) { // 만약 비활성 상태라면
                            cpy[nx][ny] = 1; // 활성 상태로 변경
                            nq.offer(new int[]{nx, ny});
                            continue;
                        }

                        cpy[nx][ny] = 1;
                        nq.offer(new int[]{nx, ny});
                    }
                }
                ++time;
            }

            ans = Math.min(ans, time);
            return;
        }

        for(int i=start; i<vCnt; i++) { // 비활성 바이러스 갯수만큼 반복
            int x = virus[i][0];
            int y = virus[i][1]; // 바이러스 활성 하려고 하는 바이러스

            map[x][y] = 3;
            setLab(i+1, cnt+1);
            map[x][y] = 2; // 다시 원상 복구
        }
    }
}
