import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean exit = false;
        DecimalFormat df = new DecimalFormat("#.###");
        while (!exit) {
            System.out.println("Введите операнды");
            Scanner scan = new Scanner(System.in);
            double var_1 = scan.nextDouble();
            double var_2 = scan.nextDouble();
            char oper = scan.next().charAt(0);
            double result = input_data(var_1, var_2, oper);
            exit = check_ex(exit, df, scan, result);
        }
    }

    private static boolean check_ex(boolean exit, DecimalFormat df, Scanner scan, double result) {
        System.out.println(df.format(result) + "\nПродолжим?(Y/N)");
        char exit_char = scan.next().charAt(0);
        if ((exit_char == 'Y') || (exit_char == 'y' ))
            exit = false;
        else if ((exit_char == 'N') || (exit_char == 'n' ))
            exit = true;
        else {
            System.out.println("Введенный символ неверен. Выход из программы");
            System.exit(0);
        }
        return exit;
    }

    public static float input_data(double var_1, double var_2, char operand) {
        double result_f = 0;
        if (operand == '+')
            result_f = var_1 + var_2;
        if (operand == '-')
            result_f = var_1 - var_2;
        if (operand == '*')
            result_f = var_1 * var_2;
        if (operand == '/')
            result_f = var_1 / var_2;
        return (float) result_f;
    }
}
