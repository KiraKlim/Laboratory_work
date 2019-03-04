import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean exit = false;
        DecimalFormat df = new DecimalFormat("#.###");
        while (!exit) {
            System.out.println("Введите число, к которому необходимо найти корень");
            Scanner scan = new Scanner(System.in);
            double orig_num = scan.nextDouble();
            double estimated_num = scan.nextDouble();
            double result = 0;
            double cnt = estimated_num;
            while (Math.abs(result-cnt) > 0.1) {
                result = 0.5*(estimated_num+(orig_num/estimated_num));
                cnt = estimated_num;
                estimated_num = result;
            }
            System.out.println(df.format(result));
        }
    }
}
