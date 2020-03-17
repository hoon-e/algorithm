package sort;

import java.io.*;

public class N2751 {
    static int[] count = new int[2000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        for(int i=0; i<num; i++) {
            int n = Integer.parseInt(br.readLine());
            count[n+1000000]++;
        }

        for(int i=0; i<=2000000; i++){
            while(count[i]-- > 0){
                bw.write((i-1000000) + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
