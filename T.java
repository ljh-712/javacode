public class T{
    int[][] a;
    public int[][] yang(int n){
        int [][] a=new int[n][n];
        for(int i=0;i<n;i++){

                a[i][0]=1;
                a[i][i]=1;            
            for(int j=1;j<i;j++) {
                a[i][j] = a[i - 1][j] + a[i - 1][j - 1]; 
              
            }
            }
        }
      
        for(int i=0;i<n;i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        return a;
    }

    public static void main(String[] args) {
        new T().yang(10);
    }
}
