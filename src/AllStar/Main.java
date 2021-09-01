package AllStar;

/**
 * ## Rekursives `allStar()`
 * <p>
 * Entwickeln Sie nun bitte eine __rekursive__ Methode `allStar()`,
 * die in einer Zeichenkette jedes Zeichen durch ein '*' trennt.
 * <p>
 * Aufrufbeispiele für `allStar()` finden Sie in der `main()`-Methode.
 * <p>
 * Verallgemeinern Sie dann `allStar()` so, dass ein beliebiges Zeichen
 * anstelle des `'*'` als Trennzeichen genutzt werden kann.
 * <p>
 * __Hinweise:__
 * <p>
 * - Berücksichtigen Sie die Hinweise wie sich sequenzbasierte
 * Rekursionen formulieren lassen (Unit 05).
 * - Sehen Sie sich ggf. noch einmal überladene Methoden aus
 * Unit 02 an.
 * <p>
 * __Verbote:__
 * <p>
 * - Die Lösung ist rekursiv zu lösen, d.h. Schleifen aller Art sind verboten.
 */
class Main {

    public static void main(String[] args) {
        String result = allStar("Hello");
        System.out.println(result); // => H*e*l*l*o
        System.out.println(allStar("abc")); // => a*b*c
        System.out.println(allStar("ab")); // => a*b
        System.out.println(allStar("ab", '-')); // => a-b
    }

    public static String allStar(String str) {
        if (str.length() <= 1) return str;
        return str.charAt(0) + "*" + allStar(str.substring(1));
    }

    public static String allStar(String str, char c) {
        String ch = c + "";
        if (str.length() <= 1) return str;
        return str.charAt(0) + ch + allStar(str.substring(1), c);
    }
}