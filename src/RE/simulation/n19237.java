package RE.simulation;

import java.util.*;
import java.io.*;

public class n19237 {
    // 상어
    static class Shark {
        int x;
        int y;
        int dir;

        Shark(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // 위, 아래, 왼쪽, 오른쪽
    static int N, M, K;
    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, -1, 1};

    static int[][] smell, number, vst;
    static int time;
    static Shark[] sharks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, int[][]> dir = new HashMap<>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        smell = new int[N][N]; // 냄새
        number = new int[N][N]; // 방문한 애
        vst = new int[N][N]; // 방문시간
        sharks = new Shark[M+1];

        // map 입력 받음
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                number[i][j] = Integer.parseInt(st.nextToken());
                if(number[i][j] != 0) {
                    sharks[number[i][j]] = new Shark(i, j);
                    smell[i][j] = K;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        // 초기 방향 입력
        for(int i=1; i<=M; i++)
            sharks[i].dir = Integer.parseInt(st.nextToken());

        // M개의 상어, 방향 넣기
        for(int i=1; i<=M; i++) {
            int[][] t = new int[5][5];
            for(int j=1; j<=4; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=1; k<=4; k++)
                    t[j][k] = Integer.parseInt(st.nextToken());
            }
            dir.put(i, t);
        }

        // 1번 상어만 남아있게되기까지의 걸린 시간, 1000초가 될때까지 남아있으면 -1을 출력
        while(true) {
            ++time;

            System.out.println(time);
            for(int i=1; i<=M; i++) {
                int[][] tmpDir = dir.get(i);
                if(sharks[i] == null) continue;
                check(i, tmpDir[sharks[i].dir], time);
            }

            gas();

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++)
                    System.out.print(number[i][j] + " ");
                System.out.println();
            }
            System.out.println();

            if(!isOnly()) break;
            if(time > 1000) {
                time = -1;
                break;
            }
        }

        bw.write(time+"");
        bw.flush();
    }

    private static boolean isOnly() {
        for(int i=2; i<=M; i++){
            if(sharks[i] != null) return true;
        }
        return false;
    }

    // 주변 확인하는 함수
    private static void check(int n, int[] myDir, int time) {
        int curX = sharks[n].x; // 현재 좌표
        int curY = sharks[n].y;

        int nx=0, ny=0;
        int tmpX=0, tmpY=0, tmpDir=0;
        boolean flag = false;
        boolean chk = false;

        for(int i=1; i<=4; i++) {
            nx = curX + dx[myDir[i]];
            ny = curY + dy[myDir[i]];

            if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

            if(n == number[nx][ny] && !chk) { // 일단 자기 번호 패스
                System.out.println(n + " " + i);
                tmpX = nx;
                tmpY = ny;
                tmpDir = myDir[i];
                chk = true;
                continue;
            }

            if(number[nx][ny] != n && vst[nx][ny] == time) { // 이전에 누가 방문했고, 시간이 같을 때
                if(number[nx][ny] < n) { // 만약 들어와있는 번호가 지금 온 번호보다 크다.
                    sharks[n] = null; // 상어 out
                } else {
                    sharks[number[nx][ny]] = null;
                }
                flag = true;
                break;
            }

            if(number[nx][ny] == 0) { // 0이면 방문
                setShark(nx, ny, n, myDir[i]);
                flag = true;
                break;
            }
        }

        if(!flag) {// 방문할 수 있는 점이 없다면 내 방문으로 감
            System.out.println(n + " " + tmpX + " " + tmpY + " " + tmpDir);
            setShark(tmpX, tmpY, n, tmpDir);
        }
    }

    private static void gas() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(vst[i][j] <= time-1) {
                    if(smell[i][j]-1 == 0) { // 냄새가 없어진다면
                        number[i][j] = 0;
                        --smell[i][j];
                    }else
                        smell[i][j] = (smell[i][j]-1 < 0) ? 0 : --smell[i][j];
                }
            }
        }
    }

    private static void setShark(int nx, int ny, int n, int dir) {
        sharks[n].x = nx;
        sharks[n].y = ny;
        sharks[n].dir = dir;

        number[nx][ny] = n;
        smell[nx][ny] = K; // 향기 남김
        vst[nx][ny] = time;
    }
}
