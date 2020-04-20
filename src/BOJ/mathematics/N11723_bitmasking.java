package BOJ.mathematics;

import java.io.*;
import java.util.StringTokenizer;

public class N11723_bitmasking {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
        집합 문제를 비트마스킹을 이용해서 풀수 있다.
        비트 연산은 속도가 매우 빠르므로 진수 사용시 비트마스킹을 사용하면 빠르게 할 수 있다.
         */

        // 초기값을 설정해준다.
        int set = 0;
        int test = Integer.parseInt(br.readLine());
        int num = 0;

        for(int i=0; i<test; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch(st.nextToken()){
                case "add":
                    num = Integer.parseInt(st.nextToken());
                    set |= (1<<num); // 추가는 num만큼 떨어진 곳에 추가한다.
                    break;
                case "remove":
                    num = Integer.parseInt(st.nextToken());
                    set &= ~(1<<num); // 삭제는 num만큼 떨어진 곳에 not 연산 후 &연산 진행한다.
                    break;
                case "check":
                    num = Integer.parseInt(st.nextToken());
                    if( (set&(1<<num)) > 0) // 비트연산 한 값이 1이 있을 경우엔 무조건 0보단 크다.
                        bw.write(1+"\n");
                    else
                        bw.write(0+"\n");
                    break;
                case "toggle":
                    num = Integer.parseInt(st.nextToken());
                    set ^= (1<<num);
                    break;
                case "all":
                    set = (1<<21) - 1;
                    break;
                case "empty":
                    set = 0;
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
