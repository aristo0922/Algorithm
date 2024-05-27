import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tryNum = Integer.parseInt(br.readLine());
        List<String> inputs = new ArrayList<>();
        for (int i = 0; i < tryNum; i++) {
            inputs.add(br.readLine());
        }

        List<Integer> result = inputs.stream()
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());

        for(int node: result){
            bw.write(node+"\n");
        }
        bw.flush();
    }
}
