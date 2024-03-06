import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static boolean getGAP(int num) {
        if (num < 100) return true;
        if (num == 1000) return false;
        int num1 = num % 10;
        int num2 = (num / 10) % 10;
        int gap = num2 - num1;
        if(num2+gap != num/100) return false;

        return true;
    }

    public static void main(String[] args) {
        Scanner N = new Scanner(System.in);
        int n = N.nextInt();
        ArrayList<Integer> nums = new ArrayList<>();
        for (int index = 1; index <= n; index++) {
            if (getGAP(index)) {
                nums.add(index);
            }
        }
        System.out.println(nums.size());
    }
}
