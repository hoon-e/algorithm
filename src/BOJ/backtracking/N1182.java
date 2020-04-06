package BOJ.backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class N1182 {
    static int n,s ;
    static int count;
    static int[] chk = new int[20];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int c=0;
        while(st.hasMoreTokens()){
            chk[c++] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<(1<<n); i++){
            int temp = i;
            int sum = 0;
            for(int j=0; j<n; j++){
                if(temp%2 == 1)
                    sum += chk[j];
                temp /= 2;
            }
            if(sum == s)
                count++;
        }
        bw.write(count+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
