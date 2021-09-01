package LambdaBlank;



import java.util.function.BinaryOperator;

/**
 * ## Geratene Zeichen mittels Lambdas "blanken"
 * <p>
 * Entwickeln Sie nun bitte eine Lambda-Funktion und machen Sie diese
 * in einem `public static` Datenfeld namens `blank` außerhalb der
 * `main()`-Methode für die Auto-Evaluierung bekannt.
 * <p>
 * `blank()` soll zwei Zeichenketten `a` und `b` nehmen und eine neue
 * Zeichenkette wie folgt generieren. Alle Zeichen die in `a` aber nicht in
 * `b` sind, sollen in der generierte Zeichenkette durch ein `'_'` ersetzt
 * werden. Leerzeichen bleiben ebenfalls in der generierten Zeichenkette
 * erhalten, auch wenn sie nicht in `b` vorkommen.
 * <p>
 * __Hinweise:__
 * <p>
 * - Aufruf-Beispiele finden Sie in der `main()`-Methode.
 * - Nutzen Sie jeweils den konkretesten Lambda Typ
 * (also bspw. `Predicate<String>` anstatt `Function<String, Boolean>`).
 * <p>
 * __Verbote:__
 * <p>
 * - Es sind keine Methoden erlaubt (bis auf die `main()`).
 * - Es sind keine Schleifen erlaubt.
 * - Es sind keine Blöcke innerhalb von Lambda Funktionen erlaubt.
 */
class Main {

    public static void main(String[] args) {
        String result = blank.apply("Hello World", "ell");
        System.out.println(result); // => _ell_ ___l_
        System.out.println(blank.apply("abc def ghj", "a")); // => a__ ___ ___
    }

    public static BinaryOperator<String> blank;

    static {
        blank = (firstStr, secondStr) -> firstStr.isEmpty() ? firstStr : secondStr.isEmpty() ? "_"
                + blank.apply(firstStr.substring(1), secondStr)
                : firstStr.startsWith(" ") ? " "
                + blank.apply(firstStr.substring(1), secondStr)
                : firstStr.startsWith(secondStr) ? secondStr
                + blank.apply(firstStr.substring(secondStr.length()), secondStr)
                : secondStr.contains(firstStr.substring(0, 1)) ? firstStr.charAt(0)
                + blank.apply(firstStr.substring(1), secondStr)
                : "_" + blank.apply(firstStr.substring(1), secondStr);
    }
}
