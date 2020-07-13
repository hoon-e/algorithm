package RE.simulation;

import java.io.*;
import java.util.*;

public class n14449 {
    static int N;
    static int M;
    static int[][] map;
    static int x;
    static int y;
    static int K;
    // 동, 서, 북, 남
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[] dice = {0, 0, 0, 0, 0, 0};
    static int[] tempDice;

    public static void main( String[] args ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(in.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(in.readLine());

        while(st.hasMoreTokens()){
            int dir = Integer.parseInt(st.nextToken());
            // 전개도로 어떻게 표현할 것인가?
            // 1 : 동, 2 : 서, 3 : 북, 4 : 남
            int nx = x + dx[dir-1];
            int ny = y + dy[dir-1];

            if(nx < 0 || nx >= N || ny < 0 || ny >= M ) continue;

            x = nx;
            y = ny;
            tempDice = new int[6];

            switch (dir) {
                case 1:
                    turnRight();
                    break;
                case 2:
                    turnLeft();
                    break;
                case 3:
                    turnBack();
                    break;
                case 4:
                    turnFront();
                    break;
            }

            out.write(dice[1]+"\n");
        }

        out.flush();
        in.close();
        out.close();
    }

    public static void setFloor() {
        if(map[x][y] != 0) {
            tempDice[3] = map[x][y];
            map[x][y] = 0;
        }else {
            map[x][y] = tempDice[3];
        }

        dice = tempDice;
    }

    public static void turnFront() {
        tempDice[0] = dice[1];
        tempDice[1] = dice[2];
        tempDice[2] = dice[3];
        tempDice[3] = dice[0];
        tempDice[4] = dice[4];
        tempDice[5] = dice[5];

        setFloor();
    }

    public static void turnLeft() {
        tempDice[0] = dice[0];
        tempDice[1] = dice[5];
        tempDice[2] = dice[2];
        tempDice[3] = dice[4];
        tempDice[4] = dice[1];
        tempDice[5] = dice[3];

        setFloor();
    }

    public static void turnRight() {
        tempDice[0] = dice[0];
        tempDice[1] = dice[4];
        tempDice[2] = dice[2];
        tempDice[3] = dice[5];
        tempDice[4] = dice[3];
        tempDice[5] = dice[1];

        setFloor();
    }

    public static void turnBack() {
        tempDice[0] = dice[3];
        tempDice[1] = dice[0];
        tempDice[2] = dice[1];
        tempDice[3] = dice[2];
        tempDice[4] = dice[4];
        tempDice[5] = dice[5];

        setFloor();
    }
}
