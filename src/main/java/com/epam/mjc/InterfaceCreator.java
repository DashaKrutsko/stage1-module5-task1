package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return strings -> {
            for (String str : strings) {
                String strUp = str.toUpperCase();
                if (!str.equals(strUp)) {
                    return false;
                }
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return integers -> {
            List<Integer> newList = new ArrayList<>();
            for (Integer number : integers) {
                if (number % 2 == 0) {
                    newList.add(number);
                }
            }
            integers.addAll(newList);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> stringList = new ArrayList<>();
            for (String line : values) {
                int words = line.split(" ").length;
                if ((line.charAt(line.length() - 1) == '.') && (words > 3) && (line.charAt(0) == line.toUpperCase().charAt(0))) {
                    stringList.add(line);
                }
            }
            return stringList;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return strings -> {
            Map<String, Integer> map = new HashMap<>();
            for (String str : strings) {
                map.put(str, str.length());
            }
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (integers, integers2) -> {
            List<Integer> newList = new ArrayList<>(integers);
            newList.addAll(integers2);
            return newList;
        };
    }
}
