package sort;

import java.io.*;
import java.util.Arrays;

public class N2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];

        for(int i=0; i<num; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        for(int w : arr)
            bw.write(w+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
