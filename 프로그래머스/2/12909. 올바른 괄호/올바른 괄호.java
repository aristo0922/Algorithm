import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Deque<Character> queue = new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            char node = s.charAt(i);
            if (node == ')' && queue.size() ==0){
                return false;
            }
            if(node == ')'){
                if(queue.pollLast() == '('){
                    continue;
                }
                return false;
            }
            queue.add(node);
        }
        if(queue.size() > 0){
            return false;
        }

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}