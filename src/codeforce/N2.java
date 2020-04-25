package codeforce;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class N2 {
    static class Score {
        int idx;
        String lang;
        int score;

        Score(String lang, int idx, int score){
            this.lang = lang;
            this.idx = idx;
            this.score = score;
        }
    }

    static class Std {
        ArrayList<Score> score;

        Std(){
            score = new ArrayList<>();
        }

        void addScore(Score s){
            score.add(s);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] ip_addrs = {"5.5.5.5", "155.123.124.111", "10.16.125.0", "155.123.124.111", "5.5.5.5", "155.123.124.111", "10.16.125.0", "10.16.125.0"};
        String[] langs = {"Java", "C++", "Python3", "C#", "Java", "C", "Python3", "JavaScript"};
        int[] scores = {294, 197, 373, 45, 294, 62, 373, 373};

        System.out.println(solution(ip_addrs, langs, scores) + "\n");
    }

    public static int solution(String[] ip_addrs, String[] langs, int[] scores){

        int answer = 0;

        Std[] std = new Std[ip_addrs.length];
        HashMap<String, Integer> ip = new HashMap<>();

        for(int i=0; i<ip_addrs.length; i++){
            std[i] = new Std();
        }

        for(int i=0; i<ip_addrs.length; i++){
            int v;
            if(!ip.containsKey(ip_addrs[i])){
                ip.put(ip_addrs[i], i);
                v = i;
            }else{
                v = ip.get(ip_addrs[i]);
            }

            std[v].addScore(new Score(langs[i], i, scores[i]));
        }

        for(int i=0; i<ip_addrs.length; i++){
            if(std[i].score.isEmpty()) continue;
            if(std[i].score.size() >= 4){
                answer += 4;
            }
            else if(std[i].score.size() == 2){
                Score s1 = std[i].score.get(0);
                Score s2 = std[i].score.get(1);
                if(s1.lang.equals(s2.lang) && s1.score == s2.score){
                    answer += 2;
                }
            }else if(std[i].score.size() == 3){
                Score s1 = std[i].score.get(0);
                Score s2 = std[i].score.get(1);
                Score s3 = std[i].score.get(1);
                if(s1.lang.equals(s2.lang) && s2.lang.equals(s3.lang)){
                    answer += 3;
                }
            }
        }

        return ip_addrs.length - answer;
    }
}
