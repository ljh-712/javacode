public class T4{
public static void main(String[] args) {     
int sum = 0;
for (int i = 100; i <= 200; i++) {
    if (i % 5 == 0 ^ i % 6 == 0) {
        System.out.print(i + " ");
        sum++;
        if (sum % 10 == 0) {
            System.out.println();
        }
    }
}
    }
