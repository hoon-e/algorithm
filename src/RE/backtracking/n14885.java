package RE.backtracking;

import java.util.*;
import java.io.*;

public class n14885 {
    static long max = -1000000000;
    static long min = 1000000000;
    static long[] number;
    static int[] op;
    static int n;
    static boolean[] chk;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        number = new long[n];
        chk = new boolean[n];
        op = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++)
            number[i] = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        makeExp(1, number[0]);

        bw.write(max + "\n" + min);
        bw.flush();
    }

    private static void makeExp(int cnt, long val) {
        if(cnt == n) {
            max = (max < val) ? val : max;
            min = (min > val) ? val : min;
            return;
        }

        for(int j=0; j<4; j++) {
            if(op[j] > 0) {
                op[j]--;

                switch (j) {
                    case 0:
                        makeExp(cnt+1, val+number[cnt]);
                        break;
                    case 1:
                        makeExp(cnt+1, val-number[cnt]);
                        break;
                    case 2:
                        makeExp(cnt+1, val*number[cnt]);
                        break;
                    case 3:
                        makeExp(cnt+1, val/number[cnt]);
                        break;
                }

                op[j]++;
            }
        }
    }
}
