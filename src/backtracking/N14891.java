package backtracking;

import java.io.*;
import java.util.StringTokenizer;

// 톱니바퀴의 방향을 각각 저장하고, 방향에 따라 옮긴디.
// 돌아가는 톱니를 기준으로 왼쪽과 오른쪽을 나누어 생각해주는 것이 필요하다.
public class N14891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = 4;
        char[][] polar = new char[4][8];
        // N극이 0, S극이 1

        for(int i=0; i<num; i++)
            polar[i] = br.readLine().toCharArray();

        int way = Integer.parseInt(br.readLine());

        while(way-- >0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int no = Integer.parseInt(st.nextToken())-1;
            int dir = Integer.parseInt(st.nextToken());

            int[] d = new int[num];
            d[no] = dir;

            for(int i=no-1; i>=0; i--){
                if(polar[i][2] != polar[i+1][6])
                    d[i] = -d[i+1];
                else break;
            }

            for(int i=no+1; i<num; i++){
                if(polar[i-1][2] != polar[i][6])
                    d[i] = -d[i-1];
                else break;
            }

            for(int i=0; i<num; i++){
                if(d[i] == 0) continue;
                if(d[i] == 1){
                    char t = polar[i][7];

                    for(int j=7; j>=1; j--)
                        polar[i][j] = polar[i][j-1];
                    polar[i][0] = t;
                }else if(d[i] == -1) {
                    char t = polar[i][0];

                    for(int j=0; j<7; j++)
                        polar[i][j]  = polar[i][j+1];
                    polar[i][7] = t;
                }
            }
        }

        int scr = 0;

        for(int i=0; i<num; i++){
            if(polar[i][0] == '1'){
                scr |= (1 << i);
            }
        }
        bw.write(String.valueOf(scr));
        bw.flush();
        bw.close();
        br.close();
    }
}
