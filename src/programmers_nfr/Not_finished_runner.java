package programmers_nfr;

// Set은 중복값 사용이 불가능해서 HashMap 사용하기
import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion)  {
        // 참가자를 저장할 HashMap 생성 (이름, 등장 욋수)
       HashMap<String, Integer> map = new HashMap<>();
       
       // 참가자 추가 (동명이인 고려하여 개수 증가)
        for (String p : participant) {
            map.put(p,map.getOrDefault(p, 0) + 1);
        }

        // 저장된 참가자를 출력
        System.out.println("참가자 명단: " + map);
        
        // 완주한 선수 제거 (이름 등장 횟수 감소)
        for (String c: completion) {
        	map.put(c, map.get(c)-1);
        }
        // 완주 후 남아 있는 사람 출력 (값이 0이 아닌 사함 찾기)
        System.out.println("완주 후 남아 있는 명단: " + map);
        
        // 남은 선수가 완주하지 못한 선수
        for (String key : map.keySet()) {
        	if (map.get(key) != 0) {
        		return key;
        	}
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