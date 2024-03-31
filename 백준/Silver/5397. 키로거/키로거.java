import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    static String getPassword(String line) {
        LinkedList<Character> list = new LinkedList<>();
        ListIterator<Character> iterator = list.listIterator();

        for (int i = 0; i < line.length(); i++) {
            char node = line.charAt(i);
            switch (node) {
                case '>':
                    if (iterator.hasNext()) {
                        iterator.next();
                    }
                    break;
                case '<':
                    if (iterator.hasPrevious()) {
                        iterator.previous();
                    }
                    break;
                case '-':
                    if (iterator.hasPrevious()) {
                        iterator.previous();
                        iterator.remove();
                    }
                    break;
                default:
                    iterator.add(node);
            }
        }
        StringBuffer sb = new StringBuffer();
        for (char node : list) {
            sb.append(node);
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tryNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < tryNum; i++) {
            String line = br.readLine();
            System.out.println(getPassword(line));
        }

    }
}
