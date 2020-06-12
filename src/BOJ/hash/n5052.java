package BOJ.hash;

import java.io.*;
import java.util.*;

public class n5052 {
    static class Trie {
        Number[] root;

        Trie(){
            root = new Number[10];
        }

        boolean add(String key){
            int start = key.charAt(0)-'0';

            if(root[start] == null)
                root[start] = new Number();

            Number curNode = root[start];

            for(int i=0; i<key.length(); i++){ // 0부터 하는 이유? : Trie에서 Root는 아무런 정보도 가지지않기 때문이다.
                int next = key.charAt(i)-'0';

                if(curNode.childs[next] == null)
                    curNode.childs[next] = new Number();

                curNode = curNode.childs[next];

                if(curNode.isLast)
                    return false;
            }

            curNode.isLast = true;
            return true;
        }
    }

    static class Number {
        Number[] childs;
        boolean isLast;

        Number(){
            childs = new Number[10];
            isLast = false;
        }
    }

    static int partition(String[] arr, int low, int high){

        String pivot = arr[(low+high)/2];

        while(low < high){
            while((arr[low].compareTo(pivot) < 0) && (low < high)) ++low;
            while((arr[high].compareTo(pivot) > 0) && (low < high)) --high;

            if(low < high){
                String temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
            }
        }
        return low;
    }

    static void quickSort(String[] arr, int low, int high){
        if(low < high){
            int pivot = partition(arr, low, high);

            quickSort(arr, low, pivot-1);
            quickSort(arr, pivot+1, high);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(in.readLine());

        for(int i=0; i<t; i++) {
            int c = Integer.parseInt(in.readLine());
            String[] lines = new String[c];

            Trie trie = new Trie();

            for(int j=0; j<c; j++){
                lines[j] = in.readLine();
            }

            quickSort(lines, 0, c-1);

            boolean flag = true;
            for(int j=0; j<c; j++){
                if(trie.add(lines[j])) continue;
                flag = false;
                break;
            }

            out.write( flag ? "YES\n" : "NO\n" );
        }

        out.flush();
        in.close();
        out.close();
    }
}
