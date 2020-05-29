/*
 Classname --- Lab1
 Version info 1
 Copyright --- Klymenko Sergij ONPU
*/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Main {

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
                .replaceAll("\\n", " ")
                .replaceAll("\\d", "")
                .replaceAll("\\r", "")
                .replaceAll("\uFEFF", "")
                .replaceAll("\\“", "")
                .replaceAll("–", "")
                .toLowerCase()
                ;

        String[] distinctArray = cleanedText.split(" ");

        Arrays.sort(distinctArray);

// TASK1. longest word
        String max = "";

        for (int i=0; i < distinctArray.length; i++) {
            if ( distinctArray[i].length() > max.length() ) {
                max = distinctArray[i];
            }
        }
        System.out.println("TASK1. Max: " + max);

// TASK2. count "Harry"
        int countHarry = 0;

        for (int i=0; i < distinctArray.length; i++) {
            if ( distinctArray[i].equals("harry") ) { countHarry++; }
        }
        System.out.println("TASK2. Harry: " + countHarry + " times.");

// TASK4A. Number of duplicate words
        int countDistinctWord = 0;
        int countDublicate = 0;
        String prevWord = "";
        String currentWord = "";

        for (int i=0; i < distinctArray.length; i++) {
            currentWord = distinctArray[i];
            if ( !prevWord.equals(currentWord) ) {
                if ( countDistinctWord > 1 ) {
                    countDublicate++;
                }
                countDistinctWord = 1;
                prevWord = currentWord;
            } else {
                countDistinctWord++;
            }
        }
        if ( countDistinctWord > 1 ) {
            countDublicate++;
        }
        System.out.println("TASK4A. Number of duplicate words: " + countDublicate);

// TASK4. Number of duplicate hashes
        int hasher = 0;

        int countDistinctHash = 0;
        int countDublicateHash = 0;
        int prevHash = 0;
        int currentHash = 0;

        for (int i=0; i < distinctArray.length; i++) {
            String hww = distinctArray[i];
            hasher = hww.hashCode();

            currentHash = hasher;
            if ( prevHash != currentHash ) {
                if ( countDistinctHash > 1 ) {
                    countDublicateHash++;
                }
                countDistinctHash = 1;
                prevHash = currentHash;
            } else {
                countDistinctHash++;
            }
        }
        if ( countDistinctHash > 1 ) {
            countDublicateHash++;
        }
        System.out.println("TASK4A. Number of duplicate hashes: " + countDublicateHash);

// TASK3. Array of hashes of distinct words
        String distinctString = " ";

        for (int i=0; i < distinctArray.length; i++) {
            if ( !distinctString.contains(distinctArray[i]) ) {
                distinctString += distinctArray[i] + " ";
            }
        }

        String[] distinctArrayActual = distinctString.split(" ");

        int hash = 0;

        for (int i=0; i < distinctArrayActual.length; i++) {
            String hw = distinctArrayActual[i];
            hash = hw.hashCode();
            System.out.println(hash);
        }

/*
        for (int i=0; i < distinctArray.length; i++) {
            System.out.println(distinctArray[i]);
        }
*/
    }
}
