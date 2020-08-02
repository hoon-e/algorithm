package RE.simulation;

import java.util.*;
import java.io.*;

// 메소드로 빼는 것이 시간 상으로 더 안좋을 수 있다... 특히 시뮬레이션...
public class n19237 {
    static class Info {
        int number;
        int smell;

        Info(int number, int smell){
            this.number = number;
            this.smell = smell;
        }
    }

    static class Coord {
        int x;
        int y;

        Coord(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    // 상어
    static class Shark {
        int x;
        int y;
        int n;
        int dir;

        Shark(int x, int y, int n) {
            this.x = x;
            this.y = y;
            this.n = n;
        }
    }

    // 위, 아래, 왼쪽, 오른쪽
    static int N, M, K;
    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, -1, 1};

    static int time;
    static Info[][] infos;
    static Shark[] sharks;
    static LinkedList<Coord> coords;
    static int[][][] t;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        infos = new Info[N][N];
        sharks = new Shark[M+1];
        coords = new LinkedList<>();

        // map 입력 받음
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp != 0)
                    sharks[tmp] = new Shark(i, j, tmp);
            }
        }

        st = new StringTokenizer(br.readLine());

        // 초기 방향 입력
        for(int i=1; i<=M; i++)
            sharks[i].dir = Integer.parseInt(st.nextToken());

        t = new int[M+1][5][5];

        // M개의 상어, 방향 넣기
        for(int i=1; i<=M; i++) {
            for(int j=1; j<=4; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=1; k<=4; k++)
                    t[i][j][k] = Integer.parseInt(st.nextToken());
            }
        }

        // 1번 상어만 남아있게되기까지의 걸린 시간, 1000초가 될때까지 남아있으면 -1을 출력
        while(true) {
            ++time;

            for(int i=1; i<=M; i++) {
                if(sharks[i] == null) continue;
                Shark s = sharks[i];
                infos[s.x][s.y] = new Info(i, K);
                coords.add(new Coord(s.x, s.y));
            }

            for(int i=1; i<=M; i++) {
                if(sharks[i] == null) continue;

                Shark shark = sharks[i];

                int nx, ny;
                boolean flag = false;

                for(int d=1; d<=4; d++) {
                    nx = shark.x + dx[t[i][shark.dir][d]];
                    ny = shark.y + dy[t[i][shark.dir][d]];

                    if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    if(infos[nx][ny] == null) {
                        sharks[i].x = nx;
                        sharks[i].y = ny;
                        sharks[i].dir = t[i][shark.dir][d];
                        flag = true;
                        break;
                    }
                }

                if(!flag) {
                    for(int d=1; d<=4; d++) {
                        nx = shark.x + dx[t[i][shark.dir][d]];
                        ny = shark.y + dy[t[i][shark.dir][d]];

                        if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                        if(infos[nx][ny].number == i) {
                            sharks[i].x = nx;
                            sharks[i].y = ny;
                            sharks[i].dir = t[i][shark.dir][d];

                            for(Iterator<Coord> it=coords.iterator(); it.hasNext();) {
                                Coord c = it.next();
                                if(c.x == nx && c.y == ny) it.remove();
                            }

                            break;
                        }
                    }
                }
            }

            for(Iterator<Coord> it = coords.iterator(); it.hasNext();) {
                Coord c = it.next();

                if(infos[c.x][c.y].smell-1 == 0) {
                    infos[c.x][c.y] = null;
                    it.remove();
                } else {
                    --infos[c.x][c.y].smell;
                }
            }

            boolean[][] vst = new boolean[N][N];

            for(int i=1; i<=M; i++){
                if(sharks[i] == null) continue;
                Shark shark = sharks[i];

                if(!vst[shark.x][shark.y])
                    vst[shark.x][shark.y] = true;
                else
                    sharks[i] = null;
            }

            boolean end = true;
            for(int i=2; i<=M; i++) {
                if (sharks[i] != null) {
                    end = false;
                    break;
                }
            }

            if(time > 1000) {
                time = -1;
                break;
            }

            if(end)
                break;
        }

        bw.write(time+"");
        bw.flush();
    }
}
