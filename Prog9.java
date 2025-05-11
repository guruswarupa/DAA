import java.util.Scanner;

class Prog9{
    static int x[],w[],count,d;
    static String[] categories;

    static void sum_of_subsets(int s,int k,int rem){
        x[k] = 1;
        if(s+w[k]==d){
            System.out.println("Subset/Event Planning = "+ ++count);
            for(int i=0;i<=k;i++){
                if(x[i] == 1)
                    System.out.println(categories[i]+ ":" + w[i]);
                System.out.println();
            }
        }else if(s+w[k]+w[k+1] <= d){
            sum_of_subsets(s+w[k],k+1,rem-w[k]);
        }
        if((s+rem-w[k] >= d) && (s+w[k+1])<=d) {
            x[k] = 0;
            sum_of_subsets(s,k+1,rem-w[k]);
        }
    }

    public static void main(String args[]){
        int sum =0,n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of categories:");
        n=sc.nextInt();
        w = new int[n];
        x = new int[n];
        categories = new String[n];
        sc.nextLine();
        System.out.println("Enter the category names followed by their fixed budgets (in increasing order of budget):");
        for(int i=0;i<n;i++){
            System.out.print("Category " + (i+1) + " Name:");
            categories[i] = sc.nextLine();
            System.out.print("Category " + (i+1) + " Budget:");
            w[i] = Integer.parseInt(sc.nextLine());
            sum += w[i];
        }
        System.out.println("Enter the budget to host the event:");
        d = sc.nextInt();
        if((sum<d) || (w[0] > d))
            System.out.println("No subset possible unable to host events.");
        else
            sum_of_subsets(0,0,sum);
    }

}