package DFS_BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N7562 {
    static class coord{
        int x;
        int y;

        coord(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[][] chess;
    static boolean[][] chk;
    static int[] dx = {-1,-2,-2,-1,1,2,2,1};
    static int[] dy = {-2,-1,1,2,2,1,-1,-2};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int test = Integer.parseInt(br.readLine());

        while(test-- > 0){
            int width = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int startx=Integer.parseInt(st.nextToken());
            int starty=Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int finx=Integer.parseInt(st.nextToken());
            int finy=Integer.parseInt(st.nextToken());

            if(startx == finx && starty == finy ){
                bw.write(0+"\n");
                continue;
            }

            chess = new int[width+2][width+2];
            chk = new boolean[width+2][width+2];

            for(int i=startx; i<width; i++){
                for(int j=starty; j<width; j++){
                    if(chk[i][j]) continue;

                    chk[i][j] = true;
                    chess[i][j] = 0;

                    Queue<coord> q = new LinkedList<>();
                    q.offer(new coord(i, j));

                    while(!q.isEmpty()){
                        coord cur = q.poll();
                        for(int k=0; k<8; k++){
                            int nx = cur.x + dx[k];
                            int ny = cur.y + dy[k];

                            if(nx < 0 || nx >= width || ny < 0 || ny >= width) continue;
                            if(chk[nx][ny]) continue;
                            chk[nx][ny] = true;
                            chess[nx][ny] = chess[cur.x][cur.y]+1;

                            if(nx == finx && ny == finy){
                                bw.write(chess[finx][finy]+"\n");
                                break;
                            }
                            q.offer(new coord(nx, ny));
                        }
                    }
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
