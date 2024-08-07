package com.stackroute.lamdbaexpression;

import java.util.List;
import java.util.function.Predicate;

public class PredicateFunctionalInterface {
    //write logic to find the values that starts with letter I in the given list
    public List<String> findPattern(List<String> list) {
        Predicate<String> stringPredicate = s-> s.startsWith("I");

       return list.stream().filter(stringPredicate).distinct().toList();

       // return result;
    }
}
