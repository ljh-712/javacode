public class T11{
	public static void main(String []args){
	int [][]arr=new int[4][4];
		int i=0;
		int j=0;
		int n=4;
		int count=1;
		for(i=0;i<n/2;i++){
			for(j=i;j<n-i-1;j++){//
				arr[i][j]=count;
				count++;
			}
			for(j=i;j<n-i-1;j++){
				arr[j][n-i-1]=count;
				count++;
			}
			for(j=n-i-1;j>i;j--){
				arr[n-i-1][j]=count;
				count++;
			}
			for(j=n-i-1;j>i;j--){
				arr[j][i]=count;
				count++;
			}
		}
		if(n%2==1){
			arr[n/2][n/2]=count;
		}
		for(i=0;i<4;i++){
			for(j=0;j<4;j++){
				System.out.printf("%-4d",arr[i][j]);
			}
		System.out.println();
		}		
	}
}		

