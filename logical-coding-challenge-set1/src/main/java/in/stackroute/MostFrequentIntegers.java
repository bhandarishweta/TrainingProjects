package in.stackroute;

import java.util.*;

public class MostFrequentIntegers {

    public int mostFrequent(int[] input) {
        HashMap<Integer,Integer> map = new LinkedHashMap();
        int count = 1;
        for(int i: input){
            if(map.containsKey(i)){
                int value = map.get(i);
                map.computeIfPresent(i, (k,v)-> v++);
            }
            else
                map.put(i,count);
        }
        int max = Collections.max(map.values());

        Optional<Map.Entry<Integer,Integer>> opt = map.entrySet().stream().filter(entry -> entry.getValue()==max).findFirst();
        if(opt.isPresent()){
            return opt.get().getKey();
        }
        else
            return 0;
    }

    public static void main(String[] args) {
        MostFrequentIntegers mostFrequentIntegers = new MostFrequentIntegers();

        // Test case 1
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(mostFrequentIntegers.mostFrequent(input));
        // Expected Output: 1

        // Test case 2
        int[] input2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(mostFrequentIntegers.mostFrequent(input2));
        // Expected Output: 1
    }
}
