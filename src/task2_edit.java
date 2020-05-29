import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class task2_edit {

    public static <hw> void main(String[] args) throws IOException {

        String text = new String(Files.readAllBytes(Paths.get("D:\\Docs\\Books\\HarryPotterSorcerer.txt")));

        String cleanedText = text
                .replaceAll("\\.", "")
                .replaceAll(",", "")
                .replaceAll(";", "")
                .replaceAll(":", "")
                .replaceAll("\\(", "")
                .replaceAll("\\)", "")
                .replaceAll("\"", "")
                .replaceAll("\\?", "")
                .replaceAll("!", "")
                .replaceAll("\\d", "")
                .replaceAll("\\r", "")
                .replaceAll("\uFEFF", "")
                .replaceAll("\\“", "")
                .replaceAll("–", "")
                ;

        String[] Array1 = cleanedText.split("\n");

        int countline = 0;

        for (int i=0; i < Array1.length; i++) {
            if (Array1[i].contains("Harry")) { countline++; }
        }
        System.out.println("TASK1. Number of lines containing 'Harry': " + countline);
    }
}
