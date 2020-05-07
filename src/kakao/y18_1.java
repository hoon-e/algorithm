package kakao;

import java.io.*;
import java.util.*;

public class y18_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] record = {"Enter uid1234 Muzi", "Leave uid1234", "Change uid1234 Prodo", "Enter uid2345 Con", "Change uid2345 Roi"};
        String[] ans = solution(record);

        for(String a : ans)
            System.out.println(a);
    }

    public static String[] solution(String[] record){
        List<String> ansList = new ArrayList<>();
        // id와 이름을 받기 위해 HashMap 사용
        Map<String, String> ids = new HashMap<String, String>();

        // Enter, Leave, Change
        for(String str : record){
            StringTokenizer tkn = new StringTokenizer(str);
            String event = tkn.nextToken();

            // Enter이거나 Change일 경우
            if(event.equals("Enter") || event.equals("Change")){
                String id = tkn.nextToken();
                String name = tkn.nextToken();
                // 동일한 id 값이면 value의 값이 수정된다. 최초라면 추가된다.
                ids.put(id, name);
            }
        }

        for(String str : record){
            StringTokenizer token = new StringTokenizer(str);
            String event = token.nextToken();

            if(event.equals("Enter")){
                String id = token.nextToken();
                ansList.add(ids.get(id) + "님이 들어왔습니다.");
                // answer[idx++] = ids.get(id) + "님이 들어왔습니다.");
            }else if(event.equals("Leave")){
                String id = token.nextToken();
                ansList.add(ids.get(id) + "님이 나갔습니다.");
            }
        }

        String[] answer = new String[ansList.size()];
        ansList.toArray(answer);

        return answer;
    }
}
