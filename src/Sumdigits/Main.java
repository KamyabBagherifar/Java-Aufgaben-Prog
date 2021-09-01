package Sumdigits;

/**
 * ## Quersumme rekursiv berechnen
 * <p>
 * Entwickeln Sie nun bitte eine __rekursive__ Methode
 * `sumDigits()`, die die Quersumme einer natürlichen Zahl
 * berechnet.
 * <p>
 * Aufrufbeispiele finden Sie in der `main()`-Methode.
 * <p>
 * __Hinweise:__
 * <p>
 * - Die ganzzahlige Division durch 10 und modulo 10 können sehr hilfreich sein.
 * - https://de.wikipedia.org/wiki/Quersumme
 * - Die Aufgabe kann als Einzeiler gelöst werden.
 * <p>
 * __Verbote:__
 * <p>
 * - Sie sollen rekursiv programmieren, d.h. Schleifen aller Art sind verboten.
 */
class Main {

    public static void main(String[] args) {
        int sum = sumDigits(123);
        System.out.println(sum); // => 6
        System.out.println(sumDigits(99996)); // => 42
        System.out.println(-123 * -1);
        System.out.println(sumDigits(-123)); // => -6
    }

    public static int sumDigits(int i) {
        if (i == 0) {
            return 0;
        } else if (i < 0) {
            return (-1) * sumDigits(i * (-1));
        } else {
            return i % 10 + sumDigits(i / 10);
        }

    }
}
