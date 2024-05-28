import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tryNum = Integer.parseInt(br.readLine());

        Map<Long, Long> result = IntStream.range(0, tryNum)
                .mapToObj(i -> {
                    try {
                        return Long.valueOf(br.readLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    } return null;
                })
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        Long mostFrequent = result.entrySet().stream()
                .max(Comparator.comparing(Map.Entry<Long, Long>::getValue)
                        .thenComparing(Map.Entry<Long, Long>::getKey, Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .orElse(null);
        System.out.println(mostFrequent);
    }
}
