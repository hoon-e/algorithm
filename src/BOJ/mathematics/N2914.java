package BOJ.mathematics;

import java.io.*;
import java.util.*;

public class N2914 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(in.readLine());
        int A = Integer.parseInt(st.nextToken());
        int I = Integer.parseInt(st.nextToken());

        out.write(A*(I-1)+1);
        out.flush();
        out.close();
        in.close();
    }
}
