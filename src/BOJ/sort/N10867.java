package BOJ.sort;

import java.io.*;
import java.util.StringTokenizer;

public class N10867 {
    static int[] number = new int[2001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()){
            int idx = Integer.parseInt(st.nextToken());
            number[1000-idx]++;
        }

        for(int i=-1000; i<=1000; i++){
            while(number[1000-i] > 0){
                bw.write(i+" ");
                number[1000-i] = 0;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
