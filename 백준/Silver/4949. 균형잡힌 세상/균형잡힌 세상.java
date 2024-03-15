import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static void isValid(String str) {
        Stack<Character> stack = new Stack<>();
        if (str.contains("(") == false && str.contains("[") == false) {
            if(str.contains(")") ==false && str.contains("]") ==false){
                System.out.println("yes");
                return;
            }
        }
        for (int index = 0; index < str.length(); index++) {
            char a = str.charAt(index);
            if (a == '(' || a =='[') {
                stack.push(a);
                continue;
            }
            if (a == ')'){
                if(stack.empty() || stack.peek() != '('){
                    System.out.println("no");
                    return;
                }
                stack.pop();
            }
            if(a == ']'){
                if(stack.empty() || stack.peek() != '['){
                    System.out.println("no");
                    return;
                }
                stack.pop();
            }
        }
        if (stack.empty()) {
            System.out.println("yes");
            return;
        }
        System.out.println("no");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();
            if (line.equals(".")) {
                break;
            }
            isValid(line);
        }

    }
}
