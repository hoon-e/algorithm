package BOJ.mathematics;

import java.io.*;
import java.util.*;

public class N9950 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int test = Integer.parseInt(in.readLine());

        for(int i=0; i<test; i++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] candy = new int[N];

            st = new StringTokenizer(in.readLine());
            int idx = 0;
            while(st.hasMoreTokens()){
                candy[idx++] = Integer.parseInt(st.nextToken());
            }

            int man = 0;
            for(int j=0; j<N; j++){
                man += candy[j]/K;
            }
            out.write(man+"\n");
        }
        out.flush();
        out.close();
        in.close();
    }
}
