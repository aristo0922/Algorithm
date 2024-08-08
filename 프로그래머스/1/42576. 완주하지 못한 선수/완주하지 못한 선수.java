import java.util.*;

class Solution {
    static Map<String, Integer> participants = new HashMap<>();
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        init(participant);
        endGame(completion);
        
        for(String name: participant){
            if(participants.get(name) > 0){
                answer = name;
                break;
            }
        }
        return answer;
    }
    public void endGame(String[] completion){
        for(String name: completion){
            int value = participants.get(name);
            participants.put(name, value-1);
        }
    }
    
    
    public void init(String[] participant){
        for(String name: participant){
            if(participants.containsKey(name)){
                int n = participants.get(name);
                participants.put(name, n+1);
                continue;
            }
            participants.put(name, 1);
        }
    }
}