package BOJ.io;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N2752 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] num = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int i=0;
        while(st.hasMoreTokens()){
            num[i++] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        for(int s: num)
            bw.write(s + " ");
        bw.flush();
        bw.close();
        br.close();
    }
}
