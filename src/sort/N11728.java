package sort;

import java.io.*;
import java.util.StringTokenizer;

public class N11728 {
    static int[] a;
    static int[] b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        a = new int[A];
        b = new int[B];

        st = new StringTokenizer(br.readLine());
        int i=0;
        while(st.hasMoreTokens()){
            a[i++] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int j=0;
        while(st.hasMoreTokens()){
            b[j++] = Integer.parseInt(st.nextToken());
        }

        int[] c = new int[A+B];
        int index_a = 0;
        int index_b = 0;
        int index_c = 0;

        while( index_a < A && index_b < B ){
            if(a[index_a] < b[index_b])
                c[index_c++] = a[index_a++];
            else
                c[index_c++] = b[index_b++];
        }

        while(index_a < A)
            c[index_c++] = a[index_a++];
        while(index_b < B)
            c[index_c++] = b[index_b++];

        for(int w : c)
            bw.write(w + " ");
        bw.flush();
        bw.close();
        br.close();
    }
}
