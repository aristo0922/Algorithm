import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> arr = new ArrayList<>();

        String[] command = br.readLine().split(" ");
        int size = Integer.parseInt(command[0]);
        int questions = Integer.parseInt(command[1]);

        for(int i=0;i<size;i++){
            String node = br.readLine();
            map.put(node, i+1);
            arr.add(node);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<questions;i++){
            String cmd = br.readLine();

            try{
                int index = Integer.parseInt(cmd);
                sb.append(arr.get(index-1)).append("\n");

            }catch (Exception e){
                sb.append(map.get(cmd)).append("\n");
            }
        }

        System.out.println(sb);
    }
}
