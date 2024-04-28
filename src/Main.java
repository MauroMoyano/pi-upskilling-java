import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        boolean isWrongType = false;

        int index = 0;
        Scanner scanner = new Scanner(System.in);
        Integer inputExpense = 0;

        do {
            System.out.println("Ingrese la cantidad de gastos a registrar: ");
            if (scanner.hasNextInt())
            {
                inputExpense = scanner.nextInt();
            } else {
                System.out.println("Dato erroneo");
            }
        } while (isWrongType);

        do {

            index++;
        } while (index < inputExpense);
    }
}