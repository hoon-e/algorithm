package BOJ.io;

import java.io.*;
import java.util.Arrays;

public class N2587 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] num = new int[5];
        int sum=0;
        for(int i=0; i<5; i++) {
            num[i] = Integer.parseInt(br.readLine());
            sum += num[i];
        }
        Arrays.sort(num);
        bw.write((sum/5) + "\n" + num[2] );
        bw.flush(); bw.close(); br.close();
    }
}
