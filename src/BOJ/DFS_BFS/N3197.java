package BOJ.DFS_BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class coord {
    int x;
    int y;

    coord(int x, int y){
        this.x = x;
        this.y = y;
    }
}

// 시간 복잡도가 중요한 문제. 어떻게하면 녹는 것과 백조의 이동을 동시에 처리할 것인가?
public class N3197 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static coord swan1, swan2;
    static boolean[][] vst = new boolean[1500][1500];
    static boolean[][] melt = new boolean[1500][1500];
    static char[][] lake = new char[1500][1500];

    static int R;
    static int C;
    static Queue<coord> swan_main, swan_temp;
    static Queue<coord> lake_main, lake_temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        swan_main = new LinkedList<>();
        swan_temp = new LinkedList<>();
        lake_main = new LinkedList<>();
        lake_temp = new LinkedList<>();

        int n = 0;
        for(int i=0; i<R; i++){
            lake[i] = br.readLine().toCharArray();
            for(int j=0; j<C; j++){
                if(lake[i][j] == 'L') { // 백조일 경우
                    if(++n == 1) swan1 = new coord(i, j);
                    else swan2 = new coord(i,j);
                    lake[i][j]  = '.'; // 해당 호수의 값을 .으로 바꾼다.
                }
                // . 일 경우
                if(lake[i][j] == '.')
                {
                    melt[i][j] = true; // melt를 true로 하고
                    lake_temp.offer(new coord(i, j)); // lake_temp에 값을 추가한다.
                }
            }
        }

        // 백조 temp에 swan1을 추가한다.
        swan_temp.offer(swan1);
        vst[swan1.x][swan1.y] = true;

        int day = 0;

        // swan2의 위치에 도달하는지 아닌지를 찾는다.
        while(!vst[swan2.x][swan2.y]){
            day++;
            while(!swan_temp.isEmpty())
                swan_main.offer(swan_temp.poll());
            while(!lake_temp.isEmpty())
                lake_main.offer(lake_temp.poll());

            while(!lake_main.isEmpty()){
                coord cur = lake_main.poll();
                lake[cur.x][cur.y] = '.'; // X를 기준으로 찾는 것이 아니라 .를 기준으로 찾는다.

                for(int i=0; i<4; i++){
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if(nx < 0 || nx >= R || ny < 0 || ny >= C || melt[nx][ny]) continue;
                    melt[nx][ny] = true;
                    lake_temp.offer(new coord(nx, ny));
                }
            }

            while(!swan_main.isEmpty()){
                coord cur = swan_main.poll();

                for(int i=0; i<4; i++){
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if(nx < 0 || nx >= R || ny < 0 || ny >= C || vst[nx][ny]) continue;
                    vst[nx][ny] = true;
                    if(lake[nx][ny] == '.') swan_main.offer(new coord(nx, ny)); // .라면 현재 이동 큐에 삽입한다.
                    if(lake[nx][ny] == 'X') swan_temp.offer(new coord(nx, ny)); // X라면 다음 날 이동 큐에 삽입한다.
                }
            }
        }

        bw.write((day-1)+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
