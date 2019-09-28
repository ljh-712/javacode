import java.util.Scanner;
public class Erjinzhi{
	public static void main(String [] args){
		System.out.print("enter a numer:");
		Scanner input=new Scanner(System.in);
		int num=input.nextInt();
		int arr[]=new int[10];
		int count=0;
		while(num!=0)
		{
			arr[count]=num%2;
			count++;
			num=num/2;
		}
		count--;
		for(int i=count;i>=0;i--)
		{
			System.out.print(arr[i]);
		}
	}
}