package RE.dp;

import java.io.*;
import java.util.*;

public class n1149 {
    static int N;
    static int[][] house;
    public static void main( String[] args ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(in.readLine());
        house = new int[N][3];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(in.readLine());

            int red = Integer.parseInt(st.nextToken());
            int green = Integer.parseInt(st.nextToken());
            int blue = Integer.parseInt(st.nextToken());

            house[i][0] = red;
            house[i][1] = green;
            house[i][2] = blue;
        }

        for(int i=1; i<N; i++){
            house[i][0] = min(house[i][0] + house[i-1][1], house[i][0] + house[i-1][2]);
            house[i][1] = min(house[i][1] + house[i-1][0], house[i][1] + house[i-1][2]);
            house[i][2] = min(house[i][2] + house[i-1][0], house[i][2] + house[i-1][1]);
        }

        out.write(min(min(house[N-1][0], house[N-1][1]), house[N-1][2])+"");
        out.flush();
        in.close();
        out.close();
    }

    static int min(int a, int b){
        return (a < b) ? a : b;
    }
}
