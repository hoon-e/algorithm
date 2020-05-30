package BOJ;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.*;
import java.util.*;

public class n12312 {

    static HashMap<String, ArrayList<String>> lists;
    static HashMap<String, Boolean> check;
    static boolean[] chk;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        int answer = solution("hit", "cog", words);
        System.out.println(answer);

        out.flush();
        in.close();
        out.close();
    }

    static int solution(String begin, String target, String[] words) {
        int answer = 0;
        int len = words.length;
        int wordlen = words[0].length();

        lists = new HashMap<String, ArrayList<String>>();
        check = new HashMap<String, Boolean>();

        for(int i=0; i<words.length; i++){
            lists.put(words[i], new ArrayList<String>());
            check.put(words[i], false);
        }

        chk = new boolean[words.length];

        for(int i = 0; i < words.length; i++){
            for(int j = i+1; j < words.length; j++){

                int cnt = 0;

                for(int k = 0; k < words[j].length(); k++){
                    if(words[i].charAt(k) == words[j].charAt(k)){
                        ++cnt;
                    }
                }

                if(cnt == wordlen-1){
                    lists.get(words[i]).add(words[j]);
                    lists.get(words[j]).add(words[i]);
                }
            }
        }

        String start = "";

        for(int i = 0; i < len; i++){
            int cnt = 0;
            for(int j = 0; j < begin.length(); j++){
                if(begin.charAt(j) == words[i].charAt(j)){
                    ++cnt;
                }
            }

            if(cnt == wordlen-1){
                start = words[i];
            }
        }

        System.out.println(start);
        answer = dfs(start, target, 0);

        return answer;
    }

    static int dfs(String word, String target, int time) {
        check.put(word, true);

        if (word.equals(target)) {
            return time;
        }

        ArrayList<String> temp = lists.get(word);

        for (int i = 0; i < temp.size(); i++) {
            if (!check.get(temp.get(i)))
                System.out.println(temp.get(i));
                dfs(temp.get(i), target, time + 1);
        }

        return 0;
    }
}
