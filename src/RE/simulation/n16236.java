package RE.simulation;

import java.util.*;
import java.io.*;

// 아기상어
// 한 칸에는 물고기가 최대 1마리
// 아기 상어의 크기는 2이고, 1초에 상하좌우로 인접한 한칸씩 이동한다.
// 아기 상어는 자신의 크기보다 큰 물고기가 있는 칸은 지나갈 수 없고, 나머지 칸은 모두 가능하다.
// 자신의 크기보다 작은 물고기만 먹을 수 있다.(크기가 같으면 먹을수 없지만 지나갈 수는 있다.)

// 더 이상 먹을 수 있는 물고기가 없다면 엄마 상어에게 도움
// 먹을 수 있는 물고기가 1마리라면, 그 물고기를 먹으러간다.
// 먹을 수 있는 물고기가 1마리보다 많다면, 거리가 가장 가까운 물고기를 먹으러 간다.
// 거리는 지나야하는 칸의 개수의 최솟값이다.
// 거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기. 그런 물고기가 여러마리라면 가장 왼쪽에 있는 물고기를 먹는다.
// 자신의 크기와 같은 수의 물고기를 먹을 때마다 크기가 1증가한다.

public class n16236 {
    static int N, M, time;
    static int[][] aqua;
    static int[] baby;
    static ArrayList<int[]> fish;
    static int dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        aqua = new int[N][N];
        fish = new ArrayList<>();

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                aqua[i][j] = Integer.parseInt(st.nextToken());

                if(aqua[i][j] == 9) baby = new int[]{i, j, 2, 0};
                if(aqua[i][j] > 0 && aqua[i][j] < 9) fish.add(new int[]{i, j, aqua[i][j]});
            }
        }

        if(fish.size() == 0) time = 0;
        else {
            while(true) {
                int[] target = eatFish();
                if(target == null) break;
                moveShark(target); // 상어 이동한다.
            }
        }

        bw.write(time+"\n");
        bw.flush();
    }

    private static void moveShark(int[] target) {
        time += dist; // 시간 더해주기

        aqua[baby[0]][baby[1]] = 0;
        baby[0] = target[0];
        baby[1] = target[1];
        ++baby[3];
        aqua[baby[0]][baby[1]] = 9;

        if(baby[2] == baby[3]) { // 같다면, 증가시키고 2번 증가되었다면 크기를 증가시킨다.
            ++baby[2];
            baby[3] = 0;
        }
    }

    private static int getDist(int r, int c){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vst = new boolean[N][N];

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        vst[baby[0]][baby[1]] = true;
        q.offer(new int[] {baby[0], baby[1], 0});

        int distance = 1_000_000;
        while(!q.isEmpty()) {
            int[] cur = q.poll();

            if(cur[0] == r && cur[1] == c) {
                distance = (distance > cur[2]) ? cur[2] : distance;
                break;
            }

            for(int d=0; d<4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(aqua[nx][ny] > baby[2]) continue;
                if(vst[nx][ny]) continue;
                vst[nx][ny] = true;
                q.offer(new int[]{nx, ny, cur[2]+1});
            }
        }

        return distance;
    }

    private static int[] eatFish() {
        if(fish.size() == 0) return null;

        int idx = 0;
        int minDist = 1_000_000;
        int[] target = null;

        for(int i=0; i<fish.size(); i++) {
            int[] coord = fish.get(i);

            if(coord[2] < baby[2]) {
                int tmpDist = getDist(coord[0], coord[1]);

                if(minDist > tmpDist) {
                    minDist = tmpDist;
                    dist = tmpDist;
                    idx = i;
                    target = coord;
                } else if(minDist == dist) { // 거리가 같다면
                    if(target[0] > coord[0]) {
                        target = coord;
                        idx = i;
                    } else if(target[0] == coord[0]) {
                        if(target[1] > coord[1]) {
                            target = coord;
                            idx = i;
                        }
                    }
                }
            }
        }

        if(target == null)
            return null;
        else {
            fish.remove(idx); // 먹을 생선 지우기
            return target;
        }
    }
}
