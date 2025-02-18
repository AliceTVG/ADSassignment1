import java.io.*;
import java.util.*;

public class FileUtils {
    public static int[] readDataset(String filename) throws IOException {
        List<Integer> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(Integer.parseInt(line.trim()));
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}
