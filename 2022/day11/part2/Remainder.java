package day11.part2;

import java.util.HashMap;
import java.util.Map;

public class Remainder {

    private final Map<Integer, Integer> remainders;

    public Remainder(int number) {
        remainders = new HashMap<>();
        // haha hardcoding go brrrrrr...
        /*remainders.put(13, number % 13);
        remainders.put(17, number % 17);
        remainders.put(19, number % 19);
        remainders.put(23, number % 23);*/ // -> for the test-thingy

        remainders.put(2, number % 2);
        remainders.put(3, number % 3);
        remainders.put(5, number % 5);
        remainders.put(7, number % 7);
        remainders.put(11, number % 11);
        remainders.put(13, number % 13);
        remainders.put(17, number % 17);
        remainders.put(19, number % 19);
    }

    public void add(int addend) {
        for (Integer key : remainders.keySet()) {
            remainders.compute(key, (k, v) -> (v + addend) % k);
        }
    }

    public void multiply(int factor) {
        for (Integer key : remainders.keySet()) {
            remainders.compute(key, (k, v) -> (v * factor) % k);
        }
    }

    public void square() {
        for (Integer key : remainders.keySet()) {
            remainders.compute(key, (k, v) -> (v * v) % k);
        }
    }

    public int getRemainder(int dividend) {
        return remainders.get(dividend);
    }

}
