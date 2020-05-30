package BOJ.sort;

import java.io.*;
import java.util.*;

public class n10825 {
    static class student {
        String name;
        int kor;
        int eng;
        int math;

        public student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        int many = Integer.parseInt(in.readLine());

        student[] students = new student[many];

        for(int i=0; i<many; i++){
            st = new StringTokenizer(in.readLine());
            students[i] = new student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(students, (s1, s2)->{
            if(s1.kor == s2.kor){
                if(s1.eng == s2.eng) {
                    if(s1.math == s2.math){
                        return s1.name.compareTo(s2.name);
                    }else
                        return s2.math - s1.math;
                }
                else
                    return s1.eng - s2.eng;
            }else
                return s2.kor - s1.kor;
        });

        for(student s : students){
            out.write(s.name+"\n");
        }

        out.flush();
        in.close();
        out.close();
    }
}
