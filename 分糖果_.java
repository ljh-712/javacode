package T2014;

import java.util.Scanner;

/**
 * @author :Administrator.
 * @date :2020/3/9 0009
 * @time:23:47
 */
public class 分糖果_ {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
//        int n = 3;
//        int a[] = {2, 2, 4};

        int sum = 0;//记录补发的糖果数。
        int b = 0;
        int k = 0;
        for (int i = 0; i < n; i++) {
            a[i]=sc.nextInt();
        }
        while (true) {

            b = 0;
            k = a[0];//取一个变量保存第一个人的糖果数
            for (int i = 0; i < n - 1; i++)//开始一轮交换，注意i<n-1
            {
                a[i] = a[i] / 2;//先把自己的糖果减半
                a[i] = a[i] + (a[i + 1] / 2);//再加上后一位的糖果的一半，也保持后一位的糖果不变

            }
            a[n - 1] = a[n - 1] / 2;//最后处理最后一个人和第一个人的糖果交换
            a[n - 1] = a[n - 1] + (k / 2);//利用原先储存的k值
            for (int i = 0; i < n; i++) {
                if (a[i] % 2 != 0) {
                    a[i] = a[i] + 1;//奇数补充糖果
                    sum++;//利用m值记录补发个数
                }
            }
            for (int i = 1; i < n; i++)
                if (a[i] != a[0]) b = 1;//利用b的值进行判断所有同学的糖果数是否一样
            if (b == 0) {
                break;
            }
        }
        System.out.println(sum);
    }

}
