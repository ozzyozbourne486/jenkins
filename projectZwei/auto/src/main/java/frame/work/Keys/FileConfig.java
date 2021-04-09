package frame.work.Keys;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileConfig {

    private static final String DYNAMIC_PATH = buildFilePath();

    public static String con() throws IOException {
        return new String((Files.readAllBytes(Paths.get(DYNAMIC_PATH))));
    }

    private FileConfig() {
    }

    private static String buildFilePath() {
        var slash = "/";
        var platform = System.getProperty("os.name");
        var platforms = platform.split(" ");
        if (platforms[0].equals("Windows"))
            slash = "\\";
        return String.format("%1$s%2$ssrc%2$smain%2$sjava%2$sframe%2$swork%2$sKeys%2$sPuller.json",
                System.getProperty("user.dir"), slash);

    }

    public static void main(String[] args) {
        System.out.println(DYNAMIC_PATH);
    }

}
