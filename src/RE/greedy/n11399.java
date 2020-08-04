package RE.greedy;

import java.util.*;
import java.io.*;

public class n11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] time = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++)
            time[i] = Long.parseLong(st.nextToken());

        Arrays.sort(time);

        long sum = time[0];
        for(int i=1; i<n; i++)
            sum += (time[i] = (time[i] + time[i - 1]));

        System.out.println(sum);
    }
}
