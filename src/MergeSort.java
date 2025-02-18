public class MergeSort {
    private static void merge(int a[], int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = a[p + i];
        for (int j = 0; j < n2; j++) R[j] = a[q + 1 + j];

        int i = 0, j = 0, k = p;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) a[k++] = L[i++];
            else a[k++] = R[j++];
        }

        while (i < n1) a[k++] = L[i++];
        while (j < n2) a[k++] = R[j++];
    }

    public static void sort(int a[], int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            sort(a, p, q);
            sort(a, q + 1, r);
            merge(a, p, q, r);
        }
    }
}
