package io;

import java.io.*;

public class N2576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] num = new int[7];
        int min = Integer.MAX_VALUE;
        int count=0;
        int sum=0;

        for(int i=0; i<7; i++){
            num[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0; i<7; i++){
            if(num[i]%2 == 1){
                count++;
                sum += num[i];
                if(num[i] < min)
                    min = num[i];
            }
        }

        if(count == 0)
            bw.write(-1+"\n");
        else
            bw.write(sum + "\n" + min);
        bw.flush();
        bw.close();
        br.close();
    }
}
