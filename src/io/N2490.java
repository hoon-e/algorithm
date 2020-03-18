package io;

import java.io.*;
import java.util.StringTokenizer;

public class N2490 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] go = new int[3][4];
        for(int i=0; i<3; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int j=0;
            while(st.hasMoreTokens()){
                go[i][j++] = Integer.parseInt(st.nextToken());
            }
        }

        for(int a=0; a<3; a++){
            int count = 0;
            for(int b=0; b<4; b++){
                if(go[a][b] == 0)
                    count++;
            }

            switch (count){
                case 0:
                    bw.write("E\n");
                    break;
                case 1:
                    bw.write("A\n");
                    break;
                case 2:
                    bw.write("B\n");
                    break;
                case 3:
                    bw.write("C\n");
                    break;
                case 4:
                    bw.write("D\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
