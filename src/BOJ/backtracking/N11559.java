package BOJ.backtracking;

import java.io.*;
import java.util.*;

// 하나의 연쇄가 끝나기 전까지는 count를 증가시켜주면 안된다.
public class N11559 {
    static class coord {
        int x;
        int y;

        coord(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    // 뿌요뿌요 맵
    static char[][] puyo = new char[12][6];
    // 방문 체크 배열
    static boolean[][] chk = new boolean[12][6];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    static int score;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 12; i++) {
            puyo[i] = br.readLine().toCharArray();
        }

        Queue<coord> q = new LinkedList<>();
        Queue<coord> pos = new LinkedList<>();

        boolean isAny;

        while (true) {
            isAny = true;
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    // 방문한 점이거나, 알파벳이 아니라면 통과
                    if (chk[i][j] || !Character.isAlphabetic(puyo[i][j])) continue;

                    chk[i][j] = true;

                    // 현재의 뿌요
                    char now = puyo[i][j];

                    // queue와 position을 초기화
                    q.clear();
                    pos.clear();
                    
                    q.offer(new coord(i, j));

                    while (!q.isEmpty()) {
                        coord cur = q.poll();
                        pos.offer(cur);

                        for (int k = 0; k < 4; k++) {
                            int nx = cur.x + dx[k];
                            int ny = cur.y + dy[k];

                            // 범위를 벗어나거나, 현재의 뿌요와 같지않다면 통과
                            if (nx < 0 || nx >= 12 || ny < 0 || ny >= 6) continue;
                            if (puyo[nx][ny] != now || chk[nx][ny]) continue;
                            chk[nx][ny] = true;
                            q.offer(new coord(nx, ny));
                        }
                    }

                    // pos에 들어있는 사이즈가 4보다 크다면 pos가 끝날때까지 x로 초기화한다.
                    if (pos.size() >= 4) {
                        while (!pos.isEmpty()) {
                            coord cur = pos.poll();
                            puyo[cur.x][cur.y] = 'x';
                        }
                        isAny = false;
                    }
                }
            }

            // x로 바뀌어있는 값을 아래 방향으로 행을 초기화한다.
            for(int i=0; i<12; i++){
                for(int j=0; j<6; j++){
                    if(puyo[i][j] == 'x'){
                        deleteRow(new coord(i, j));
                    }
                    chk[i][j] = false;
                }
            }

            if(isAny) break;
            score++;
        }

        bw.write(String.valueOf(score));
        bw.flush();
        bw.close();
        br.close();
    }

    // 행을 삭제하는 함수
    static void deleteRow(coord pos){
        for(int i=pos.x; i>=1; i--)
            puyo[i][pos.y] = puyo[i-1][pos.y];
        puyo[0][pos.y] = '.';
    }
}
