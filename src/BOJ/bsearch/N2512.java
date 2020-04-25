package BOJ.bsearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N2512 {
    static long[] money;
    static long sum;
    static int num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        num = Integer.parseInt(br.readLine());
        money = new long[num];
        long tsum = 0;

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<num; i++) {
            money[i] = Long.parseLong(st.nextToken());
            tsum += money[i];
        }

        Arrays.sort(money);
        sum = Long.parseLong(br.readLine());

        if(tsum <= sum)
            bw.write(money[num-1]+"\n");
        else
            bw.write(binarySearch() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static long binarySearch(){
        long start = 0;
        long end = money[num-1];

        while(start <= end){
            long target = (start+end)/2;
            long temp = solve(target);

            if(temp < sum){
                start = target + 1;
            }else if(temp > sum){
                end = target - 1;
            }else{
                end = target;
                break;
            }
        }

        return end;
    }

    static long solve(long target){
        long ans = 0;
        for(int i=0; i<num; i++){
            if(money[i] <= target){
                ans += money[i];
            }else {
                ans += target;
            }
        }

        return ans;
    }
}
