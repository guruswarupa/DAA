import java.util.Scanner;
public class Prog4 {
    static void prim(int cost[][],int n){
        int[] visit = new int[n];
        int a = 0,b = 0,min,mincost = 0,ne = 1;
        visit[0] = 1;
        while(ne<n){
            min = 999;
            for(int i=0;i<n;i++){
                if(visit[i]!=0){
                    for(int j=0;j<n;j++){
                        if(cost[i][j]<min && visit[j]==0){
                            min = cost[i][j];
                            a = i;
                            b = j;
                        }
                    }
                }
            }
            System.out.println("Edge from vertex " + a + " to vertex " + b + " and the cost is " + min);
            visit[b] = 1;
            ne++;
            mincost += min;
            cost[a][b] = cost [b][a] = 999;
        } 
        System.out.println("minimum spanning tree cost is " + mincost);
    }

    public static void main(String[] args){
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of vertices: ");
        int x = sc.nextInt();
        int[][] c = new int[x][x];
        System.out.println("Enter the adjacency matrix: ");
        for(int i=0;i<x;i++){
            for(int j=0;j<x;j++){
                c[i][j] = sc.nextInt();
            }
        } 
        prim(c,x);
    }
}