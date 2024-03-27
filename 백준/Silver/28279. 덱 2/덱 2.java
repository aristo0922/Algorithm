import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static Deque<String> queue = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();

    static void doMethod(String[] arr){
        switch (arr[0]){
            case "1":
                queue.addFirst(arr[1]);
                break;
            case "2":
                queue.add(arr[1]);
                break;
            case "3":
                if(sb.length()!=0) sb.append('\n');
                if(queue.isEmpty()) {
                    sb.append(-1);
                    break;
                }
                sb.append(queue.pollFirst());
                break;
            case "4":
                if(sb.length()!=0) sb.append('\n');
                if(queue.isEmpty()){
                    sb.append(-1);
                    break;
                }
                sb.append(queue.pollLast());
                break;
            case "5":
                if(sb.length()!=0) sb.append('\n');
                sb.append(queue.size());
                break;
            case "6":
                if(sb.length()!=0) sb.append('\n');
                if(queue.isEmpty()) {
                    sb.append(1);
                    break;
                }
                sb.append(0);
                break;
            case "7":
                if(sb.length()!=0) sb.append('\n');
                if(!queue.isEmpty()){
                    sb.append(queue.peekFirst());
                    break;
                }
                sb.append(-1);
                break;
            case "8":
                if(sb.length()!=0) sb.append('\n');
                if(!queue.isEmpty()){
                    sb.append(queue.peekLast());
                    break;
                }
                sb.append(-1);
                break;
            default:
                break;
        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            doMethod(br.readLine().split(" "));
        }
        System.out.println(sb);
    }
}
