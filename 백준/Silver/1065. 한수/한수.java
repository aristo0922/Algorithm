import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static boolean getGAP(int num) {
        if (num < 100) return true;
        String[] nums = String.valueOf(num).split("");
        int gap = Integer.valueOf(nums[1]) - Integer.valueOf(nums[0]);
        for (int index = 1; index < nums.length - 1; index++) {
            if (Integer.valueOf(nums[index]) + gap != Integer.valueOf(nums[index + 1])) return false;
        }
        return true;
    }

    final static int MAX = 1000;

    public static void main(String[] args) {
        Scanner N = new Scanner(System.in);
        int n = N.nextInt();
        ArrayList<Integer> nums = new ArrayList<>();
        for (int num = 1; num <= n; num++) {
            if (getGAP(num)) {
                nums.add(num);
            }
        }
        System.out.println(nums.size());
    }
}
