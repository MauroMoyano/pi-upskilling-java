import entities.Expense;
import entities.ExpenseCategory;
import exception.InvalidExpenseException;
import interfaces.ExpenseAmountValidator;
import interfaces.ExpenseAmountValidatorImpl;
import interfaces.ExpenseCalculator;
import interfaces.ExpenseCalculatorImpl;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static int counter = 0;

    public static void main(String[] args) throws InvalidExpenseException {

        boolean isWrongType = false;

        int index = 0;
        Scanner scanner = new Scanner(System.in);
        Double amount;
        Integer inputAmountOfExpense = 0;

        ExpenseAmountValidator expenseAmountValidator = new ExpenseAmountValidatorImpl();
        ExpenseCalculator expenseCalculator = new ExpenseCalculatorImpl();

        do {
            System.out.print("Ingrese la cantidad de gastos a registrar: ");
            if (scanner.hasNextInt())
            {
                inputAmountOfExpense = scanner.nextInt();
            } else {
                System.out.println("Dato erroneo");
            }
        } while (isWrongType);

        Expense[] expenses = new Expense[inputAmountOfExpense];

        do {
            if (counter != 0) System.out.println("Proximo gasto ->");
            Expense expense = new Expense();
            ExpenseCategory category = new ExpenseCategory();
            boolean flag = false;

            do {
                System.out.print("Ingrese el monto del gasto: ");
                amount = scanner.nextDouble();

                try {
                    if (!expenseAmountValidator.notValidAmount(amount)) {
                        System.out.println("El monto es valido");
                        flag = true;
                    }
                }catch (InvalidExpenseException e) {
                    System.out.println("Error = " + e.getMessage());
                }
            } while(!flag);

            scanner.nextLine();

            System.out.print("Ingrese la categoria del gasto:");
            String name = scanner.nextLine().toLowerCase().trim();
            category.setName(name);


            System.out.print("Ingrese la fecha del gasto: (dd/mm/yyyy) -> ");
            String date = scanner.nextLine();

            expense.setId(counter);
            expense.setAmount(amount);
            expense.setCategory(category);
            expense.setDate(date);

            expenses[index] = expense;

            counter++;
            index++;
        } while (index < inputAmountOfExpense);
        System.out.println("Total de gastos ingresados: " + expenseCalculator.calculateTotalExpense(expenses));

        System.out.println("DETALLE DE GASTOS INGRESADOS");
        for (int i = 0; i < expenses.length; i++) {
            System.out.println(expenses[i]);
        }
    }
}