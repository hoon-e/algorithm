package greedy;

import java.io.*;
import java.util.StringTokenizer;

public class N11407 {
    /*
    제일 적게 소모하려면?
    500원을 제일 많이쓰고, 100, 50, 10 순으로
     */

    static int n, k;
    static int[] a = new int[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++)
            a[i] = Integer.parseInt(br.readLine());
        int num = 0;
        for(int i=n-1; i>=0; i--){
            int t = k/a[i];
            num += t;
            k -= t*a[i];
        }
        bw.write(num+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
