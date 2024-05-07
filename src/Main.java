import entities.Expense;
import exception.InvalidExpenseException;
import interfaces.ExpenseCalculator;
import interfaces.ExpenseCalculatorImpl;
import utils.ValidateTypeDoubleImp;
import utils.ValidateTypeIntImp;

import java.util.Set;
import java.util.HashSet;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static int counter = 0;

    public static void main(String[] args) throws InvalidExpenseException {

        boolean isWrongType = false;

        int index = 0;
        Scanner scanner = new Scanner(System.in);
        String amount;
        Integer inputAmountOfExpense = 0;
        Map<String, Integer> categoriesCount = new HashMap<>();


        ExpenseCalculator expenseCalculator = new ExpenseCalculatorImpl();

            do {
                System.out.print("Ingrese la cantidad de gastos a registrar: ");
                    String aux = scanner.next();
                    isWrongType = ValidateTypeIntImp.validate(aux);
                    if ( isWrongType ) inputAmountOfExpense = Integer.parseInt(aux);
            } while (!isWrongType);


        List<Expense> expenses = new ArrayList<>();

        do {
            if (counter != 0) System.out.println("Proximo gasto ->");
            Expense expense = new Expense();
            Set<String> categorties = new HashSet<>();
            boolean flag = false;

            do {
                System.out.print("Ingrese el monto del gasto: ");
                amount = scanner.next();
                flag = ValidateTypeDoubleImp.validate(amount);

            } while(!flag);

            scanner.nextLine();

            System.out.print("Ingrese la categoria del gasto:");
            String categoryName = scanner.nextLine().toLowerCase().trim();
            categorties.add(categoryName);
            if (categoriesCount.containsKey(categoryName)) {
                categoriesCount.put(categoryName, categoriesCount.get(categoryName) + 1);
            } else {
                categoriesCount.put(categoryName, 1);
            }



            System.out.print("Ingrese la fecha del gasto: (dd/mm/yyyy) -> ");
            String date = scanner.nextLine();

            expense.setId(counter);
            expense.setAmount(Double.parseDouble(amount));
            expense.setCategory(categoryName);
            expense.setDate(date);

            expenses.add(expense);

            counter++;
            index++;
        } while (index < inputAmountOfExpense);
        System.out.println("Total de gastos ingresados: " + expenseCalculator.calculateTotalExpense(expenses));
        System.out.println("Map " + categoriesCount);

        System.out.println("DETALLE DE GASTOS INGRESADOS");
        for (int i = 0; i < expenses.size(); i++) {
            System.out.println(expenses.get(i));
        }
    }
}