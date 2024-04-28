import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashSet<String> names = new HashSet<>();
        int result = 0 ;

        for (int i = 0; i < N; i++) {
            String node = br.readLine();
            if(node.equals("ENTER")){
                names = new HashSet<>();
                continue;
            }
            if(names.contains(node)){
                continue;
            }
            names.add(node);
            result++;
        }

        System.out.println(result);
    }
}
