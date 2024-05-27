import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String n = br.readLine();

        Set<String> numbers = Arrays.stream(br.readLine().split(" "))
                .collect(Collectors.toSet());

        n = br.readLine();
        List<String> compare = Arrays.stream(br.readLine().split(" "))
                .collect(Collectors.toList());

        for(String node: compare){
            if(numbers.contains(node)) {
                bw.write(1 + "\n");
                continue;
            }
            bw.write(0+"\n");
        }

        bw.flush();
    }
}
