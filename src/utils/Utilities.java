package utils;

import java.util.List;

public class Utilities {
    public static <T> void printElement(List<T> list){
        list.forEach(System.out::println);
    }

    public static <T> List<T> frequencyResult(List<T> list){
        List<T> result = list.stream()
                .forEach((expense) -> {
                    switch (expense){

                    }
                });

        return result;
    }
}
