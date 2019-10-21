import java.util.Scanner;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.sym.error;

/**
 * @author :Administrator.
 * @date :2019/10/21 0021
 * @time:21:22
 */
import java.util.Scanner;
public class Sep21{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int a=in.nextInt();
            String v=in.next();
            int b=in.nextInt();
            switch(v){
                case "+":{
                    System.out.println(a+b);
                    break;
                }
                case "-":{
                    System.out.println(a-b);
                    break;
                }
                case "*":{
                    System.out.println(a*b);
                    break;
                }
                case "/":{
                    System.out.println(a/b);
                    break;
                }
            }
        }
    }
}

