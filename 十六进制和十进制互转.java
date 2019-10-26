
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author :Administrator.
 * @date :2019/10/24 0024
 * @time:19:43
 */
public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        System.out.printf("%X",n);
    }
}
//public class Main {
//    public static void main(String[] args) {
//        int []arr=new int[20];
//        int count=0;
//        Scanner in=new Scanner(System.in);
//        int n=in.nextInt();
//        while(n!=0) {
//            arr[count] = n % 16;
//            count++;
//            n = n / 16;
//        }
//        count--;
//        for (int i = count; i >=0 ; i--) {
//            switch(arr[i]) {
//                case 1: System.out.print(1);
//                    break;
//                case 2: System.out.print(2);
//                    break;
//                case 3: System.out.print(3);
//                    break;
//                case 4: System.out.print(4);
//                    break;
//                case 5: System.out.print(5);
//                    break;
//                case 6: System.out.print(6);
//                    break;
//                case 7: System.out.print(7);
//                    break;
//                case 8: System.out.print(8);
//                    break;
//                case 9: System.out.print(9);
//                    break;
//                case 10:System.out.print('A');
//                break;
//                case 11:System.out.print('B');
//                break;
//                case 12:System.out.print('C');
//                break;
//                case 13:System.out.print('D');
//                break;
//                case 14:System.out.print('E');
//                break;
//                case 15:System.out.print('F');
//                break;
//                default:
//                    break;
//            }
//        }
//    }
//}


//十六转十
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String n = in.next();
//        char[] arr = n.toCharArray();
//        long sum = 0;
//        int flag = 1;
//        for (int i = arr.length - 1; i >= 0; i--) {
//            if (arr[i] >= 'A' && arr[i] <= 'F') {
//                sum += flag * (arr[i] - 55);
//            } else {
//                sum += flag * (arr[i] - '0');
//            }
//            flag = flag * 16;
//        }
//
//        System.out.println(sum);
//
//    }
//}

//    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
//        int n=in.nextInt();
//        int []arr=new int[n];
//        for(int i=0;i<n;i++) {
//            arr[i]=in.nextInt();
//        }
//        int key=in.nextInt();
//        boolean flag=false;
//        for(int i=0;i<n;i++) {
//            if (key == arr[i]) {
//                flag = true;
//                System.out.println(i + 1);
//                break;
//            }
//        }
//        if(!flag) {
//            System.out.println(-1);
//        }
//    }
//}


//    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
//        long n=in.nextLong();
//        long sum=0L;
//        if(n>0&&n<=100000000) {
//            for (int i = 1; i <=n; i++) {
//                sum=sum+i;
//
//            }
//
//        }
//        System.out.println(sum);
//    }
//}
//    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
//            int num1=in.nextInt();
//            int num2=in.nextInt();
//            if(num1>=(-10000)&&num2<=10000) {
//                System.out.println(num1+num2);
//        }
//    }
//}
//    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
//        long n=in.nextLong();
//        long sum=0L;
//        if(n>0&&n<=100000000) {
//           sum=(long)(1+n)*n/2;
//
//        }
//        System.out.println(sum>>1);
//    }
//}

//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int r = input.nextInt();
//        if (r >= 1 && r <= 10000) {
//            double area = 0D;
//            double pi = 3.14159265358979323D;
//            area = pi * r * r;
//            System.out.printf("%.7f", area);
//        }
//    }
//}

//    public static void main(String[] args) {
//        Scanner input=new Scanner(System.in);
//        int n=input.nextInt();
//        int []f=new int[n];
//        if(n>=1&&n<1000000) {
//            if(n==1||n==2) {
//                f[n-1]=1;
//            }else {
//                for (int i = 2; i < n; i++) {
//                    f[0]=1;
//                    f[1]=1;
//                    f[i]=(f[i-1]+f[i-2])%10007;
//                }
//            }
//            System.out.println(f[n-1]);
//        }
//    }
//}
//    public static int fac(int n) {
//        if(n==1||n==2) {
//            return 1;
//        }
//        int f3=0;
//        int f1=1;
//        int f2=1;
//        for(int i=3;i<=n;i++) {
//            f3=f1+f2;
//            f1=f2;
//            f2=f3;
//        }
//        return f3%10007;
//
//    }
//    public static void main(String[] args) {
//        System.out.println(fac(22));
//    }
//}
