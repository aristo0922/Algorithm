public class Main {
    static int MAX = 10000;
    public static int selfNum(int num){
        int answer = num;
        String[] addNums = String.valueOf(num).split("");

        for (String addNum : addNums){
            answer += Integer.valueOf(addNum);
        }

        return answer;
    }
    public static void main(String[] args){
        int[] answer = new int[MAX+1];
        for(int index=1; index<=MAX; index++){
            int result = selfNum(index);
            if(result <= MAX){
                answer[result]=1;
            }
        }

        for(int index=1; index<=MAX; index++){
            if(answer[index] != 1){
                System.out.println(index);
            }
        }
    }
}
