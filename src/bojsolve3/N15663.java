package bojsolve3;

import org.w3c.dom.Node;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class N15663 {
    static class Num{
        int data;
        int index;

        Num(int data, int index){
            this.data = data;
            this.index = index;
        }
    }

    static int N;
    static int M;
    static int[] dab;
    static StringBuilder sb;
    static Stack<Num> ar;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dab = new int[M];
        Num[] a = new Num[N];
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        int i=0;
        while(st.hasMoreTokens()){
            a[i] = new Num(Integer.parseInt(st.nextToken()), i);
            i++;
        }

        for(int j=0; j<N; j++){
            for(int k=j+1; k<N; k++){
                if(a[j].data > a[k].data){
                    int t = a[k].data;
                    a[k].data = a[j].data;
                    a[j].data = t;
                    int r = a[k].index;
                    a[k].index = a[j].index;
                    a[j].index = r;
                }
            }
        }
        ar = new Stack<>();
        find(a, 0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void find(Num[] a, int num){
        if(num == M){
            for(int i=0; i<M; i++){
                sb.append(dab[i]).append(" ");
            }
            sb.append("\n");
            ar.clear();
            return;
        }
        
        for(int i=0; i<N; i++){
            dab[num] = a[i].data;
            ar.add(a[i]);
            find(a, num+1);
        }
    }
}
