package greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N11399 {
    static int[] people = new int[1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int i=0;

        while(st.hasMoreTokens()){
            people[i++] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(people, 0, n);

        int time = 0;
        int sum = 0;
        for(int j=0; j<n; j++){
            time += people[j];
            sum += time;
        }
        bw.write(sum+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
