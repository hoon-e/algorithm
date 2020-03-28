package backtracking;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 최소 한개의 모음, 최소 두개의 자음
public class N1759 {
    static int L;
    static int C;
    static char[] word;
    static char[] dab;
    static boolean[] chk;
    static int vcnt;
    static int ccnt;
    static StringBuffer sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuffer();

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        word = new char[C];
        dab = new char[C];
        chk = new boolean[C];

        st = new StringTokenizer(br.readLine());
        int i=0;
        while(st.hasMoreTokens()){
            word[i++] = st.nextToken().charAt(0);
        }

        Arrays.sort(word);
        findCrypt(0, 0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void findCrypt(int st, int len){
        if(len == L){
            if( vcnt < 1 || ccnt < 2 ){
                return;
            }
            for(int i=0; i<L; i++)
                sb.append(dab[i]);
            sb.append("\n");
            return;
        }

        for(int i=st; i<C; i++){
            if(!chk[i]){
                dab[len] = word[i];
                if(dab[len] == 'a' || dab[len] == 'e' || dab[len] == 'i' || dab[len] == 'o' || dab[len] == 'u')
                    vcnt++;
                else
                    ccnt++;
                chk[len] = true;
                findCrypt(i+1, len+1);
                if(dab[len] == 'a' || dab[len] == 'e' || dab[len] == 'i' || dab[len] == 'o' || dab[len] == 'u')
                    vcnt--;
                else
                    ccnt--;
                chk[len] = false;
            }
        }
    }
}
