package BOJ.Stack_Queue;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class N2841 {
    static int N;
    static int P;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        Stack<Integer>[] guitar = new Stack[7];

        for(int i=0; i<7; i++)
            guitar[i] = new Stack<>();

        int cnt=0;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            if(guitar[m].isEmpty()){
                guitar[m].push(n);
                cnt++;
            }else{
                if(guitar[m].peek() < n){
                    guitar[m].push(n);
                    cnt++;
                }else if(guitar[m].peek() == n) {
                    continue;
                }else if(guitar[m].peek() > n){
                    while(!guitar[m].isEmpty() && guitar[m].peek() > n){
                        guitar[m].pop();
                        cnt++;
                    }

                    if(!guitar[m].isEmpty()){
                        if(guitar[m].peek() < n){
                            guitar[m].push(n);
                            cnt++;
                        }
                    }else{
                        guitar[m].push(n);
                        cnt++;
                    }
                }
            }
        }

        bw.write(cnt+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
