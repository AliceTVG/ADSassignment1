public class SortingBenchmark {
    public static void benchmarkSortingAlgorithms(String filename, int[] data, int runs) {
        String[] sortingNames = {"InsertionSort", "SelectionSort", "ShellSort",
                "MergeSort", "QuickSort"};
        Runnable[] sortingAlgorithms = {
                () -> InsertionSort.sort(data.clone()),
                () -> SelectionSort.sort(data.clone()),
                () -> ShellSort.sort(data.clone()),
                () -> MergeSort.sort(data.clone(), 0, data.length - 1),
                () -> QuickSort.sort(data.clone(), 0, data.length - 1)
        };

        System.out.println("\nBenchmarking " + filename);
        for (int i = 0; i < sortingNames.length; i++) {
            long totalTime = 0;

            for (int j = 0; j < runs; j++) {
                int[] tempArray = data.clone(); 

                long startTime = System.nanoTime();
                sortingAlgorithms[i].run();
                long endTime = System.nanoTime();

                long duration = endTime - startTime;
                totalTime += duration;
            }

            double avgTime = (double) totalTime / runs;
            System.out.printf("%-15s : %.0f ns\n", sortingNames[i], avgTime); // Display in ns
        }
    }
}