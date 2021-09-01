package Blank;

import java.util.Locale;

/**
 * ## Geratene Zeichen rekursiv "blanken"
 * <p>
 * Entwickeln Sie nun bitte eine __rekursive__ Methode `blank()`.
 * <p>
 * `blank()` soll zwei Zeichenketten `a` und `b` nehmen und eine neue
 * Zeichenkette wie folgt generieren. Alle Zeichen die in `a` aber nicht in
 * `b` sind, sollen in der generierten Zeichenkette durch ein `'_'` ersetzt
 * werden. Leerzeichen bleiben ebenfalls in der generierten Zeichenkette
 * erhalten, auch wenn sie nicht in `b` vorkommen.
 * <p>
 * Der Vergleich soll case-insensitiv erfolgen, also `'a'` ist wie `'A'`
 * zu werten. Die Rückgabe soll in Uppercase erfolgen.
 * <p>
 * __Hinweise:__
 * <p>
 * - Aufruf-Beispiele finden Sie in der `main()`-Methode.
 * <p>
 * __Verbote:__
 * <p>
 * - Es sind keine Schleifen erlaubt.
 * - Es dürfen keine regulären Ausdrücke genutzt werden.
 * - Die folgenden `String`-Methoden sind daher untersagt:
 * `split()`, `matches()`, `replaceAll()`, `replaceFirst()`
 */
class Main {

    public static void main(String[] args) {
        String result = blank("Hello World", "ell");
        System.out.println(result); // => _ELL_ ___L_
        System.out.println(blank("Fm Mo EwdBk", "")); // => A__ ___ ___
    }

    public static String blank(String str1, String str2) {
        str2 = " " + str2;
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        if (str1.isEmpty()) return str1;
        if (str1.startsWith(str2)) return str2 + blank(str1.substring(str2.length()), str2);
        if (str2.contains(str1.substring(0, 1))) return str1.charAt(0) + blank(str1.substring(1), str2);
        return "_" + blank(str1.substring(1), str2);
    }


}
