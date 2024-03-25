import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    static LinkedList<Integer> stack = new LinkedList<>();
    static ListIterator<Integer> iterator;

    static StringBuilder method(int tryNum){
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        iterator = stack.listIterator();
        int node =0 ;
        while(stack.size() != 1){
            for(int i=0;i<tryNum;i++){
                if(iterator.hasNext()){
                    node = iterator.next();
                    continue;
                }
                iterator = stack.listIterator();
                node = iterator.next();
            }
            sb.append(node).append(", ");
            iterator.remove();
        }
        sb.append(stack.pop()).append(">");
        return sb;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int tryNum = Integer.parseInt(line[0]);
        for (int index = 1; index <= tryNum; index++) {
            stack.add(index);
        }
        StringBuilder sb = method(Integer.parseInt(line[1]));
        System.out.println(sb);

    }
}
