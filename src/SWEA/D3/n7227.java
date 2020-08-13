package SWEA.D3;

import java.util.*;
import java.io.*;

public class n7227 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=t; tc++) {
            int N = Integer.parseInt(br.readLine());

            int[][] coord = new int[N][2];

            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());

                coord[i][0] = Integer.parseInt(st.nextToken());
                coord[i][1] = Integer.parseInt(st.nextToken());
            }


        }
    }


}
