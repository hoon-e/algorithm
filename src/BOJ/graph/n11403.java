package BOJ.graph;

import java.io.*;
import java.util.*;

public class n11403 {
    static final int INF = 99999;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int size = Integer.parseInt(in.readLine());
        int[][] dist = new int[size][size];

        for(int i=0; i<size; i++){
            st = new StringTokenizer(in.readLine());

            int j=0;
            while(st.hasMoreTokens()){
                int number = Integer.parseInt(st.nextToken());

                if(number == 0)
                    dist[i][j++] = INF;
                else
                    dist[i][j++] = number;
            }
        }

        for(int k=0; k<size; k++){
            for(int i=0; i<size; i++){
                for(int j=0; j<size; j++){
                    if(dist[i][j] > dist[i][k] + dist[k][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        for(int i=0; i<size; i++) {
            for (int j = 0; j < size; j++) {
                if(dist[i][j] == INF)
                    out.write(0 + " ");
                else
                    out.write(1 + " ");
            }
            out.write("\n");
        }

        out.flush();
        in.close();
        out.close();
    }
}
