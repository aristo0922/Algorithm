import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        HashSet<Integer> arrA = new HashSet<>();
        for(int i =0; i < A ; i++){
            arrA.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        int result = 0 ;
        HashSet<Integer> arrB = new HashSet<>();
        for(int i =0; i < B ; i++){
            int node = Integer.parseInt(st.nextToken());
            arrB.add(node);
            if(arrA.contains(node)){
                continue;
            }
            result++;
        }
        
        for(int node : arrA){
            if(arrB.contains(node)){
                continue;
            }
            result++;
        }

        System.out.println(result);
    }
}
