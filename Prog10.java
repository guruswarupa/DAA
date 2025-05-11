import java.util.Scanner;

public class Prog10{
    static int a[][],n,source;

    static void path(int[] succ){
        System.out.print(source + " -> ");
        for(int j=succ[source];j != source && j!=0;j=succ[j]){
            System.out.print(j + " -> ");
        }
        System.out.println(source);
    }

    static void ckt(int st,int[] succ,int visited){
        if(visited == n && a[st][source] == 1){
            succ[st]=source;
            path(succ);
            return;
        }
        for(int i=1;i<=n;i++){
            if(a[st][i] == 1 && succ[i]==0){
                succ[st] = i;
                int[] temp = new int[n+1];
                System.arraycopy(succ,1,temp,1,n);
                ckt(i,temp,visited+1);
            }
        }
    }

    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the number of vertices: ");
        n = sc.nextInt();
        a = new int[n+1][n+1];
        int[] succ = new int[n+1];
        System.out.println("Enter the adjacency matrix: ");
        for(int i=1;i<=n;i++)
            for(int j=1;j<=n;j++)
                a[i][j] = sc.nextInt();
        source = 1;
        ckt(source,succ,1);
    }
}