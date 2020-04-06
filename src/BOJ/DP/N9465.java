package BOJ.DP;

import java.io.*;
import java.util.StringTokenizer;

public class N9465 {
    static int[][] sticker;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());

        while(tc-- >0){
            int width = Integer.parseInt(br.readLine());
            sticker = new int[2][width];
            StringTokenizer st = new StringTokenizer(br.readLine());

            int i=0;
            while(st.hasMoreTokens()){
                sticker[0][i++] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());

            i=0;
            while(st.hasMoreTokens()) {
                sticker[1][i++] = Integer.parseInt(st.nextToken());
            }

            sticker[0][1] += sticker[1][0];
            sticker[1][1] += sticker[0][0];

            for(int b=2; b<width; b++) {
                sticker[0][b] = Math.max((sticker[0][b] + sticker[1][b - 2]), (sticker[0][b] + sticker[1][b - 1]));
                sticker[1][b] = Math.max((sticker[1][b] + sticker[0][b - 2]), (sticker[1][b] + sticker[0][b - 1]));
            }

            bw.write(Math.max(sticker[0][width-1], sticker[1][width-1])+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
