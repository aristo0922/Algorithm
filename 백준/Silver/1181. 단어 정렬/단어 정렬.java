import java.io.*;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> words = new HashSet<>();
        int tryNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < tryNum; i++) {
            words.add(br.readLine());
        }

        List<String> result = words.stream()
                .sorted(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.toList());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(String node:result){
            bw.write(node);
            bw.write("\n");
        }
        bw.flush();
    }
}
