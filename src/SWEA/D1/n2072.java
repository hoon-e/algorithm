package SWEA.D1;

import java.io.*;
import java.util.*;

public class n2072 {
    public static void main( String[] args ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(in.readLine());
        int[] number = new int[10];

        for(int i=0; i<tc; i++){
            st = new StringTokenizer(in.readLine());

            int idx = 0;
            while(st.hasMoreTokens())
                number[idx++] = Integer.parseInt(st.nextToken());

            int sum = 0;
            for(int j=0; j<10; j++){
                if(number[j] % 2 == 1)
                    sum += number[j];
            }

            out.write("#" + (i+1) + " " + sum + "\n");
        }
        out.flush();
        in.close();
        out.close();
    }
}
