import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] setArr(int size, String[] args) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(args[i]);
        }
        return arr;

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseNum = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < caseNum; i++) {
            int result = 0;
            String[] arg = br.readLine().split(" ");
            int[] nums = setArr(2, arg);
            arg = br.readLine().split(" ");
            int[] A = setArr(nums[0], arg);
            arg = br.readLine().split(" ");
            int[] B = setArr(nums[1], arg);

            Arrays.sort(A);
            Arrays.sort(B);

            for (int j = 0; j < nums[0]; j++) {
                int left = 0;
                int right = nums[1] - 1;
                int index = -1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (B[mid] < A[j]) {
                        index = mid;
                        left = mid + 1;
                        continue;
                    }
                    right = mid - 1;
                }
                result += index + 1;
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);

    }
}
