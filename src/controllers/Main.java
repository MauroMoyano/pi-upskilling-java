package controllers;

import entities.Expense;
import exception.InvalidExpenseException;
import interfaces.ExpenseCalculator;
import interfaces.ExpenseCalculatorImpl;
import utils.Utilities;
import utils.ValidateTypeDoubleImp;

import java.util.Set;
import java.util.HashSet;

import java.util.*;

import static utils.ValidateDesitionInput.validateDesitionInput;

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

//            do {
//                System.out.print("Ingrese la cantidad de gastos a registrar: ");
//                    String aux = scanner.next();
//                    isWrongType = ValidateTypeIntImp.validate(aux);
//                    if ( isWrongType ) inputAmountOfExpense = Integer.parseInt(aux);
//            } while (!isWrongType);
        String cutLogicVar;
        boolean flag = false;

        System.out.println("¿Desea cargar un gasto? SI/NO");

        cutLogicVar = scanner.nextLine();

        validateDesitionInput(cutLogicVar);
//        do{
//
//            if(cutLogicVar.toLowerCase().trim().equals("si") ) flag = true;
//            if(cutLogicVar.toLowerCase().trim().equals("no") ) flag = true;
//            if(!flag) System.out.println("Debe ingresar SI/NO para poder continuar");
//
//        }while(flag);

        List<Expense> expenses = new ArrayList<>();

        while(cutLogicVar.equals("si")){
            if (counter != 0) System.out.println("Proximo gasto ->");
            Expense expense = new Expense();
            Set<String> categories = new HashSet<>();
            flag = false;

            do {
                System.out.print("Ingrese el monto del gasto: ");
                amount = scanner.next();
                flag = ValidateTypeDoubleImp.validate(amount);

            } while(!flag);

            scanner.nextLine();

            System.out.print("Ingrese la categoria del gasto:");
            String categoryName = scanner.nextLine().toLowerCase().trim();
            categories.add(categoryName);

            categoriesCount.put(categoryName, categoriesCount.getOrDefault(categoryName, 0) + 1);

//            if (categoriesCount.containsKey(categoryName)) {
//                categoriesCount.put(categoryName, categoriesCount.get(categoryName) + 1);
//            } else {
//                categoriesCount.put(categoryName, 1);
//            }
            System.out.print("Ingrese la fecha del gasto: (dd/mm/yyyy) -> ");
            String date = scanner.nextLine();

            expense.setId(counter);
            expense.setAmount(Double.parseDouble(amount));
            expense.setCategory(categoryName);
            expense.setDate(date);

            expenses.add(expense);

            counter++;
            index++;

            System.out.println("¿Desea cargar otro gasto? SI/NO");
            cutLogicVar = scanner.nextLine();
            validateDesitionInput(cutLogicVar);

        }
        System.out.println("Total de gastos ingresados: " + expenseCalculator.calculateTotalExpense(expenses));

        System.out.println("Top 3 de astos ingresados ");
        List<Double> amountList = expenses.stream()
                .map(Expense::getAmount)
                .limit(3)
                .toList();

        amountList.forEach(System.out::println);

        System.out.println("Map " + categoriesCount);

        System.out.println("DETALLE DE GASTOS INGRESADOS");
//        for (int i = 0; i < expenses.size(); i++) {
//            System.out.println(expenses.get(i));
//        }
        Utilities.printElement(expenses);
//        expenses.forEach(System.out::println);
    }
}