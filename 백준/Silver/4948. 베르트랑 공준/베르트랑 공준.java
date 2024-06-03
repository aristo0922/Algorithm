import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int MAX = 123_456;
    static int[] numTable = new int[2 * MAX + 2];

    static {
        numTable[1] = 1;
        int num;
        int multiply;
        for (int i = 2; i <= MAX; i++) {
            num = i;
            multiply=2;
            while (num * multiply <= 2 * MAX) {
                numTable[num*multiply] = 1;
                multiply++;
            }
        }
    }

    public static void count(int num){
        int n = num;
        int count=0;
        while(n <= 2*MAX && n <= 2*num){
            try{
                if(numTable[n++] != 1 && n-1 != num){
                    count++;
                }
            }catch (Exception e){
                System.out.println(2*MAX);
                System.out.println(n);
                return;
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int command;
        command = Integer.parseInt(br.readLine());
        while(command !=0){
            count(command);
            command = Integer.parseInt(br.readLine());
        }
    }
}
