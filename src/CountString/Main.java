package CountString;

/**
 * ## Vorkommen von Zeichenketten rekursiv zählen
 * <p>
 * Bitte entwickeln Sie nun eine __rekursive__ Methode
 * `countSubstring()`, die zählt wie oft ein String
 * Teilstring eines anderen Strings ist.
 * <p>
 * Aufrufbeispiele finden Sie in der `main()`-Methode.
 * <p>
 * __Hinweis:__
 * <p>
 * - Sehen Sie sich noch einmal an wie man
 * sequenzbasierte Rekursionen formulieren kann (Unit 05).
 * <p>
 * __Verbote:__
 * <p>
 * - Sie sollen rekursiv programmieren, d.h. Schleifen aller Art
 * sind verboten.
 */
class Main {

    public static void main(String[] args) {
        int n = countSubstring("Hello World", "Hello");
        System.out.println(n); // => 1
        System.out.println(countSubstring("Hello World", "l")); // => 3
        System.out.println(countSubstring("xxx", "xx")); // => 2

    }

    public static int countSubstring(String str1, String str2){
        if(str1.isEmpty() || str2.isEmpty()) return 0;
        if(str1.startsWith(str2)) return 1 + countSubstring(str1.substring(1), str2);
        return countSubstring(str1.substring(1),str2);
    }

}

