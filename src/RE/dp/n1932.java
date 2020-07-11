package RE.dp;

import java.io.*;
import java.util.*;

public class n1932 {
    static int N;
    static int[][] tri;
    public static void main( String[] args ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(in.readLine());
        tri = new int[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            for(int j=0; j<i+1; j++){
                tri[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<N; i++){
            for(int j=0; j<i+1; j++){
                if(j == 0)
                    tri[i][j] += tri[i-1][j];
                else if(j == i)
                    tri[i][j] += tri[i-1][j-1];
                else
                    tri[i][j] = max(tri[i][j] + tri[i-1][j-1], tri[i][j] + tri[i-1][j]);
            }
        }

        int max = -1;
        for(int i=0; i<N; i++)
            max = max(tri[N-1][i], max);

        out.write(max+"");
        out.flush();
        in.close();
        out.close();
    }

    static int max(int a, int b){
        return (a > b) ? a : b;
    }
}
