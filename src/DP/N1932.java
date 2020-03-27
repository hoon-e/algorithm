package DP;

import java.io.*;
import java.util.StringTokenizer;

// 정수 삼각형
public class N1932 {
    static int[][] tri = new int[502][502];
    static int[][] sum = new int[502][502];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());


        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                tri[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sum[0][0] = tri[0][0];

        for(int i=1; i<N; i++){
            for(int j=0; j<= i; j++){
                if( j == 0 )
                    sum[i][j] = sum[i-1][j] + tri[i][j];
                else if( j == i )
                    sum[i][j] = sum[i-1][j-1] + tri[i][j];
                else
                    sum[i][j] = Math.max(sum[i-1][j] + tri[i][j], sum[i-1][j-1] + tri[i][j]);
            }
        }

        int max = 0;
        for(int i=0; i<N; i++){
            max = Math.max(max, sum[N-1][i]);
        }

        bw.write(max+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}