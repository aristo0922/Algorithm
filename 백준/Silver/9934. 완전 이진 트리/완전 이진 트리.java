import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<ArrayList<String>> tree;
    static String[] arr;
    static int T;
    static void search(int start, int end, int depth){
        if(depth == T) return;
        if(end < 0) return;
        int mid = (start+end)/2;
        tree.get(depth).add(arr[mid]);

        search(start, mid-1, depth+1);
        search(mid+1, end, depth+1);

    }

    public static void main(String[] args)throws Exception{
        T = Integer.parseInt(br.readLine());

        arr = br.readLine().split(" ");
        int total = arr.length -1;

        tree = new ArrayList<>();
        for(int i = 0 ; i<T; i++){
            tree.add(new ArrayList<>());
        }

        search(1, total, 0);

        StringBuilder sb = new StringBuilder();
        for(ArrayList<String> list : tree){
            for(String node : list){
                sb.append(node).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
