package RE.dp;
import java.io.*;

public class n5582 {
	static int[][] l;
	static String x, y;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        x = in.readLine().trim();
        y = in.readLine().trim();

        l = new int[x.length()+1][y.length()+1];
        int ans = 0;
        
        for(int i=1; i<=x.length(); i++){
            for(int j=1; j<=y.length(); j++){
                if(x.charAt(i-1) == y.charAt(j-1)) {
            		l[i][j] = l[i-1][j-1] + 1;	
                	ans = Math.max(ans, l[i][j]);
                }
            }
        }
        
        System.out.println(ans);
    }
}
