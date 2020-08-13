package SWEA.D4;

import java.util.*;
import java.io.*;

public class micro {
    static int N, M, K;
    static ArrayList<int[]> micro;
    static int[][] map, dir, sum, tim;
    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            dir = new int[N][N];
            sum = new int[N][N];
            tim = new int[N][N];
            micro = new ArrayList<>();
            // 셀의 개수 N, 격리 시간 M, 미생물 군집수 K

            // 세로위치, 가로위치, 미생물 수, 이동방향 순
            for(int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine());
                int[] temp = new int[6];
                for(int j=0; j<4; j++) {
                    temp[j] = Integer.parseInt(st.nextToken());
                }
                map[temp[0]][temp[1]] = temp[2];
                dir[temp[0]][temp[1]] = temp[3]; // 맵과 방향을 초기화
                micro.add(temp); // 미생물 리스트에 추가
            }

            int time = 0;
            while(time != K) {
                moveMicro();

                for(int i=0; i<N; i++){
                    for(int j=0; j<N; j++)
                        System.out.print(map[i][j] + " ");
                    System.out.println();
                }
                System.out.println();

                tim = new int[N][N];
                sum = new int[N][N];
                ++time; // 시간 증가
            }

            int sum = 0;
            for(int[] m : micro) {
                sum += m[2];
            }

            bw.write(String.format("#%d %d\n", tc, sum));
        }
        bw.flush();
    }

    /*
    정사각형 구역 안에 K개의 미생물 군집이 있다.
    가로 N개, 세로 N개 N*N개의 동일한 크기의 정사각형 셀
    가장 바깥쪽에는 특수 약품이 처리되어있다.
    미생물 군집이 이동 후에 약품이 칠해진 셀에 도착하면 반이 죽고 이동방향이 반대로 바뀐다.
    미생물 수가 홀수인 경우, 2로 나눈후 소수점 이하를 버린 값

    이동 후 두개 이상이 한셀에 모이는 경우 군집들이 합쳐진다.
    합쳐진 군집의 미생물 수는 군집들의 미생물 수의 합이며, 이동방향은 군집들 중 미생물 수가 가장 많은 군집의 이동방향이 된다.
    M시간 동안 미생물을 격리하였다.
     */

    private static void moveMicro() {
        Iterator<int[]> it = micro.iterator();

        // 미생물 이동 시킨다.
        while (it.hasNext()) {
            int[] g = it.next();

            System.out.println(g[0] + " " + g[1]);

            // m[0] m[1] m[2] m[4]
            int nx = g[0] + dx[g[3]];
            int ny = g[1] + dy[g[3]]; // 이동

            ++g[5];

            if (g[4] == 0 && (nx == 0 || nx == N - 1 || ny == 0 || ny == N - 1)) { // 벽에 닿으면
                double half = g[2] / 2.0;
                int remain = (int) Math.floor(half);

                map[g[0]][g[1]] = 0;
                dir[g[0]][g[1]] = 0; // 원래대로 돌린다.

                g[0] = nx;
                g[1] = ny;
                g[2] = remain;
                g[4] = 1;
                tim[nx][ny] = g[5];
                sum[nx][ny] = g[2];

                if (g[3] == 1) g[3] = 2;
                else if (g[3] == 2) g[3] = 1;
                else if (g[3] == 3) g[3] = 4;
                else g[3] = 3; // 방향 전환

            } else { // 벽에 닿은것이 아니라면
                if(tim[nx][ny] == g[5] && map[nx][ny] != 0) { // 누가 방문한 점이라면
                    if(map[nx][ny] < g[2]) { // 방문한 애보다 더 많은 미생물수를 가지고 있다면
                        map[nx][ny] = g[2];
                        dir[nx][ny] = g[3];
                    }
                    map[g[0]][g[1]] = 0;
                    dir[g[0]][g[1]] = 0;

                    sum[nx][ny] += g[2]; // 일단 합쳐놓는다.
                    it.remove(); // 현재 객체 없앤다.
                } else {
                    sum[nx][ny] = g[2];
                    dir[nx][ny] = g[3];

                    map[g[0]][g[1]] = 0;
                    map[g[0]][g[1]] = 0;
                }
                g[4] = 0;
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(sum[i][j] != 0) map[i][j] = sum[i][j];
            }
        }
    }
}
