package CleanString;

/**
 * ## Zeichenketten rekursiv bereinigen
 * <p>
 * Schreiben Sie bitte eine __rekursive__ Methode `cleanString()`, die
 * mehrfache benachbarte Zeichenvorkommen in einem String
 * löscht.
 * <p>
 * Aufrufbeispiele finden Sie in der `main()`-Methode.
 * <p>
 * __Verbote:__
 * <p>
 * - Schleifen aller Art sind verboten.
 * - Lambdafunktionen sind verboten
 * - Datenfelder (globale Variablen) sind verboten.
 */
class Main {

    public static void main(String[] args) {
        System.out.println(cleanString("yyzzza")); // => yza
        System.out.println(cleanString("aabbbcdd")); // => abcd
        System.out.println(cleanString("Hello")); // => Helo
    }

    public static String cleanString(String str) {
        if (str.length() <= 1) return str;
        if (str.charAt(0) == str.charAt(1)) return cleanString(str.substring(1));
        return str.charAt(0) + cleanString(str.substring(1));
    }

}
