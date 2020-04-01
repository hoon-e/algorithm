package sort;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class N10841 {
    static class Student {
        int age;
        String name;
        int count;

        Student(int age, String name, int count) {
            this.age = age;
            this.name = name;
            this.count = count;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        ArrayList<Student> p = new ArrayList<>();

        int i=1;
        while(num-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            p.add(new Student(Integer.parseInt(st.nextToken()), st.nextToken(), i));
            i++;
        }

        Comparator<Student> sSort = ( (p1, p2) -> {
            if( p1.age == p2.age )
                return p1.count - p2.count;
            else
                return p1.age - p2.age;
        });

        p.sort(sSort);

        for(Student s : p){
            bw.write(s.age + " " + s.name + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
