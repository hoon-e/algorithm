package RE.simulation;

import java.util.*;
import java.io.*;

public class n17135_array {
    static class Enemy {
        int x;
        int y;

        Enemy(int x, int y){
            this.x = x;
            this.y = y;
        }

        Enemy(Enemy e){
            this.x = e.x;
            this.y = e.y;
        }
    }

    static int N, M, D, enemy=-1, count;
    static boolean[] chk;
    static int[] player;
    static int[][] map;
    static Enemy[] enemies, temp;
    static int enemySize, tempSize;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        chk = new boolean[M];
        player = new int[3];

        map = new int[N][M]; // map : N+1 행은 성이다.
        enemies = new Enemy[N*M];

        int e=0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                    enemies[e++] = new Enemy(i, j);
                    enemySize++; // 적의 명수
                }
            }
        }

        temp = new Enemy[enemySize];
        setArcher(0);

        bw.write(enemy+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void attack() {
        HashMap<Integer, Boolean> check = new HashMap<>();

        // 3명의 궁수가 공격한다. idx는 열을 의미한다.
        int removeEnemy = 0;
        for(int idx : player) {
            int minDist = 1_000_000;
            int tmpIdx = 0;
            Enemy tmpEnemy = null;

            // 5명 (0,0) (1,1) : 1

            for(int i=0; i<tempSize; i++) {
                int dist = Math.abs(N - temp[i].x) + Math.abs(idx - temp[i].y);
                if(dist > D) continue; // 최소거리보다 클 경우 계속 진행

                if(minDist > dist) { // 최소거리일 경우
                    minDist = dist;
                    tmpIdx = i;
                    tmpEnemy = temp[i];
                } else if(minDist == dist) { // 최소거리가 같을 경우
                    if(tmpEnemy.y > temp[i].y){ // 지금적이 더 왼쪽에 있을 경우
                        tmpIdx = i;
                        tmpEnemy = temp[i];
                    }
                }
            }

            if(tmpEnemy != null) { // 맞았다면 적의 idx를 넣는다.
                if(check.get(tmpIdx) == null) {
                    check.put(tmpIdx, true);
                    removeEnemy++;
                }
            }
        }

        Enemy[] moving = new Enemy[tempSize];

        int e = 0;
        for(int i=0; i<tempSize; i++) {
            if(check.get(i) == null) moving[e++] = temp[i];
        }

        count += removeEnemy; // 제거한 적의 수
        tempSize -= removeEnemy;

        System.arraycopy(moving, 0, temp, 0, e);
    }

    private static void moveEnemy() {
        Enemy[] moving = new Enemy[tempSize];

        int e=0;
        for(int i=0; i<tempSize; i++) {
            Enemy c = new Enemy(temp[i]);

            if(++c.x < N) {
                moving[e++] = c;
            }
        }

        tempSize = e;
        System.arraycopy(moving, 0, temp, 0, tempSize);
    }

    private static void setArcher(int cnt) {
        if(cnt == 3) { // 3명 세팅했으면
            // 적 복사
            temp = new Enemy[enemySize];
            System.arraycopy(enemies, 0, temp, 0, enemySize);
            tempSize = enemySize;
            count = 0; // count 시작

            while(true) {
                attack(); // 공격
                moveEnemy(); // 적 이동
                if(tempSize == 0) break;
            }

            enemy = (enemy < count) ? count : enemy;
            return;
        }

        for(int i=0; i<M; i++) {
            if(chk[i]) continue;
            chk[i] = true;
            // player의 위치
            player[cnt] = i;
            setArcher(cnt+1);
            chk[i] = false;
        }
    }
}