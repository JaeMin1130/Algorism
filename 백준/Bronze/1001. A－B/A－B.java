import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();

        System.out.println(a - b);

    }
}