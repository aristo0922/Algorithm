import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] nums = new int[size];
        String[] numStr = br.readLine().split(" ");
        int answer = 0;

        for(int i=0;i<size;i++){
            nums[i] = Integer.parseInt(numStr[i]);
        }
        Arrays.sort(nums);

        int left = 0, right = size-1;
        int target = Integer.parseInt(br.readLine());

        while(left < right){
            if(nums[left] + nums[right] > target){
                right--;
                continue;
            }
            if(nums[left]+nums[right] < target){
                left++;
                continue;
            }
            answer +=1;
            left++;
        }
        System.out.println(answer);
    }
}
