package utils;

import exception.InvalidDataTypeExceptionImp;

public class ValidateTypeIntImp {

    public static boolean validate(String value) {
        boolean isInt = true;
        try {
            int aux;
            if (value.matches("\\d+")) {
                aux = Integer.parseInt(value);

            } else {
                isInt = false;
                throw new InvalidDataTypeExceptionImp("Dato erroneo");
            }
        } catch (InvalidDataTypeExceptionImp e){
            System.out.println(e.getMessage());
        }
        return isInt;
    }
}
