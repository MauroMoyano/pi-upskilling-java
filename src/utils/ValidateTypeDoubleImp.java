package utils;

import exception.InvalidDataTypeExceptionImp;
import exception.InvalidExpenseException;
import interfaces.ExpenseAmountValidator;
import interfaces.ExpenseAmountValidatorImpl;

public class ValidateTypeDoubleImp {

    public static boolean validate(String amount) {
        ExpenseAmountValidator expenseAmountValidator = new ExpenseAmountValidatorImpl();
        boolean isDouble = true;
        Double aux;
        try {
            if (amount.matches("[+-]?\\d*\\.?\\d+")) {
                aux = (Double) Double.parseDouble(amount);
            } else {
                isDouble = false;
                throw new InvalidDataTypeExceptionImp("Dato erroneo");
            }
            try {
                if (!expenseAmountValidator.notValidAmount(aux)) {
                    System.out.println("El monto es valido");
                }
            } catch (InvalidExpenseException e) {
                System.out.println("Error = " + e.getMessage());
            }
        } catch (InvalidDataTypeExceptionImp e) {
            System.out.println(e.getMessage());
        }
        return isDouble;
    }
}