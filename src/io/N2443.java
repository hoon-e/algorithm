package io;

import java.io.*;

public class N2443 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int line = Integer.parseInt(br.readLine());

        for(int i=line; i>0; i--){
            for(int j=0; j<line-i; j++)
                bw.write(" ");
            for(int j=0; j<2*i-1; j++)
                bw.write("*");
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
