public class T12{
	public static void fun1(int n){
		boolean flag=true;
		n=n&(n-1);
		if(n==0){
			flag=true;
		}
		else{
			flag=false;
		}
		System.out.println(flag);	
	}
	public static int fun2(int m,int n){
		int temp=m^n;
		int count=0;
		while(temp!=0){
			count++;
			temp=temp&(temp-1);
		}
		return count;
	}
	public static void main(String[] args) {
		fun1(9);
		System.out.println(fun2(10,13));
		
	}
}