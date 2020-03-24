package greedy;

import java.io.*;
import java.util.Arrays;

public class N2217 {
    static int[] lope;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        lope = new int[n];
        for(int i=0; i<n; i++)
            lope[i] = Integer.parseInt(br.readLine());
        Arrays.sort(lope);
        int ans = 0;
        for(int i=1; i<=n; i++)
            ans = Math.max(ans, lope[n-i]*i);
        bw.write(ans+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
