public class Main {
    static int MAX = 10000;

    public static int selfNum(int num) {
        int answer = num;

        while(num>0){
            answer += num%10;
            num= num/10;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] answer = new int[MAX + 1];
        for (int index = 1; index <= MAX; index++) {
            int result = selfNum(index);
            if (result <= MAX) {
                answer[result] = 1;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int index = 1; index <= MAX; index++) {
            if (answer[index] != 1) {
                sb.append(index).append('\n');
            }
        }
        System.out.println(sb);
    }
}