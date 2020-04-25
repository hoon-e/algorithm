package BOJ.greedy;

import java.io.*;

public class N1941 {

    static boolean[] vst;
    static char[][] map;
    static boolean[][] chk;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int ans, cnt;

    /**
     * 기본적인 백트래킹 방식으로 구현하려 했으나 실패했다.
     * 아이디어가 필요하다. -> i/m , i%m으로 전체적인 맵을 탐색하고, 인접한 점인지 아닌지를 판별해주어야한다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        map = new char[5][5];

        for(int i=0; i<5; i++)
            map[i] = br.readLine().toCharArray();

        for(int i=0; i<25; i++){
            vst = new boolean[25];
            chk = new boolean[5][5];
            // 1 ~ 25까지 각각의 알파벳에서 DFS 시작
            DFS(i, 1, 0);
        }

        bw.write(ans+"");
        bw.flush();
        bw.close();
        br.close();
    }

    static void DFS(int idx, int count, int som){
        // 알파벳이 S라면 솜의 크기 증가
        if(map[idx/5][idx%5] == 'S'){
            ++som;
        }

        vst[idx] = true;
        chk[idx/5][idx%5] = true;

        // 길이가 7이고
        if(count == 7){
            if(som >= 4){ // 솜이 4명이상 이면
                find(); // 인접해있는지 찾는다.
            }
        }else{ // 아니라면 다음 인덱스부터 DFS다시 시작
            for(int i=idx+1; i<25; i++){
                if(!vst[i]){ // 접근하지 않은 인덱스에만
                    DFS(i, count+1, som);
                }
            }
        }

        // 접근 마쳤으므로 다시 false로 값 변경
        vst[idx] = false;
        chk[idx/5][idx%5] = false;
    }

    static void find(){
        // 0 ~ 25 까지 true인 값만 찾는다.
        for(int i=0; i<25; i++){
            if(vst[i]){
                int nx = i/5;
                int ny = i%5;

                boolean[][] visit = new boolean[5][5];
                visit[nx][ny] = true;
                cnt = 1;
                // 1부터 시작해서 DFS 탐색 시작
                isNextBy(nx, ny, visit);
                return;
            }
        }
    }

    static void isNextBy(int nx, int ny, boolean[][] visit){
        // cnt가 7이라면 횟수 증가시킨다.
        if(7 == cnt){
            ++ans;
        }else{
            for(int i=0; i<4; i++){
                int newX = nx + dx[i];
                int newY = ny + dy[i];

                if(newX < 0 || newX >= 5 || newY < 0 || newY >= 5) continue;
                if(visit[newX][newY] || !chk[newX][newY]) continue;
                visit[newX][newY] = true;
                ++cnt;
                isNextBy(newX, newY, visit);
            }
        }
    }
}
