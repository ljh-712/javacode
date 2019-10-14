import java.util.Scanner; 
public class Main {
    public static void main(String[] args) {
        Scanner cin=new Scanner(System.in);
            int n=cin.nextInt();
            int a=1,d=1;
            for(int i=0;i<n;i++){//控制行数
                int b=a,//将第一个数置一
				c=i+1;
                for(int j=0;j<n-i;j++){
                    System.out.print(b);
                    if(j<n-i-1) 
						System.out.print(" ");
					else 
						System.out.println();
					
                    c++;
					b+=c;
                }
                a+=d;
				d++;
            }
        }
    }
