package BOJ.DP;

import java.io.*;
import java.util.StringTokenizer;

// DP 기본
public class N14501 {
    static int[] T;
    static int[] P;
    static int day;
    static int[] sum;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        day = Integer.parseInt(br.readLine());
        T = new int[day+2];
        P = new int[day+2];
        sum = new int[day+2];

        for(int i=1; i<=day; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=day; i > 0; i--){
            int today = i + T[i];

            if(today > day + 1)
                sum[i] = sum[i+1];
            else
                sum[i] = Math.max(P[i] + sum[today], sum[i+1]);
        }

        bw.write(sum[1]+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
