package kakao;

import java.io.*;
import java.util.*;

public class y19_6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    /*
     * 매칭 점수
     * 기본 점수, 외부 링크 수, 링크 점수, 매칭 점수
     * 기본점수 - 검색어가 등장하는 횟수
     * 외부 링크 수 - 연결된 링크의 개수
     * 링크 점수 - 다른 웹페이지의 기본 점수 / 외부 링크 수 의 총합
     * 매칭 점수 - 기본 점수 + 링크 점수
     */

    static class Page {
        int idx;
        int basic;
        int link;
        double score;

        Page(int idx, int basic, int link, double score){
            this.idx = idx;
            this.basic = basic;
            this.link = link;
            this.score = score;
        }
    }

    // 검색어, 각 페이지의 html 코드가 주어진다.
    public int solution(String word, String[] pages){
        int wordSize = word.length();
        // url, index를 key, value로 하는 Map 생성
        Map<String, Integer> pageMap = new HashMap<>();
        // score 순으로 정렬하면 가능하다. -> 리스트로 생성한다.
        List<Page> pageList = new ArrayList<>();

        // 검색어는 편의상
        word = word.toLowerCase();

        for(int i=0; i<pages.length; i++){
            // 연산의 편의를 위해
            String s = pages[i] =  pages[i].toLowerCase();

            int url = 0, posl = 0, posr = 0;

            // url이 position left보다 작다면, meta 태그 안에 있는 url이 아니다.
            while(url <= posl){
                // 메타 태그의 범위를 저장하는 코드
                posl = s.indexOf("<meta", posl + 1);
                posr = s.indexOf(">", posl);
                url = s.lastIndexOf("https://", posr);
            }

            posr = s.indexOf("\"", url);
            String usedUrl = s.substring(url, posr);

            posl = s.indexOf("<body>", posr);
            int basic = 0;

            // 검색어 갯수를 구하는 함수
            for(int start = posl; ;){
                start = s.indexOf(word, start + 1);
                if(start == - 1) break; // 검색어가 없다.
                if(!Character.isLetter(s.charAt(start-1))&& !Character.isLetter(s.charAt(start+wordSize))){
                    basic++;
                    start += wordSize;
                }
            }

            // link 갯수를 구하는 함수
            int link = 0;
            for(int start = posl; ;){
                // 하이퍼링크 태그를 찾는다.
                start = s.indexOf("<a href", start+1);
                if(start == -1) break;
                link++;
            }

            pageMap.put(usedUrl, i);
            pageList.add(new Page(i, basic, link, (double)basic));
        }

        // 해당 하는 페이지에 링크점수를 더해주는 for문
        for(int i=0; i<pages.length; i++){
            String s = pages[i];
            for(int posl = 0, posr=0; ;){
                posl = s.indexOf("<a href", posr);
                if(posl == -1) break;

                // 하이퍼 링크 안에 있는 https를 찾기
                posl = s.indexOf("https://", posl);
                posr = s.indexOf("\"", posl);

                // 링크 되어있는 url을 찾았다.
                String linkUrl = s.substring(posl, posr);

                // 해당 링크의 페이지가 반환된다.
                Integer pageIdx = pageMap.get(linkUrl);

                // null이 아니라면 참조하고 있다.
                if(pageIdx != null){
                    pageList.get(pageIdx).score += (double)pageList.get(i).basic/pageList.get(i).link;
                }
            }
        }

        pageList.sort(pageSort);

        return pageList.get(0).idx;
    }

    static Comparator<Page> pageSort = new Comparator<Page>(){
        @Override
        public int compare(Page p1, Page p2){
            if(p1.score == p2.score)
                return p1.idx - p2.idx;
            else if(p1.score < p2.score)
                return 1;
            else
                return -1;
        }
    };
}
