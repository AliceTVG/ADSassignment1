import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String[] datasets = {
            "../test_data/int10.txt", "../test_data/int50.txt", "../test_data/int100.txt", 
            "../test_data/int1000.txt", "../test_data/int20k.txt", "../test_data/int500k.txt", "../test_data/intBig.txt"
        };        
        int runs = 10;

        for (String filename : datasets) {
            try {
                int[] data = FileUtils.readDataset(filename);
                SortingBenchmark.benchmarkSortingAlgorithms(filename, data, runs);
            } catch (IOException e) {
                System.out.println("Error reading file: " + filename);
            }
        }
    }
}
