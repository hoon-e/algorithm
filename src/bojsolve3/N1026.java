package bojsolve3;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class N1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int[] a = new int[num];
        int[] b = new int[num];
        int sum=0;

        int j=0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            a[j++] = Integer.parseInt(st.nextToken());
        }
        j=0;
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            b[j++] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        Arrays.sort(b);

        // 내림차순
        // 배열은 Generic 형태여야 한다.
        // Arrays.sort(a, Collections.reverseOrder());
        for(int i=0; i<num; i++){
            sum += a[i]*b[num-i-1];
        }

        bw.write(sum+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
