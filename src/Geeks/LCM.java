package Geeks;

import java.io.*;

public class LCM {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        long ans = lcm(3, 4);
        System.out.println(ans);
    }

    static long gcd(long a, long b){
        if(b == 0) return a;
        return gcd(b, a%b);
    }

    static long lcm(long a, long b){
        if( a == 0 || b == 0 ) return 0;
        return (a * b) / gcd(a, b);
    }
}
