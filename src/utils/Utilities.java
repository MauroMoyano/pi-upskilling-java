package utils;

import java.util.List;

public class Utilities {
    public static <T> void printElement(List<T> list){
        list.forEach(System.out::println);
    }
}
