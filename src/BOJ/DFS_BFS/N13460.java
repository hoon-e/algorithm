package BOJ.DFS_BFS;

import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N13460 {
    static class coord {
        Point red;
        Point blue;
        int dist;

        coord() {};
        coord(coord marble, int dist){
            this.red = new Point(marble.red.x, marble.red.y);
            this.blue = new Point(marble.blue.x, marble.blue.y);
            this.dist = dist;
        }
    }

    static int N;
    static int M;
    static char[][] board;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static final int RED = 0;
    static final int BLUE = 1;
    static boolean[][][][] vst;
    static Queue<coord> q;
    static Point exit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        vst = new boolean[N][M][N][M];
        coord marble = new coord();

        for(int i=0; i<N; i++){
            board[i] = br.readLine().toCharArray();
            for(int j=0; j<M; j++){
                if(board[i][j] == 'R'){
                    marble.red = new Point(i,j);
                }else if(board[i][j] == 'B'){
                    marble.blue = new Point(i,j);
                }else if(board[i][j] == 'O')
                    exit = new Point(i,j);
            }
        }

        vst[marble.red.x][marble.red.y][marble.blue.x][marble.blue.y] = true;

        q = new LinkedList<>();
        q.offer(marble);

        bw.write(BFS()+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void rollMarble(coord rolled, int dir, boolean type){
        int nx;
        int ny;

        while(true) {
            if (type) {
                nx = rolled.red.x + dx[dir];
                ny = rolled.red.y + dy[dir];
            } else {
                nx = rolled.blue.x + dx[dir];
                ny = rolled.blue.y + dy[dir];
            }

            if(board[nx][ny] == '.'){
                if(type && !(rolled.blue.x == nx && rolled.blue.y == ny)){
                    board[rolled.red.x][rolled.red.y] = '.';
                    rolled.red.x = nx;
                    rolled.red.y = ny;
                }
                else if(!type && !(rolled.red.x == nx && rolled.red.y == ny)){
                    board[rolled.blue.x][rolled.blue.y] = '.';
                    rolled.blue.x = nx;
                    rolled.blue.y = ny;
                }else
                    break;
            }else if(board[nx][ny] == 'O'){
                if (type) {
                    board[rolled.red.x][rolled.red.y] = '.';
                    rolled.red.x = nx;
                    rolled.red.y = ny;
                }else{
                    board[rolled.blue.x][rolled.blue.y] = '.';
                    rolled.blue.x = nx;
                    rolled.blue.y = ny;
                }
                break;
            }else
                break;
        }
    }

    // 빨간 구슬과 파란 구슬은 동시에 같은 칸에 있을 수 없다. 빨강이와 파랑이가 동시에 구멍에 빠져도 실패.
    // 10번 이하로 못빼면 -1 출력
    static int BFS() {
        while (!q.isEmpty()) {
            coord marble = q.poll();

            if (marble.dist < 10) {
                for (int i = 0; i < 4; i++) {
                    boolean rollFirst = false;
                    coord newMarble = new coord(marble, marble.dist + 1);
                    // 어떤 구슬이 먼저 움직일 지 고려해주어야한다.
                    if( i == 0 && (newMarble.red.x < newMarble.blue.x) && (newMarble.red.y == newMarble.blue.y)){
                        rollFirst = true;
                    }else if( i == 1 && (newMarble.red.x > newMarble.blue.x) && (newMarble.red.y == newMarble.blue.y)){
                        rollFirst = true;
                    }else if( i == 2 && (newMarble.red.x == newMarble.blue.x) && (newMarble.red.y < newMarble.blue.y)){
                        rollFirst = true;
                    }else if( i == 3 && (newMarble.red.x == newMarble.blue.x) && (newMarble.red.y > newMarble.blue.y)){
                        rollFirst = true;
                    }

                    if(rollFirst){
                        rollMarble(newMarble, i, true);
                        rollMarble(newMarble, i, false);
                    }else{
                        rollMarble(newMarble, i, false);
                        rollMarble(newMarble, i, true);
                    }

                    if(newMarble.red.x == exit.x && newMarble.red.y == exit.y){
                        if(!(newMarble.blue.x == exit.x && newMarble.blue.y == exit.y))
                            return newMarble.dist;
                    }else{
                        if(!(newMarble.blue.x == exit.x && newMarble.blue.y == exit.y) && !vst[newMarble.red.x][newMarble.red.y][newMarble.blue.x][newMarble.blue.y]) {
                            vst[newMarble.red.x][newMarble.red.y][newMarble.blue.x][newMarble.blue.y] = true;
                            q.offer(newMarble);
                        }
                    }
                }
            }
        }
        return -1;
    }
}
