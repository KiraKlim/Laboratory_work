import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.###");
        System.out.println("Enter the number");
        Scanner scan = new Scanner(System.in);
        String source_data = scan.nextLine();

        String[] items = source_data
                .replaceAll("\\s", "") // \\s+ --> replaces 1 or more spaces. \\\\s+ --> replaces the literal \ followed by s one or more times.
                .split(",");

        double[] result = new double[items.length];
        double summa = 0;
        for (int i = 0; i < items.length; i++) {
            try {
                result[i] = 1/(Double.parseDouble(items[i])*3);
                System.out.println("1/(" + Double.parseDouble(items[i]) + " * 3):\t" + df.format(result[i]));
                summa += result[i];
            } catch (NumberFormatException nfe) {
                System.out.println("Something went wrong");
            };
        }
        System.out.println("Sum = " + df.format(summa));


    }
}
