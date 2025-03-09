import java.util.Scanner;
import java.util.Random;

public class MergeSort {
    public static int count = 0;

    // Merge function to combine two sorted subarrays into one
    static void merge(int b[], int c[], int a[]) {
        int i = 0, j = 0, k = 0;
        int p = b.length; // Length of left subarray
        int q = c.length; // Length of right subarray

        // Merge the two subarrays while both have elements
        while ((i < p) && (j < q)) {
            count++; // Increment count for basic operation
            if (b[i] <= c[j])
                a[k++] = b[i++];
            else
                a[k++] = c[j++];
        }

        // Copy remaining elements from the left subarray
        while (i < p) {
            a[k++] = b[i++];
        }

        // Copy remaining elements from the right subarray
        while (j < q) {
            a[k++] = c[j++];
        }
    }

    // Merge Sort function
    static void mergesort(int a[]) {
        int n = a.length;
        if (n > 1) {
            // Correctly split array in two parts
            int mid = n / 2; // Middle index
            int[] b = new int[mid]; // Left subarray
            int[] c = new int[n - mid]; // Right subarray

            // Copy elements into left and right subarrays
            System.arraycopy(a, 0, b, 0, mid);
            System.arraycopy(a, mid, c, 0, n - mid);

            // Recursively sort the left and right subarrays
            mergesort(b);
            mergesort(c);

            // Merge the sorted subarrays into the original array
            merge(b, c, a);
        }
    }

    public static void main(String[] args) {
        int n;
        Scanner s = new Scanner(System.in);

        // Ask for the number of elements
        System.out.println("Enter the number of elements:");
        n = s.nextInt();

        // Create an array to hold the numbers
        int[] a = new int[n];

        // Initialize the Random object
        Random r = new Random();

        // Generate and display random numbers
        System.out.println("Input numbers:");
        for (int i = 0; i < n; i++) {
            a[i] = r.nextInt(10000); // Generate random integers
            System.out.print(a[i] + " ");
        }

        // Perform the merge sort
        mergesort(a);

        // Display the sorted numbers and count of basic operations
        System.out.println("\n\nSorted numbers are:");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("\nBest Case:" + (int)(n*Math.log(n)/Math.log(2)));
        System.out.println("\nNumber of basic operations are " + count);
        System.out.println("\nWorst Case:" + n*n);
    }
}
