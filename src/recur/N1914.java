package recur;

import java.io.*;
import java.math.BigInteger;

// BigInteger 사용하는 문제
public class N1914 {
    static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        int num=Integer.parseInt(br.readLine());
        BigInteger ans = new BigInteger("2");
        // 하노이의 탑을 옮기는 횟수는 2^NUM - 1회 이다.
        BigInteger c = ans.pow(num).subtract(BigInteger.ONE);
        if(num > 20) {
            bw.write(c + "\n");
            bw.flush();
            return;
        }
        else{
            bw.write(((1<<num)-1)+"\n");
            hanoi(1, 3, num);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void hanoi(int a, int b, int n){
        if(n==1){
            sb.append(a).append(" ").append(b).append("\n");
            return;
        }
        int c = 6-a-b;
        hanoi(a,c,n-1);
        sb.append(a).append(" ").append(b).append("\n");
        hanoi(c,b,n-1);
    }
}
