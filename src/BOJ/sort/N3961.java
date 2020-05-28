package BOJ.sort;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class N3961 {
    static class recommend {
        String word;
        int dist;

        recommend(String word, int dist){
            this.word = word;
            this.dist = dist;
        }
    }

    static void addKeyboard(){
        // 위
        keyboards.put('q', new Point(0,0));
        keyboards.put('w', new Point(0,1));
        keyboards.put('e', new Point(0,2));
        keyboards.put('r', new Point(0,3));
        keyboards.put('t', new Point(0,4));
        keyboards.put('y', new Point(0,5));
        keyboards.put('u', new Point(0,6));
        keyboards.put('i', new Point(0,7));
        keyboards.put('o', new Point(0,8));
        keyboards.put('p', new Point(0,9));
        // 중간
        keyboards.put('a', new Point(1,0));
        keyboards.put('s', new Point(1,1));
        keyboards.put('d', new Point(1,2));
        keyboards.put('f', new Point(1,3));
        keyboards.put('g', new Point(1,4));
        keyboards.put('h', new Point(1,5));
        keyboards.put('j', new Point(1,6));
        keyboards.put('k', new Point(1,7));
        keyboards.put('l', new Point(1,8));
        // 아래
        keyboards.put('z', new Point(2,0));
        keyboards.put('x', new Point(2,1));
        keyboards.put('c', new Point(2,2));
        keyboards.put('v', new Point(2,3));
        keyboards.put('b', new Point(2,4));
        keyboards.put('n', new Point(2,5));
        keyboards.put('m', new Point(2,6));
    }

    static int getDist(String word, String target){
        int dist = 0;
        for(int i=0; i<word.length(); i++){
            if(word.charAt(i) != target.charAt(i)){
                Point a = keyboards.get(word.charAt(i));
                Point b = keyboards.get(target.charAt(i));

                dist += (Math.abs(a.x-b.x) + Math.abs(a.y-b.y));
            }
        }
        return dist;
    }

    static HashMap<Character, Point> keyboards;
    static List<recommend> wordList;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        keyboards = new HashMap<>();
        addKeyboard();

        int t = Integer.parseInt(in.readLine());

        for(int i=0; i<t; i++){
            st = new StringTokenizer(in.readLine());
            wordList = new ArrayList<>();

            String word = st.nextToken();
            int n = Integer.parseInt(st.nextToken());

            for(int j=0; j<n; j++){
                String target = in.readLine();
                int dist = getDist(word, target);
                wordList.add(new recommend(target, dist));
            }

            wordList.sort((w1, w2) -> {
                if(w1.dist < w2.dist)
                    return -1;
                else if(w1.dist == w2.dist){
                    return w1.word.compareTo(w2.word);
                }else
                    return 1;
            });

            for(recommend r : wordList)
                out.write(r.word + " " + r.dist + "\n");
        }

        out.flush();
        in.close();
        out.close();
    }
}
