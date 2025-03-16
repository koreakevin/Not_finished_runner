package programmers_nfr;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public String solution(String[] participant, String[] completion)  {
        // 참가자를 저장
        Set<String> set = new HashSet<>();

        for (String p : participant) {
            set.add(p);
        }

        // 저장된 참가자를 출력
        System.out.println("참가자 명단: " + set);
        
        // 완주한 선수 제거
        for (String c : completion) {
            set.remove(c);
        }

        // 완주 후 남아 있는 사람 출력
        System.out.println("완주 후 남은 명단: " + set);
        
       // 남은 선수가 완주하지 못한 선수
        for (String p : set) {
            return p; // 남아 있는 사람이 완주하지 못한 사람
        }

        return ""; // 예외처리
    }
}

//실행 테스트를 위해서 필요한 부분(프로그래머스 정답에는 입력할 필요없음)
public class Not_finished_runner {

    public static void main(String[] args) {
        Solution sol = new Solution(); // Solution 객체 생성
        
        // 테스트 데이터
        String[] participant1 = {"leo", "kiki", "eden"};
        String[] completion1 = {"eden", "kiki"};
        
        String[] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion2 = {"josipa", "filipa", "marina", "nikola"};
        
        String[] participant3 = {"mislav", "stanko", "mislav", "ana"};
        String[] completion3 = {"stanko", "ana", "mislav"};

        // 실행 및 결과 출력
        System.out.println("결과: " + sol.solution(participant1, completion1));
        System.out.println("결과: " + sol.solution(participant2, completion2));
        System.out.println("결과: " + sol.solution(participant3, completion3));
    }
}