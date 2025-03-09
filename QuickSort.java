import java.util.Scanner;
import java.util.Random;

public class QuickSort {
    static int count = 0;

    // Lomuto partition scheme: select a pivot and reorder the array such that 
    // elements less than the pivot are on the left, and elements greater than 
    // the pivot are on the right.
    static int partition(int a[], int l, int r) {
        int pivot = a[r];  // Choose the last element as pivot
        int i = l - 1;     // Index of smaller element

        for (int j = l; j <= r - 1; j++) {
            // If current element is smaller than or equal to the pivot
            if (a[j] <= pivot) {
                i++; // Increment the index of smaller element
                // Swap a[i] and a[j]
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                count++;
            }
        }

        // Swap a[i+1] and a[r] (pivot)
        int temp = a[i + 1];
        a[i + 1] = a[r];
        a[r] = temp;
        count++;

        return i + 1; // Return the partition index
    }

    // QuickSort function that recursively sorts the subarrays
    static void quicksort(int a[], int l, int r) {
        if (l < r) {
            int s = partition(a, l, r);  // Get the partition index
            quicksort(a, l, s - 1);      // Sort the left part
            quicksort(a, s + 1, r);      // Sort the right part
        }
    }

    public static void main(String args[]) {
        int n;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of elements:");
        n = s.nextInt();

        int a[] = new int[n];
        Random r = new Random();

        // Generate random values for the array
        System.out.println("Input numbers:");
        for (int i = 0; i < n; i++) {
            a[i] = r.nextInt(10000);  // Random number between 0 and 9999
            System.out.print(a[i] + " ");
        }

        quicksort(a, 0, n - 1);

        System.out.println("\n\nSorted numbers are:");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println("\n\nBest Case: " + (int) (n * Math.log(n) / Math.log(2)));
        System.out.println("\nNo. of basic operations: " + count);
        System.out.println("\nWorst Case: " + n * n);
    }
}
