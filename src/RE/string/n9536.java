package RE.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class n9536 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=T; tc++) {
			String[] animal = br.readLine().split(" ");
			HashMap<String, String> cry = new HashMap<>();
			
			String line = "";
			while(!(line = br.readLine()).equals("what does the fox say?")) {
				String[] tmp = line.split(" ");
				cry.put(tmp[2], tmp[0]);
			}
			
			for(String a : animal) {
				if(cry.get(a) == null) 
					sb.append(a).append(" ");
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
