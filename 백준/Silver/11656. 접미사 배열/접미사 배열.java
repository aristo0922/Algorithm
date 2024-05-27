import java.io.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        IntStream.range(0, line.length())
                .mapToObj(i->line.substring(i))
                .sorted()
                .forEach(System.out::println);

    }
}
