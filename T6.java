
	public static void main3(String [] args){
		int i=0;
		int j=0;
		int count=0;
		for( i=1;i<=100;i++){
			boolean flag=true;
			for( j=2;j<i/2;j++){
				if(i%j==0){
					flag=false;
					break;
				}
			}
			if (flag==true) {
				count++;
			System.out.print(" "+i);
			if(count%9==0){
				System.out.println();
			}
		    }
		}
	}
}
	
	
	public static void main2(String [] args){
		int num=11;
		boolean flag=true;
		for(int i=2;i<num/2;i++){
			if(num%i==0){
				flag=false;
				break;
			}
		}
		System.out.println(flag);
	}