package DP;

import java.io.*;

public class N11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int mod = 10007;
        int[] way = new int[1010];
        way[1] = 1;
        way[2] = 3;

        if(num == 1 || num == 2){
            bw.write(String.valueOf(way[num]));
            bw.flush();
            return;
        }

        for(int i=3; i<=num; i++){
            way[i] = ((way[i-2]%mod)*2 + (way[i-1]%mod)) % mod;
        }
        bw.write(String.valueOf(way[num]));
        bw.flush();
        bw.close();
        br.close();
    }
}
