package bojsolve3;

import java.io.*;
import java.util.StringTokenizer;

public class N1074_another {
    static int r;
    static int c;
    static int count =0;

    public static int visit(int size, int x, int y){
        int half = size/2;
        if( x == r && y == c ) return count;
        else if( r < half && c < half ){
            count -= (half)*(half)*3;
        }else if( r < half && c >= half ){
            count -= (half)*(half)*2;
        }else if( r >= half && c < half ){
            count -= (half)*(half);
        }

        if( r >= half )
            r -= half;
        if( c >= half )
            c -= half;
        return visit(half, x/2, y/2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int size = (1<<N);
        count = size*size-1;
        visit(size, size-1, size-1);
        bw.write(count+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
