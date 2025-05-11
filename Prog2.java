import java.util.Scanner;
import java.util.Random;

public class Prog2 {
    public static int count = 0;

    static void merge(int b[], int c[], int a[]) {
        int i = 0, j = 0, k = 0;
        int p = b.length; 
        int q = c.length; 

        while ((i < p) && (j < q)) {
            count++; 
            if (b[i] <= c[j])
                a[k++] = b[i++];
            else
                a[k++] = c[j++];
        }

        while (i < p) {
            a[k++] = b[i++];
        }

        while (j < q) {
            a[k++] = c[j++];
        }
    }

    static void mergesort(int a[]) {
        int n = a.length;
        if (n > 1) {
            int mid = n / 2; 
            int[] b = new int[mid]; 
            int[] c = new int[n - mid]; 

            System.arraycopy(a, 0, b, 0, mid);
            System.arraycopy(a, mid, c, 0, n - mid);

            mergesort(b);
            mergesort(c);

            merge(b, c, a);
        }
    }

    public static void main(String[] args) {
        int n;
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the number of elements:");
        n = s.nextInt();

        int[] a = new int[n];

        Random r = new Random();

        System.out.println("Input numbers:");
        for (int i = 0; i < n; i++) {
            a[i] = r.nextInt(10000); 
            System.out.print(a[i] + " ");
        }

        mergesort(a);

        System.out.println("\n\nSorted numbers are:");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("\nBest Case:" + (int)(n*Math.log(n)/Math.log(2)));
        System.out.println("\nNumber of basic operations are " + count);
        System.out.println("\nWorst Case:" + n*n);
    }
}
