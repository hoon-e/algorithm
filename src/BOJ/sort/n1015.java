package BOJ.sort;

import java.io.*;
import java.util.*;

public class n1015 {
    static int N;
    static int[] num;
    static int[] temp;
    public static void main( String[] args ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        N = Integer.parseInt(in.readLine());
        st = new StringTokenizer(in.readLine());

        num = new int[N];
        temp = new int[N];

        for(int i=0; i<N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<i; j++){
                if(num[i] < num[j])
                    temp[j]++;
                else
                    temp[i]++;
            }
        }

        for(int i=0; i<N; i++)
            out.write(temp[i] + " ");

        out.flush();
        in.close();
        out.close();
    }
}
