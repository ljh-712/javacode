/**
 * java.lang.Stack.overLoad   栈溢出异常
 * 递归：递归一般都在栈上进行的，每调用一次函数，都会在展上开辟一块内存空间。
 *       栈内存1M/2M，先进后出。
 *   1、递归的本质：将大问题化解成小问题
 *   2、算法：自己调用自己，有一个趋近于终止的条件
 *   3、如果对于终止条件找的有错误的话，就会发生栈溢出现象
 *   4、有递有归
 */
public class Sep16 {
    /*
     青蛙跳台阶问题(提示, 使用递归)
     */
    public static int frogJump(int tep) {
        if(tep==1) {
            return 1;
        }if(tep==2){
            return 2;
        }
        return frogJump(tep-1)+frogJump(tep-2);
    }
    /*
    求解汉诺塔问题(提示, 使用递归)
     */
    public static void move(char a,char b){
        System.out.print(a+"->"+b+" ");
    }
    public static void han(char a,char b,char c,int n) {
        if(n==1){
            move(a,c);//a=1,直接将a移到
        }else {
            han(a, c, b, n - 1);//先将n-1个盘子从a借助移到b
            move(a, c);//将底下那个盘子从a移到c
            han(b, a, c, n - 1);//再将b上的盘子从借助a移到c
        }
    }
    /*
    求斐波那契数列的第 N 项
     */
    public static int fib1(int n) {
        if(n==1||n==2) {
            return 1;
        }
        return fib1(n-1)+fib1(n-2);
    }
    public static int fib2(int n) {
        if(n==1||n==2) {
            return 1;
        }
        int f1=1;
        int f2=1;
        int f3=0;
        for(int i=3;i<=n;i++){
            f3=f1+f2;
            f1=f2;
            f2=f3;
        }
        return f3;
    }
    /*
    写一个递归方法，输入一个非负整数，返回组成它的数字之和
     */
    public static int sumDig(int n) {
        if(n<10){
            return n;
        }
        return n%10+sumDig(n/10);
    }

    /*
    按顺序打印一个数字的每一位(例如 1234 打印出 1 2 3 4)
     */
    public static void print(int n) {
        if(n>9){
            print(n/10);
        }
        System.out.println(n%10);
    }
    /*
    求1+2+3+4+...+n的和
     */
    public static int sum1(int n) {
        return n==1?1:n+sum1(n-1);
    }
    public static int sum2(int n) {
        return ((int)(Math.pow(n,2))+n)>>1;
    }
    public static int sum3(int n) {
        int sum=n;
        boolean ans=(n>0)&&(sum+=sum3(n-1))>0;
        return sum;
    }

    /*
    求n！
     */
    public static int fac(int n) {
        if(n==1) {
            return 1;
        }
        return n*fac(n-1);
        }
        public static void main(String[]args) {
        System.out.println(fac(5));
        System.out.println(sum1(5));
        System.out.println(sum2(5));
        System.out.println(sum3(5));
        print(1234);
        System.out.println(sumDig(1234));
        System.out.println(fib1(4));
        System.out.println(fib2(4));
        han('a','b','c',3);
        System.out.println();
        System.out.println(frogJump(3));


        }
}