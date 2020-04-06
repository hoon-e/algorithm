package BOJ.DP;

import java.io.*;
import java.util.StringTokenizer;

public class N11722 {
    static int[] number = new int[1001];
    static int[] dist = new int[1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int k=0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()){
            number[k++] = Integer.parseInt(st.nextToken());
        }

        dist[0] = 1;
        for(int i=1; i<n; i++){
            dist[i] = 1;
            for(int j=0; j<i; j++){
                if(number[i] < number[j]){
                    dist[i] = Math.max(dist[i], dist[j]+1);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(max < dist[i])
                max = dist[i];
        }
        bw.write(max+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
