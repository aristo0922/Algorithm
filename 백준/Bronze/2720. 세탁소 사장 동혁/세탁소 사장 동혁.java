import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int Quarter = 25;
    static int Dime = 10;
    static int Nickel = 5;
    static int Penny = 1;
    static int[] coins = {Quarter, Dime, Nickel, Penny};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {
            printAnswer(Integer.parseInt(br.readLine()));
        }
    }

    public static void printAnswer(int n) {
        int charge = n;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            int num = charge / coins[i];
            charge = charge % coins[i];
            sb.append(num+" ");
        }

        System.out.println(sb);
    }
}
