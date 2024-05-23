package utils;

import java.util.Scanner;

public class ValidateDesitionInput {
    public static String validateDesitionInput( String cuLogicVar) {
            boolean flag = false;
        Scanner scanner = new Scanner(System.in);

        do{

            if(cuLogicVar.toLowerCase().trim().equals("si") ) flag = true;
            if(cuLogicVar.toLowerCase().trim().equals("no") ) flag = true;
            if(!flag) System.out.println("Debe ingresar SI/NO para poder continuar");
            if(!flag) cuLogicVar = scanner.nextLine();

        }while(!flag);
        return cuLogicVar;
    }
}
