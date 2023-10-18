import javax.xml.transform.Result;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Scanner;

public class Condition {
    public static void main(String[] args, Object TXT) throws IOException {
        Scanner scan = new Scanner(new File("INPUT.TXT"));
        int tRoom = scan.nextInt();
        int tCond = scan.nextInt();
        scan.nextLine();
        String mode = scan.nextLine();
        int result;
        result = new Result(tRoom, tCond, mode);
        writeToFile(result);
    }

    public static int getResult(String mode, int tRoom, int tCond) {
        int result = 0;
        if (Objects.equals(mode, "fan"))
            result = tRoom;
        if (Objects.equals(mode, "auto"))
            result = tCond;
        if (Objects.equals(mode, "hot")) {
            result = hot(tRoom, tCond);
        }
        if (Objects.equals(mode, "freeze")) {
            result = freeze(tRoom, tCond);
        }
        return result;
    }

    public static int hot(int tRoom, int tCond) {
        if (tRoom >= tCond)
            return tRoom;
        else
            return tCond;
    }

    public static int freeze(int tRoom, int tCond) {
        if (tRoom <= tCond)
            return tRoom;
        else
            return tCond;
    }

    public static void writeToFile(int result) throws IOException {
        String s = String.valueOf(result);
        Files.writeString(Path.of("OUTPUT.TXT"), s);
    }
}
















//System.out.println();

