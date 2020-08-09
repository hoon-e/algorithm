package RE.simulation;

import java.util.*;
import java.io.*;

public class n17135_amend {
    static int N, M, D, enemy=-1, count;
    static boolean[] chk;
    static int[] player;
    static int[][] map;

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
        ArrayList<int[]> enemies = new ArrayList<>(); // 적 위치

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) enemies.add(new int[]{i, j});
            }
        }

        setArcher(0, enemies);

        bw.write(enemy+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static ArrayList<int[]> attack(ArrayList<int[]> temp) {
        HashMap<Integer, Boolean> check = new HashMap<>();
        ArrayList<int[]> moving = new ArrayList<>();

        // 3명의 궁수가 공격한다. idx는 열을 의미한다.
        for(int idx : player) {
            int minDist = 1_000_000;
            int tmpIdx = 0;
            int[] tmpEnemy = null;

            for(int i=0; i<temp.size(); i++) {
                int[] e = temp.get(i);
                int dist = Math.abs(N - e[0]) + Math.abs(idx - e[1]);
                if(dist > D) continue; // 최소거리보다 클 경우 계속 진행

                if(minDist > dist) { // 최소거리일 경우
                    minDist = dist;
                    tmpIdx = i;
                    tmpEnemy = e;
                } else if(minDist == dist) { // 최소거리가 같을 경우
                    if(tmpEnemy[1] > e[1]){ // 지금적이 더 왼쪽에 있을 경우
                        tmpIdx = i;
                        tmpEnemy = e;
                    }
                }
            }

            if(tmpEnemy != null)
                check.put(tmpIdx, true);
        }

        for(int i=0; i<temp.size(); i++) {
            if(check.get(i) == null) moving.add(temp.get(i));
        }

        count += check.size();
        return moving;
    }

    private static ArrayList<int[]> moveEnemy(ArrayList<int[]> temp) {
        ArrayList<int[]> move = new ArrayList<>();

        for(int[] e : temp) {
            int[] g = new int[2];
            System.arraycopy(e, 0, g, 0, 2);

            if(++g[0] < N) {
                move.add(g);
            }
        }

        return move;
    }

    private static void setArcher(int cnt, ArrayList<int[]> enemies) {
        if(cnt == 3) { // 3명 세팅했으면
            ArrayList<int[]> temp = new ArrayList<>(enemies); // 적 복사
            count = 0; // count 시작

            while(true) {
                temp = attack(temp); // 공격
                temp = moveEnemy(temp); // 적 이동
                if(temp.size() == 0) break;
            }

            enemy = (enemy < count) ? count : enemy;
            return;
        }

        for(int i=0; i<M; i++) {
            if(chk[i]) continue;
            chk[i] = true;
            player[cnt] = i; // player의 위치
            setArcher(cnt+1, enemies);
            chk[i] = false;
        }
    }
}
