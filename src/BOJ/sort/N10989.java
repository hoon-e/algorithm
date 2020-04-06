package BOJ.sort;

import java.io.*;
import java.util.Vector;

/**
 * int범위인 65536 진수로 radix sort를 이용하여 구하는 방법
 */
public class N10989 {
    static int[] count = new int[10000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        for(int i=0; i<num; i++) {
            count[i] = Integer.parseInt(br.readLine());
            count[i] += 1000000;
        }

        Vector<Integer>[] b = new Vector[65536];

        for(int i=0; i<65536; i++)
            b[i] = new Vector<>();

        for(int i=0; i<num; i++)
            b[count[i]&65535].add(count[i]);

        int index = 0;
        for(int i=0; i<65536; i++){
            for(int s : b[i])
                count[index++] = s;
            b[i].clear();
        }

        for(int i=0; i<num; i++)
            b[count[i] >> 16].add(count[i]);

        index = 0;

        for(int i=0; i<65536; i++){
            for(int s: b[i])
                count[index++] = s;
        }

        for(int i=0; i<num; i++)
            bw.write((count[i]-1000000)+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
