import java.util.*;

class Truck{
    int weight;
    int time;
    Truck(int w, int t){
        this.weight = w;
        this.time = t;
    }
    int addTime(){
        return this.time +=1;
    }
}
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Deque<Truck> bridge = new ArrayDeque<>();
        int total = 0, index = 0;
        int SIZE = truck_weights.length;

        while (true) {
            if (index >= SIZE) {
                if (bridge.size() <= 0) {
                    answer +=1;
                    break;
                }
            }
            if (index < SIZE) {
                if ((total + truck_weights[index]) <= weight) {
                    bridge.add(new Truck(truck_weights[index], 0));
                    total += truck_weights[index++];
                }
            }
            int bridgeSize = bridge.size();
            for (int i = 0; i < bridgeSize; i++) {
                Truck truck = bridge.pollFirst();
                if (truck.addTime() < bridge_length) {
                    bridge.add(truck);
                    continue;
                }
                total -= truck.weight;
            }
            answer += 1;
        }
        return answer;
    }
}