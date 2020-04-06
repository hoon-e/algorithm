package BOJ.about_arr;

import java.io.*;
import java.util.StringTokenizer;

public class N13300 {

    static class Student {
        int gender;
        int grade;

        Student(int gender, int grade){
            this.gender = gender;
            this.grade = grade;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] r = new int[2][7];
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Student[] std = new Student[N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            std[i] = new Student(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        int room = 0;

        for(int i=0; i<N; i++){
            if( r[std[i].gender][std[i].grade] == 0 ){
                r[std[i].gender][std[i].grade]++;
                room++;
            }else if( r[std[i].gender][std[i].grade] == K ){
                r[std[i].gender][std[i].grade] = 1;
                room++;
            }else
                r[std[i].gender][std[i].grade]++;
        }

        bw.write(room+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
