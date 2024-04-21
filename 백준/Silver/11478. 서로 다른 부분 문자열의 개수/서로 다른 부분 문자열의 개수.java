import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String cmd = br.readLine();
        HashSet<String> set = new HashSet<>();
        int len = cmd.length();

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                sb.append(cmd.charAt(j));
                if(!set.contains(sb.toString())){
                    set.add(sb.toString());
                }
            }
            sb = new StringBuffer();
        }

        System.out.println(set.size());
    }
}
