import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String cardCount = br.readLine();

        Map<String, Long> wallet = Arrays.stream(br.readLine().split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        String tryCount = br.readLine();
        List<String> compare = Arrays.stream(br.readLine().split(" ")).collect(Collectors.toList());

        for(String key: compare){
            if (!wallet.containsKey(key)) {
                bw.write("0"+" ");
                continue;
            }
            bw.write(wallet.get(key).toString()+" ");
        }
        bw.flush();

    }
}
