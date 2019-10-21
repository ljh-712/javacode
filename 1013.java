import java.util.Scanner;
public class T13{
	public  static int StrToInt(String str) {
        int res = 0;        
        int symbol = 1;
        boolean isInvalid = true;  //区分非法输入和0 
        char[] arr = str.toCharArray();//将一个字符串转换为字符数组
        int n = arr.length;        
        if (n <=  0 || str == null) {
            isInvalid = true;
            return 0;
        }        
        if (arr[0] == '-')
            symbol = -1;         
        for (int i = (arr[0] ==  '-' || arr[0] == '+') ? 1 : 0; i < n; ++i) {
            if (!('0' <= arr[i] && arr[i] <= '9')) {
                isInvalid =true;
                return 0;
            }
            res = (res << 1) + (res << 3) + (arr[i] & 0xf); //res=res*10+arr[i]-'0'            
            if((symbol == 1 && res>Integer.MAX_VALUE) || (symbol == -1 && res < Integer.MIN_VALUE)) {//判断溢出
                isInvalid = true;
                return 0;
            }
        }
         
        return res * symbol;
    }

	public static void main(String []args){
		String str="+12345";
		System.out.println(StrToInt(str));
	}
}