package example.stream.code;

import example.util.TimeUtil;

import java.io.IOException;

/* fileIOBufferedReader */
import java.io.BufferedReader;
import java.io.FileReader;

/* fileIOStream */
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

/* getDirAddress */
import java.nio.file.Paths;

public class TFile1 {
    public static void main(String[] args) {
        TFile1 cFile = new TFile1();
        cFile.getDirAddress();

        /* Method Execution */
        TimeUtil.methodExecutionTimer(() -> cFile.fileIOBufferedReader(), "fileIOBufferedReader",true);
        TimeUtil.methodExecutionTimer(() -> cFile.fileIOStream(), "fileIOStream",true);

        /*
        *
        * fileIOBufferedReader : 0.001 ~ 0.007s / avg : 0.003s / Execution Count : 17
        * fileIOStream : 0.005 ~ 0.016s / avg : 0.012s / Execution Count : 17
        *
        * */
    }

    public void fileIOBufferedReader(){
        try (BufferedReader reader = new BufferedReader(new FileReader("example/stream/example.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    System.out.println(word);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fileIOStream() {
        Path filePath = Path.of("example/stream/example.txt");
        try (
                Stream<String> lines = Files.lines(filePath)) {
            lines.flatMap(line -> Stream.of(line.split("\\s+")))
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* 디렉터리 주소을 위한 메소드 */
    public void getDirAddress(){
        Path currentDirectory = Paths.get("");
        System.out.println("Current Directory: " + currentDirectory.toAbsolutePath());
    }
}
