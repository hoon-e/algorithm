package BOJ.backtracking;
import java.io.*;

public class N1339 {
    static int max = Integer.MIN_VALUE;
    static boolean[] chk;
    static boolean[] alpha;
    static char[] word;
    static int[] alphabet;
    static int num;
    static char[][] lines;
    static int cnt;
    static int idx;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        num = Integer.parseInt(br.readLine());
        lines = new char[num][];

        alphabet = new int[26];
        chk = new boolean[10];
        alpha = new boolean[26];
        word = new char[26];

        for(int i=0; i<num; i++) {
            lines[i] = br.readLine().toCharArray();

            for(int j=0; j<lines[i].length; j++){
                if(!alpha[lines[i][j]-'A']){
                    alpha[lines[i][j]-'A'] = true;
                    word[cnt++] = lines[i][j];
                }
            }
        }

        findMax(0);
        bw.write(max+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int pow(int num){
        int result = 1;

        if(num == 0)
            return result;
        else{
            for(int i=0; i < num; i++) {
                result *= 10;
            }
        }
        return result;
    }

    static void findMax(int length){
        if(length == cnt){
            int sum = 0;
            int temp = 0;

            for(char[] a : lines){
                for(int i=0; i<a.length; i++){
                    // Math.pow와 pow함수의 성능차이...?
                    temp += (pow(a.length-i-1) * alphabet[a[i]-'A']);
                }
                sum += temp;
                temp = 0;
            }

            if(sum > max)
                max = sum;

            return;
        }

        for(int i=9; i>=0; i--){
            if(!chk[i]){
                chk[i] = true;
                alphabet[word[idx]-'A'] = i;
                idx++;
                findMax(length+1);
                idx--;
                chk[i] = false;
            }
        }
    }
}
