package BOJ.greedy;

import java.io.*;

public class N1941 {

    static char[][] cls = new char[5][5];
    static boolean[][] vst = new boolean[5][5];
    static boolean[][] chk = new boolean[5][5];
    static char[] dap = new char[7];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i=0; i<5; i++)
            cls[i] = br.readLine().toCharArray();

        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(cls[i][j] == 'Y') {
                    sevenPcs(i, j, 1, 0, 0);
                }
                else {
                    sevenPcs(i, j, 0, 1, 0);
                }
            }
        }

        bw.write(cnt+"");
        bw.flush();
        bw.close();
        br.close();
    }

    static void sevenPcs(int st, int end, int y, int s, int len){
        if( y >= 4 )
            return;

        if(len == 7){
            for(int i=0; i<7; i++)
                System.out.print(dap[i] + ",");
            System.out.println(cnt);
            cnt++;
            return;
        }

        for(int i=0; i<4; i++){
            if(!vst[st][end]) {
                int nx = st + dx[i];
                int ny = end + dy[i];
                dap[len] = cls[st][end];

                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
                if (cls[nx][ny] == 'Y')
                    sevenPcs(nx, ny, y + 1, s, len + 1);
                else
                    sevenPcs(nx, ny, y, s + 1, len + 1);
            }
        }
    }
}
