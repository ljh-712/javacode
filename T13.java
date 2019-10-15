public static void Print(int num){
		int i=0;
		for(i=31;i>=1;i=i-2){
			System.out.print(" "+((num>>i)&1));
		}
		System.out.println();
		for(i=30;i>=0;i=i-2){
			System.out.print(" "+((num>>i)&1));
		}	
	}