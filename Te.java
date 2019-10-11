import java.util.Scanner;
public class Te{
	public static void BubbleSort(int arr[]){
		int flag=0;
		for(int i=0;i<arr.length-1;i++){//控制趟数
			flag=0;
			for(int j=0;j<arr.length-1-i;j++){//控制次数
				if(arr[j]>arr[j+1]){
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					flag++;
				}
			}
			if(flag==0){
				break;
			}
		}
	}
	public static void Show(int arr[]){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
	public static void main(String [] args){
		Scanner input=new Scanner(System.in);
		System.out.println("请输入一组数据：");
		int []arr=new int[10];
		for(int i=0;i<10;i++){
		arr[i]=input.nextInt();
		}
		BubbleSort(arr);
		Show(arr);
	}	
}