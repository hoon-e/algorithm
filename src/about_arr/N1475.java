package about_arr;

import java.io.*;

public class N1475 {
    static int[] set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 0 1 2 3 4 5 6(9) 7 8 9
        // 미리 셋을 하나 쌓는 아이디어
        set = new int[10];

        String line = br.readLine();
        int[] rnum = new int[line.length()];
        int count = 0;

        for(int i=0; i<line.length(); i++)
            rnum[i] = line.charAt(i)-'0';

        for(int s : rnum){
            if(set[s] == 0){
                if(s == 6 && set[9] != 0){
                    set[9]--;
                }else if(s == 9 && set[6] != 0){
                    set[6]--;
                }
                else{
                    for(int i=1; i<10; i++){
                        set[i]++;
                    }
                    count++;
                    set[s]--;
                }
            }else
                set[s]--;
        }
        bw.write(count+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
