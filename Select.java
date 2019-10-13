public class Select{
	public static void SelectSort(int []arr){
		int min=0;
		int i=0;
		int j=0;
		for(i=0;i<arr.length-1;i++){//控制排序趟数
			min=i;
			for(j=i+1;j<arr.length;j++ ){
				if(arr[j]<arr[min])
					min=j;
			}
			if(min!=i){
			int temp=arr[i];
			arr[i]=arr[min];
			arr[min]=temp;
			}
		}
	}
	public static void Show(int []arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
	}

}
	public static void main(String[]args){	
		int []arr={6,8,7,5,21,35,15};
		Show(arr);	
		SelectSort(arr);
		System.out.println();
		Show(arr);	
		}
	}