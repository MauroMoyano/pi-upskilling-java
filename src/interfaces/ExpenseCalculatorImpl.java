package interfaces;

import entities.Expense;

import java.util.List;
import java.util.stream.Stream;


public class ExpenseCalculatorImpl implements ExpenseCalculator{
    @Override
    public double calculateExpense(Expense expense) {
        return expense.getAmount();
    }

    public double calculateTotalExpense(List<Expense> expenses) {

        double totalExpense;

        Stream<Expense> expenseStream = expenses.stream();

        totalExpense = expenseStream.mapToDouble(Expense::getAmount).sum();

        return totalExpense;
    }
}
