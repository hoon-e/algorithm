package BOJ.sort;

import java.io.*;
import java.util.*;

public class N1599 {
    static void yeongsik(){
        alphabet.put('a', 1);
        alphabet.put('b', 2);
        alphabet.put('k', 3);
        alphabet.put('d', 4);
        alphabet.put('e', 5);
        alphabet.put('g', 6);
        alphabet.put('h', 7);
        alphabet.put('i', 8);
        alphabet.put('l', 9);
        alphabet.put('m', 10);
        alphabet.put('n', 11);
        alphabet.put('x', 12);
        alphabet.put('o', 13);
        alphabet.put('p', 14);
        alphabet.put('r', 15);
        alphabet.put('s', 16);
        alphabet.put('t', 17);
        alphabet.put('u', 18);
        alphabet.put('w', 19);
        alphabet.put('y', 20);
    }

    static Map<Character, Integer> alphabet = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(in.readLine());
        String[] line = new String[num];
        yeongsik();

        for(int i=0; i<num; i++){
            line[i] = in.readLine();
        }

        int idx=0;
        for(String s : line) {
            line[idx++] = s.replace("ng", "x");
        }

        Arrays.sort(line, (l1, l2) -> {
            if(l1.length() > l2.length()){
                for(int i=0; i<l2.length(); i++){
                    if(alphabet.get(l1.charAt(i)) > alphabet.get(l2.charAt(i))) {
                        return 1;
                    }
                    else if(alphabet.get(l1.charAt(i)) < alphabet.get(l2.charAt(i))) {
                        return -1;
                    }
                }
            }else if(l1.length() < l2.length()){
                for(int i=0; i<l1.length(); i++){
                    if(alphabet.get(l1.charAt(i)) > alphabet.get(l2.charAt(i))) {
                        return 1;
                    }
                    else if(alphabet.get(l1.charAt(i)) < alphabet.get(l2.charAt(i))) {
                        return -1;
                    }
                }
            }else{
                for(int i=0; i<l2.length(); i++){
                    if(alphabet.get(l1.charAt(i)) > alphabet.get(l2.charAt(i)))
                        return 1;
                    else if(alphabet.get(l1.charAt(i)) < alphabet.get(l2.charAt(i)))
                        return -1;
                }
                return 0;
            }
            return l1.length() - l2.length();
        });

        for(String s : line) {
            s = s.replace("x", "ng");
            out.write(s + "\n");
        }

        out.flush();
        in.close();
        out.close();
    }
}
