import java.util.*;

class Solution {
    static Map <String, Integer> clothet = new HashMap<String, Integer>();
    
    public int solution(String[][] clothes) {
        int answer = 1;
        init(clothes);
        
        String[] keys = clothet.keySet().toArray(new String[0]);
        
        for(String name: keys){
            answer *= clothet.get(name);
        }
        return answer-1;
    }
    
    public static void init(String[][] clothes){
        for(String[] set : clothes){
            clothet.put(set[1], clothet.getOrDefault(set[1], 1)+1);
        }
    }
}