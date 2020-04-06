package BOJ.DP;

import java.io.*;
import java.util.StringTokenizer;

public class N11053 {
    static int[] n = new int[1001];
    static int[] dist = new int[1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int len = Integer.parseInt(br.readLine());

        int i=1;
        int max=Integer.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            n[i++] = Integer.parseInt(st.nextToken());
        }

        dist[1] = 1;
        for(int j=2; j<=len; j++){
            dist[j] = 1;
            for(int k=1; k<j; k++){
                if(n[k] < n[j]){
                    dist[j] = Math.max(dist[j], dist[k]+1);
                }
            }
        }

        for(int j=1; j<=len; j++){
            if(dist[j] > max)
                max = dist[j];
        }

        bw.write(max+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
