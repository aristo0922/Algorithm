import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.
public class Main {
    static int N, M;
    static int time = 0;
    static Queue<Integer> process = new LinkedList<>();

    static HashSet<Integer> visited = new HashSet<>();

    public static void calcTime(Queue list) {
        do{
            while(!process.isEmpty()){
                int node = process.poll();
                visited.add(node);
                list = getList(list, node);
            }
            if(list.contains(M)){
                time++;
                return;
            }
            process = list;
            time++;
            list = new LinkedList();
        }while(process.size()>0);
    }

    public static Queue<Integer> getList(Queue list, int node) {
        if(node > 100_000) return list;
        if (!visited.contains(node + 1))
            list.offer(node + 1);

        if (node - 1 >= 0 && !visited.contains(node - 1)) {
            list.offer(node - 1);
        }

        if (!visited.contains(node * 2) && node * 2 != 0)
            list.offer(2 * node);
        return list;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> list = new LinkedList<>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if(N!=M){
            process.add(N);
            visited.add(N);

            calcTime(list);
            System.out.println(time);
        }
        else{
            System.out.println(0);
        }
    }
}
