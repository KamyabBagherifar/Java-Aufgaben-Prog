package KlausurC;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 * ## Volltextsuche mittels Lambdas
 * <p>
 * Schreiben Sie nun eine Lambda-Funktion `fulltextSearch`, die in
 * einer Liste von Zeichenketten (Zeilen eines Textes), alle Vorkommen eines
 * Suchbegriffs mit diesen Zeichenketten `[>`, `<]` beginnend und
 * abschließend kennzeichnet und die Zeilen mit markierten Treffern
 * als Liste zurück gibt.
 * <p>
 * - Die Suche soll Case-sensitiv sein, dass heißt Groß- und Kleinschreibung
 * ist zu beachten. Abweichende Schreibweisen wie "Ein" und "ein" sind
 * also nicht als Treffer zu werten.
 * - Beachten Sie das Zeilen leer oder auch `null` sein können.
 * - Beachten Sie das die Suchzeitenkette leer sein kann. In diesem Fall
 * sollen Treffer nicht markiert werden.
 * <p>
 * Machen Sie diese Lambda-Funktion bitte in einem `public static` Datenfeld
 * außerhalb der `main()`-Methode für die Auto-Evaluierung bekannt.
 * <p>
 * Aufrufbeispiele finden Sie in der `main()`-Methode.
 * <p>
 * __Verbote:__
 * <p>
 * - Es sind nur Lambda Funktionen erlaubt, keine Methoden (bis auf die `main()`).
 * - Vermeiden Sie Blöcke in Lambda-Definitionen.
 * - Es sind keine Schleifen oder bedingten Anweisungen erlaubt.
 */
class Main {

    // Bitte definieren Sie hier Ihre Lambda-Funktion

    public static void main(String[] args) {

        List<String> text = Arrays.asList(
                "# Ein kleines Beispiel",
                "",
                "Dies ist mal wieder nur",
                "unser einsames kleines Beispiel."
        );

        List<String> markedHits = fulltextSearch.apply(text, "ein");
        System.out.println(markedHits);
        // [# Ein kl[>ein<]es Beispiel., unser [>ein<]sames kl[>ein<]es Beispiel.]
    }

    //BinaryOperator<String> = BiFunction<String, String, String>
    public static BinaryOperator<String> random;
    static {
        //Die Random funktioniert wie die Blank, ungefähr. Haben hier Abbruchbedingung, eine if und 2 rekusive returns
        random = (str1, str2) -> str1.isEmpty() ? "" : str1.startsWith(str2) ? "[>" +  str2 + "<]" + random.apply(str1.substring(str2.length()), str2)
                : str1.charAt(0) + random.apply(str1.substring(1), str2);
    }


    public static BiFunction<List<String>, String, List<String>> fulltextSearch;
    static {
        //Für jedes Element (names x) aus der Liste (namens list) wird eine Funktion angewandt (namens random)
        fulltextSearch = (list, str) -> list.stream().map(x -> random.apply(x, str)).collect(Collectors.toList());
    }



}