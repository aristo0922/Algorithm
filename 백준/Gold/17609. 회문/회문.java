import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < num; i++) {
            String str = br.readLine();
            StringBuilder sb = new StringBuilder(str);
            if(str.equals(sb.reverse().toString())){
                bw.append('0').append('\n');
                continue;
            }
            int left = 0, right = str.length()-1;
            while(left<right){
                if(str.charAt(left) == str.charAt(right)){
                    left++; right--;
                    continue;
                }
                StringBuilder sbLeft = new StringBuilder(str).deleteCharAt(left);
                StringBuilder sbRight = new StringBuilder(str).deleteCharAt(right);
                if(sbLeft.toString().equals(sbLeft.reverse().toString())
                        || sbRight.toString().equals((sbRight.reverse().toString()))){
                    bw.append('1').append('\n');
                    break;
                }
                bw.append('2').append('\n');
                break;
            }
        }

        bw.flush();
        bw.close();
    }
}