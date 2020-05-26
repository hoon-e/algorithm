package Geeks;

import java.io.*;

public class GCD {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        long ans = gcd(120, 3);
        System.out.println(ans);
    }

    static long gcd(long a, long b){
        if(b == 0) return a;
        return gcd(b, a%b);
    }
}
