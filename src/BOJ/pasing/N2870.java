package BOJ.pasing;

import java.io.*;
import java.util.*;

public class N2870 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(in.readLine());
        char[][] lines = new char[t][];

        List<String> numList = new LinkedList<>();

        for(int i=0; i<t; i++){
            lines[i] = in.readLine().toCharArray();
        }

        for(int i=0; i<t; i++){
            StringBuilder sb = new StringBuilder();

            for(int j=0; j<lines[i].length; j++){
                char word = lines[i][j];

                if(Character.isDigit(word)){
                    if(word == '0'){
                        if(sb.length() != 0){
                            sb.append(word);
                        }else{
                            if(j == lines[i].length - 1)
                                sb.append(word);
                            if(j + 1 < lines[i].length){
                                if(!Character.isDigit(lines[i][j+1]))
                                    sb.append(word);
                            }
                        }
                    }else{
                        sb.append(word);
                    }
                }else{
                    if(sb.length() > 0){
                        numList.add(sb.toString());
                        sb = new StringBuilder();
                    }
                }
            }

            if(sb.length() > 0){
                numList.add(sb.toString());
            }
        }

        numList.sort((n1, n2) -> {
            if(n1.length() < n2.length())
                return -1;
            else if(n1.length() == n2.length()){
                int fin=0;
                for(int i=0; i < n1.length(); i++){
                    if(n1.charAt(i) < n2.charAt(i)) {
                        fin = -1;
                        break;
                    }
                    if(n1.charAt(i) > n2.charAt(i)) {
                        fin = 1;
                        break;
                    }
                }
                return fin;
            }else
                return 1;
        });

        for(String n : numList)
            out.write(n+"\n");

        out.flush();
        out.close();
        in.close();
    }
}
