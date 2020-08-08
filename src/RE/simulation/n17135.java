package RE.simulation;

import java.sql.SQLOutput;
import java.util.*;
import java.io.*;

// N x M 의 격자판
// 궁수 3명을 배치시킨다. 성이 있는 칸에 배치 가능하다.
// 각 턴마다 궁수는 적하나를 공격한다. 궁수는 동시에 공격한다.
// 궁수가 공격하는 적은 거리가 D이하인 적 중에서 가장 가까운 적.
// 그러한 적이 여럿일 경우는 가장 왼쪽에 있는 적을 공격한다.
// 같은 적은 여거 궁수에게 공격당할 수 있다.
// 궁수읙 공격이 끝나면, 적은 아래로 한칸 이동하고 성이 있는 칸으로 이동하면 제외된다.
public class n17135 {
    static int N, M, D, enemy=-1, count;
    static boolean[] chk;
    static int[] player;
    static int[][] map;
    static ArrayList<int[]> enemies, temp;

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
        enemies = new ArrayList<>(); // 적 위치

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) enemies.add(new int[]{i, j});
            }
        }

        setArcher(0);

        bw.write(enemy+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void attack() {
        HashSet<Integer> loc = new HashSet<>();

        for(int idx : player) { // 3명의 궁수가 공격한다.
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
                    if(tmpEnemy == null) tmpEnemy = e;
                    if(tmpEnemy[1] > e[1]){ // 지금적이 더 왼쪽에 있을 경우
                        tmpIdx = i;
                        tmpEnemy = e;
                    }
                }
            }
            if(tmpEnemy != null) loc.add(tmpIdx);
        }

        if(loc.size() != 0) { // 지워야할 적의 위치가 있다면 지운다.
            for(int i : loc) temp.remove(i);
        }
        count += loc.size();
    }

    private static void moveEnemy() {
        ArrayList<int[]> move = new ArrayList<>();

        int cnt = 0;
        for(int[] e : temp) {
            ++e[0];
            if(e[0] < N) {
                move.add(e);
                ++cnt;
            }
        }

        if(cnt == 0)
            temp = null;
        else
            temp = new ArrayList<>(move); // 새롭게 적 list 갱신
    }

    private static void setArcher(int cnt) {
        if(cnt == 3) { // 3명 세팅했으면
            temp = new ArrayList<>(enemies); // 적 복사
            count = 0; // count 시작

            while(true) {
                attack(); // 공격
                moveEnemy(); // 적 이동
                if(temp == null) break;
            }

            enemy = (enemy < count) ? count : enemy;
            return;
        }

        for(int i=0; i<M; i++) {
            if(chk[i]) continue;
            chk[i] = true;
            player[cnt] = i; // player의 위치
            setArcher(cnt+1);
            chk[i] = false;
        }
    }
}
