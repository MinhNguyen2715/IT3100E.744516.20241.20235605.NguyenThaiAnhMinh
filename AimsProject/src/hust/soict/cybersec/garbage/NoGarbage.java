import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class NoGarbage {
    public static void main(String[] args) throws IOException {

        String filePath = "AimsProject/src/hust/soict/cybersec/garbage/text.txt";
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();

        // Generate 100000 random words
        for (int i = 0; i < 100000; i++) {
            int wordLength = random.nextInt(8) + 3;
            StringBuilder word = new StringBuilder();

            for (int j = 0; j < wordLength; j++) {
                char letter = (char) ('a' + random.nextInt(26));
                word.append(letter);
            }

            stringBuilder.append(word).append(" ");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(stringBuilder.toString());
            System.out.println("File generated successfully at: " + filePath);
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }

        // StringBuffer implementation
        String filename = "AimsProject/src/hust/soict/cybersec/garbage/text.txt";
        byte[] inputBytes = {0};
        long startTime, endTime;

        inputBytes = Files.readAllBytes(Paths.get(filename));
        startTime = System.currentTimeMillis();
        StringBuilder outputStringBuilder = new StringBuilder();
        for (byte b : inputBytes) {
            outputStringBuilder.append((char) b);
        }
        endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);

    }
}
