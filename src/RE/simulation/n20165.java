package RE.simulation;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n20165 {
    static int N, M, R; // 행, 열, 라운드
    static int[][] domino, check;
    static int[] dx = {0, 0, -1, 1}, dy = {1, -1, 0, 0}; // 동 서 남 북
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        Queue<int[]> q = new LinkedList<>();

        int[] atk = new int[2];
        int[] def = new int[2];
        int dir = 0, count = 0;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        domino = new int[N][M];
        check = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                domino[i][j] = check[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<2; j++){
                atk[j] = Integer.parseInt(st.nextToken())-1;
            }

            switch(st.nextToken()) {
                case "E":
                    dir = 0;
                    break;
                case "W":
                    dir = 1;
                    break;
                case "N":
                    dir = 2;
                    break;
                case "S":
                    dir = 3;
                    break;
            }

            st = new StringTokenizer(br.readLine());
            for(int j=0; j<2; j++) {
                def[j] = Integer.parseInt(st.nextToken())-1;
            }

            if(check[atk[0]][atk[1]] != 0) {
                int height = check[atk[0]][atk[1]];
                q.offer(new int[]{atk[0], atk[1], height});
                count++;

                while(!q.isEmpty()) {
                    int[] c = q.poll();
                    int nx = c[0];
                    int ny = c[1];
                    check[nx][ny] = 0;

                    for(int d=0; d<c[2]-1; d++) {
                        nx += dx[dir];
                        ny += dy[dir];

                        if(nx < 0 || nx >= N || ny < 0 || ny >= M) break;
                        if(check[nx][ny] != 0) {
                            count++;
                            q.offer(new int[]{nx, ny, check[nx][ny]});
                            check[nx][ny] = 0;
                        }
                    }
                }
            }

            // 세우기
            if(check[def[0]][def[1]] == 0) {
                check[def[0]][def[1]] = domino[def[0]][def[1]];
            }
        }

        sb.append(count).append("\n");
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(check[i][j] != 0)
                    sb.append("S ");
                else
                    sb.append("F ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}

