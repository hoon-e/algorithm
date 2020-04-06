package BOJ.sort;

import java.io.*;

public class N11931 {
    static int[] number;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        number = new int[2000001];

        for(int i=0; i<num; i++){
            int w = Integer.parseInt(br.readLine());
            number[w+1000000]++;
        }

        for(int i=2000000; i>=0; i--){
            while(number[i]-- > 0){
                bw.write((i-1000000)+"\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
