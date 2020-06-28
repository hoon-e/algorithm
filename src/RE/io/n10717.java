package RE.io;

import java.io.*;

public class n10717 {
    public static void main( String[] args ) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        sb.append("\\    /\\").append("\n")
                .append(" )  ( ')").append("\n")
                .append("(  /  )").append("\n")
                .append(" \\(__)|");
        out.write(sb.toString());
        out.flush();
        out.close();
    }
}
