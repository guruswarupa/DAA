import java.util.Scanner;
import java.util.Random;

public class Prog3 {
    static int count = 0;

    static int partition(int a[], int l, int r) {
        int pivot = a[r];  
        int i = l - 1;

        for (int j = l; j <= r - 1; j++) {
            if (a[j] <= pivot) {
                i++; 
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                count++;
            }
        }

        int temp = a[i + 1];
        a[i + 1] = a[r];
        a[r] = temp;
        count++;

        return i + 1;
    }

    static void quicksort(int a[], int l, int r) {
        if (l < r) {
            int s = partition(a, l, r);  
            quicksort(a, l, s - 1);
            quicksort(a, s + 1, r);
        }
    }

    public static void main(String args[]) {
        int n;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of elements:");
        n = s.nextInt();

        int a[] = new int[n];
        Random r = new Random();

        System.out.println("Input numbers:");
        for (int i = 0; i < n; i++) {
            a[i] = r.nextInt(10000);
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
