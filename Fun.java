public class Fun{
	public static void main(String [] args){
		
		int count = 0;
		for (int i = 1; i <= 100; i++)
	    {
		int j = i;
		while (j % 5==0)
		{
			count++;
			j = j / 5;
		}
		
	}
		System.out.println(count);
		
	}
}