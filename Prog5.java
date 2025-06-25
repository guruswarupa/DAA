import java.util.Scanner;

public class Prog5 {
    static int find(int[] parent, int i) {
        while (parent[i] != -1) {
            i = parent[i];
        }
        return i;
    }

    static void union(int[] parent, int i, int j) {
        parent[j] = i;
    }

    static void kruskal(int cost[][], int n) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
        }

        int ne = 0, mincost = 0;

        System.out.println("The minimum spanning tree edges are:");

        while (ne < n - 1) {
            int min = 999, a = -1, b = -1;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (cost[i][j] < min) {
                        min = cost[i][j];
                        a = i;
                        b = j;
                    }
                }
            }

            int u = find(parent, a);
            int v = find(parent, b);

            if (u != v) {
                System.out.println("Edge: (" + a + ", " + b + ") cost = " + min);
                mincost += min;
                union(parent, u, v);
                ne++;
            }

            // Mark this edge as visited
            cost[a][b] = cost[b][a] = 999;
        }

        System.out.println("Cost of MST = " + mincost);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices:");
        int n = sc.nextInt();

        int[][] cost = new int[n][n];
        System.out.println("Enter the cost matrix (999 for no edge):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }

        kruskal(cost, n);
    }
}
