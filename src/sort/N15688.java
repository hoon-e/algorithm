package sort;

import java.io.*;

public class N15688 {
    static int[] number = new int[2000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        while(num-- >0){
            int idx = Integer.parseInt(br.readLine());
            number[1000000-idx]++;
        }

        for(int i=-1000000; i<=1000000; i++){
            while(number[1000000-i] > 0){
                bw.write(i+"\n");
                number[1000000-i]--;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
