package BOJ.hash;

import java.io.*;

// TODO: 해시테이블 중요
class hTable {
    int hCode2;
    int len;
    hTable next;

    hTable(int hCode2, int len){
        this.hCode2 = hCode2;
        this.len = len;
        next = null;
    }
}

public class N10840 {
    static boolean[] isPrime = new boolean[1001];
    static int[] prime = new int[1001];
    static final int MOD = 1010111;
    static char[] s1;
    static char[] s2;
    static hTable[] hashs = new hTable[MOD];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        s1 = br.readLine().toCharArray();
        s2 = br.readLine().toCharArray();

        toPrime();
        getPrime();
        bw.write(makeTable(s1, s2)+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void makeHash(int hCode1, int hCode2, int len){
        hTable nextNode = new hTable(hCode2, len);

        if(hashs[hCode1] == null)
            hashs[hCode1] = nextNode;
        else{
            nextNode.next = hashs[hCode1];
            hashs[hCode1] = nextNode;
        }
    }

    static boolean isSame(int hCode1, int hCode2, int len){
        if(hashs[hCode1] == null) return false;
        else{
            hTable cur = hashs[hCode1];

            while(cur != null){
                if(cur.len == len && cur.hCode2 == hCode2) return true;
                cur = cur.next;
            }
        }
        return false;
    }

    static int makeTable(char[] s1, char[] s2){
        int x, y;
        int MAX = 0;

        for(int i=0; i<s1.length; i++){
            x=1; y=1;
            for(int j=i; j<s1.length; j++){
                x = (x*prime[(s1[j]-'a')]) % MOD;
                y = (y*prime[(s1[j]-'a')+119]) % MOD;
                makeHash(x, y, j-i+1);
            }
        }

        for(int i=0; i<s2.length; i++){
            x=1; y=1;
            for(int j=i; j<s2.length; j++){
                x = (x*prime[(s2[j]-'a')]) % MOD;
                y = (y*prime[(s2[j]-'a')+119]) % MOD;
                if(isSame(x, y, j-i+1)){
                    MAX = Math.max(MAX, j-i+1);
                }
            }
        }

        return MAX;
    }

    static void toPrime(){
        for(int i=2; i<=1000; i++){
            for(int j=2; i*j <=1000; j++){
                isPrime[i*j] = true;
            }
        }
    }

    static void getPrime(){
        int idx = 0;
        for(int i=2; i<=1000; i++){
            if(!isPrime[i]){
                prime[idx++] = i;
            }
        }
    }
}
