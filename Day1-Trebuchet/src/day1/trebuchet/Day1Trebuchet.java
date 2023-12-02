import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Day1Trebuchet {

    public static void main(String[] args) {
        String filePathString = "/home/diego/NetBeansProjects/advent_of_code_2023/Day1-Trebuchet/Assets/Day1-Inputs";

        // Converta a String do caminho para um objeto Path
        Path filePath = Paths.get(filePathString);

        try {
            // Leia todas as linhas do arquivo para uma lista de Strings
            List<String> lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);

            // Exiba as linhas lidas
            for (String line : lines) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
