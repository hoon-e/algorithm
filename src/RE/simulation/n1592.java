package RE.simulation;

import java.util.*;
import java.io.*;

public class n1592 {
    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);

        int N = scn.nextInt();
        int M = scn.nextInt();
        int L = scn.nextInt();

        int idx = 1;
        int[] ball = new int[N+1];

        ++ball[idx];
        long cnt = 0;

        while(ball[idx] != M) {
            ++cnt;
            idx = (ball[idx] % 2 == 0) ? idx + L : idx - L;

            if(idx <= 0) idx += N;
            else if(idx > N) idx -= N;
            ++ball[idx];
        }

        System.out.println(cnt);
    }
}
