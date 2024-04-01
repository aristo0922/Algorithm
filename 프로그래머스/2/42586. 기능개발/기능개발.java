import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Deque<Integer> queue = new ArrayDeque<>();
        Deque<Integer> queueS = new ArrayDeque<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0 ; i<progresses.length ; i++){
            queue.add(progresses[i]);
            queueS.add(speeds[i]);
        }
        int index=0;
        boolean flag=false;
        while(queue.size() > 0){
            int SIZE = queue.size() ;
            int count = 0;
            for(int i = 0; i < SIZE ; i++){
                int speed = queueS.pollFirst();
                int node = queue.pollFirst()+speed;
                if(i == 0 && node >= 100){
                    count +=1;
                    flag=true;
                    continue;
                }
                if(node >= 100 && flag==true){
                    count +=1;
                    continue;
                }
                queue.add(node);
                queueS.add(speed);
                flag=false;
            }
            if(count > 0){
                result.add(count);         
            }
        }
        
        int[] answer = new int [result.size()];
        for(int i=0;i<result.size();i++){
            answer[i]= result.get(i);
        }
        
        return answer;
    }
}