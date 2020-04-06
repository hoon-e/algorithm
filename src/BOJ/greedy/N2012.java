package BOJ.greedy;

import java.io.*;
import java.util.Arrays;

public class N2012 {
    static int[] std;
    static boolean[] chk = new boolean[500001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        std = new int[num+1];

        int no = 0;

        for(int i=1; i<=num; i++)
            std[i] = Integer.parseInt(br.readLine());

        Arrays.sort(std, 1, num+1);

        for(int i=1; i<=num; i++) {
            no += Math.abs((i-std[i]));
        }
        bw.write(no+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
