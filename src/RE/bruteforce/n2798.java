package RE.bruteforce;

import java.util.*;
import java.io.*;

public class n2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] card = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++)
            card[i] = Integer.parseInt(st.nextToken());

        long[] sum = new long[3];
        long max = -1;
        for(int i=0; i<N; i++){
            sum[0] = card[i];
            for(int j=i+1; j<N; j++) {
                sum[1] = sum[0] + card[j];
                for(int k=j+1; k<N; k++){
                    sum[2] = sum[1] + card[k];
                    if(sum[2] <= M) max = (max < sum[2]) ? sum[2] : max;
                }
            }
        }

        System.out.println(max);
    }
}
