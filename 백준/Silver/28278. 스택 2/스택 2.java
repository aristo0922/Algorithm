import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer> stack = new ArrayList<>();
    static int stackLen = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tryNum = Integer.valueOf(br.readLine());
        for (int index = 0; index < tryNum; index++) {
            String[] doNum = br.readLine().split(" ");
            if (doNum[0].equals("1")) {
                stack.add(Integer.valueOf(doNum[1]));
                stackLen++;
                continue;
            }
            if (doNum[0].equals("2")) {
                if (stackLen != 0) {
                    sb.append(stack.remove(stackLen - 1));
                    sb.append('\n');
                    stackLen--;
                    continue;
                }
                sb.append(-1);
                sb.append('\n');
                continue;
            }
            if (doNum[0].equals("3")) {
                sb.append(stackLen);
                sb.append('\n');
                continue;
            }
            if (doNum[0].equals("4")) {
                if (stackLen == 0) {
                    sb.append(1);
                    sb.append('\n');
                    continue;
                }
                sb.append(0);
                sb.append('\n');
                continue;
            }
            if (doNum[0].equals("5")) {
                if (stackLen != 0) {
                    sb.append(stack.get(stack.size() - 1));
                    sb.append('\n');
                    continue;
                }
                sb.append(-1);
                sb.append('\n');
            }
        }
        System.out.println(sb.toString());
    }
}
