package lambdaPrimes;


import java.util.List;


import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

import java.util.stream.Collectors;
import java.util.stream.IntStream;



class Main {

    public static void main(String[] args) {
        System.out.println(isPrime.test(4)); // => false
        System.out.println(isPrime.test(7)); // => true

        List<Integer> result = primes.apply(20);
        System.out.println(result); // => [2, 3, 5, 7, 11, 13, 17, 19]
        System.out.println(primes.apply(3)); // => [2]
    }

    public static IntPredicate isPrime;

    static {
        isPrime = i -> i >= 2 && IntStream.rangeClosed(2, i / 2).noneMatch(e -> i % e == 0);
    }

    public static Function<Integer, List<Integer>> primes;

    static {
        primes = i -> IntStream.range(2, i).filter(e -> isPrime.test(e)).boxed().collect(Collectors.toList());
    }
}
