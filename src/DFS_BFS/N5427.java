package DFS_BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N5427 {
    static class coord {
        int x;
        int y;
        int dist;
        int type;

        coord(int x, int y, int dist, int type){
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.type = type;
        }
    }

    static int HUMAN = 1;
    static int FIRE = 0;

    static char[][] map;
    static boolean[][] vst;
    static int W;
    static int H;
    static int startX;
    static int startY;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<coord> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testcase = Integer.parseInt(br.readLine());

        while(testcase-- >0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            map = new char[H][W];
            vst = new boolean[H][W];

            for(int i=0; i<H; i++)
                map[i] = br.readLine().toCharArray();

            q = new LinkedList<>();

            for(int i=0; i<H; i++) {
                for (int j = 0; j < W; j++) {
                    if(map[i][j] == '#' || map[i][j] == '.') continue;
                    if(map[i][j] == '@') {
                        startX = i; startY = j;
                    }
                    if(map[i][j] == '*'){
                        q.offer(new coord(i,j,0,FIRE));
                        vst[i][j] = true;
                    }
                }
            }

            int ans = Bfs();
            if( ans == 0 )
                bw.write("IMPOSSIBLE\n");
            else
                bw.write(ans+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static int Bfs(){
        Queue<coord> nq = new LinkedList<>();

        // 아이디어 : 불이 먼저 퍼져야하므로 불을 먼저 넣고 탐색을 한다.
        for(coord fire : q)
            nq.offer(fire);

        nq.offer(new coord(startX, startY, 0, HUMAN));
        vst[startX][startY] = true;

        while(!nq.isEmpty()){
            coord cur = nq.poll();

            if(cur.type == HUMAN && ( cur.x == 0 || cur.x == H-1 || cur.y == 0 || cur.y == W-1))
                return (cur.dist + 1);

            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
                if(vst[nx][ny] || map[nx][ny] != '.') continue;

                if(cur.type == HUMAN)
                    vst[nx][ny] = true;
                else
                    map[nx][ny] = '*';

                nq.offer(new coord(nx, ny, cur.dist+1, cur.type));
            }
        }
        return 0;
    }
}
