import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] result;
    static boolean[] isVisited;
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();

    static void searchParent(int root){
        ArrayList<Integer> related = tree.get(root);
        isVisited[root]= true;
        for(int node : related){
            if(isVisited[node]) continue;
            result[node] = root;
            searchParent(node);
        }
    }
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        result = new int[N+1];
        isVisited = new boolean[N+1];

        for (int i = 0; i < N + 1; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < N-1; i++) {
            String[] arr = br.readLine().split(" ");
            tree.get(Integer.parseInt(arr[0])).add(Integer.parseInt(arr[1]));
            tree.get(Integer.parseInt(arr[1])).add(Integer.parseInt(arr[0]));
        }
        searchParent(1);

        StringBuilder sb= new StringBuilder();
        for(int i = 2;i<N+1;i++){
            sb.append(result[i]).append('\n');
        }

        System.out.println(sb);
    }
}
