package Geeks.graph;

import java.io.*;
import java.util.*;

public class disjointSet {
    static int[] parent = new int[10];
    static int[] rank = new int[parent.length];

    public static void main(String[] args) throws IOException {
        for(int i=0; i<parent.length; i++)
            makeSet(i);

        printSet();
        union(0, 1); printSet();
        union(3, 5); printSet();
        union(0, 3); printSet();
    }

    public static void printSet(){
        System.out.println("index : ");

        for(int i=0; i<parent.length; i++)
            System.out.print(i + " ");

        System.out.println();

        System.out.println("parent : ");

        for(int i=0; i<parent.length; i++)
            System.out.print(parent[i] + " ");

        System.out.println();
        System.out.println();
    }

    public static void makeSet(int x){
        parent[x] = x;
    }

    public static int findSet(int val){
        if(val == parent[val])
            return val;
        else{
            parent[val] = findSet(parent[val]);
            return parent[val];
        }
    }

    public static void union(int x, int y){
        int px = findSet(x);
        int py = findSet(y);

        if(px != py)
            parent[py] = px;
    }
}
