import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static Deque<Character> queue = new ArrayDeque<>();

    static StringBuffer reverseWord(Deque queue){
        StringBuffer sb = new StringBuffer();
        while(queue.size()>0){
            sb.append(queue.pollLast());
        }
        return sb;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] nodes = br.readLine().toCharArray();
        StringBuffer sb = new StringBuffer();
        boolean setIn = false;

        for(char node : nodes){
            if(node == '<'){
                setIn = true;
                sb.append(reverseWord(queue));
                sb.append(node);
                continue;
            }
            if(node == '>'){
                while(queue.size()>0){
                    sb.append(queue.pollFirst());
                }
                sb.append(node);
                setIn=false;
                continue;
            }
            if(node == ' ' && setIn == false){
                sb.append(reverseWord(queue));
                sb.append(" ");
                continue;
            }
            queue.add(node);
        }
        if(queue.size()>0){
            sb.append(reverseWord(queue));
        }
        System.out.println(sb);

    }
}
