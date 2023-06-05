package lambdas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileFilter;
import java.util.Map;

public class FileFilterTest {

    private final File root = new File("src/main/java");

    @Test
    void listFiles() {
        File[] files = root.listFiles();
        assert files != null;

        for(File file: files) {
            System.out.println(file);
        }

        assertEquals(21, files.length);
    }

    @Test
    void listDirectoriesAnonInnerClass() {
        FileFilter lambda = f -> f.isDirectory();

        File[] directories = root.listFiles(lambda);
        assertEquals(directories.length, 13);
    }

    @Test
    void listJavaSourceFiles() {
        File[] javaSourceFiles = root.listFiles((dir, name) -> name.endsWith(".java"));
        assertEquals(javaSourceFiles.length, 8);
    }

    // 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
    @Test
    void iterateOverMap() {
        var map = Map.of("a", 1, "b", 2, "c", 3);
        map.forEach((k,v) -> System.out.println(k + " -> " + v));
    }


}
