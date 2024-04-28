import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean flag = false;
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String[] node = br.readLine().split(" ");
            if(node[0].equals("ChongChong") || node[1].equals("ChongChong")){
                flag=true;
                set.add(node[0]);
                set.add(node[1]);
                continue;
            }
            if(flag == true){
                if(set.contains(node[0])){
                    set.add(node[1]);
                    continue;
                }
                if(set.contains(node[1])){
                    set.add(node[0]);
                }
            }
        }
        System.out.println(set.size());

    }
}
