import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<List<Integer>> flight;
    static boolean[] isVisited;
    static int answer;

    public static void trip(int contryN, int flightM) throws Exception{
        flight = new ArrayList<>(flightM);
        isVisited = new boolean[contryN+1];
        for(int i=0;i<contryN;i++){
            flight.add(new ArrayList<>());
        }

        for (int i = 0; i < flightM; i++) {
            String[] arr = br.readLine().split(" ");
            int n = Integer.parseInt(arr[0])-1;
            int m = Integer.parseInt(arr[1])-1;

            flight.get(n).add(m);
            flight.get(m).add(n);
        }
        answer = planning(0, -1);
        System.out.println(answer);
    }

    public static int planning(int node, int count){
        isVisited[node]= true;
        count +=1;
        for(int n : flight.get(node)){
            if(isVisited[n] != true){
                count = planning(n, count);
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < T ; i++){
            String[] arr = br.readLine().split(" ");
            trip(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
        }

    }
}