public class QuickSort {
    private static int partition(int a[], int p, int r) {
        int x = a[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (a[j] <= x) {
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        int temp = a[i + 1];
        a[i + 1] = a[r];
        a[r] = temp;
        return i + 1;
    }

    public static void sort(int a[], int p, int r) {
        if (p < r) {
            int q = partition(a, p, r);
            sort(a, p, q - 1);
            sort(a, q + 1, r);
        }
    }
}
