package BOJ.bojsolve3;

import java.io.*;

public class N11729 {
    static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        int num=Integer.parseInt(br.readLine());

        bw.write(((1<<num)-1)+"\n");
        hanoi(1, 3, num);
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