package LambdaWithOut;

import UML2.B;

import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * ## Filtern von Listen von Zeichenketten mittels Lambdas
 * <p>
 * Diese Aufgabe haben Sie bereits exakt oder in sehr ähnlicher Form
 * an anderen Stellen im Praktikum gelöst. Diesmal dürfen Sie
 * allerdings nur Streams und Lambdafunktionen nutzen.
 * Innerhalb von Lambdafunktionen sind jegliche Kontrollanweisungen
 * wie Schleifen oder bedingte Anweisungen untersagt.
 * Sie dürfen aber natürlich Teilprobleme in andere Lambdafunktionen,
 * Operatoren oder Prädikate auslagern.
 * <p>
 * Entwickeln Sie nun bitte eine Lambdafunktion `without` und machen Sie diese
 * in `public static` Datenfeldern außerhalb der `main()`-Methode
 * für die Auto-Evaluierung bekannt.
 * <p>
 * `without` soll aus einer Liste von Zeichenketten eine neue Zeichenkette
 * ohne eine vorgebene Zeichenkette generieren.
 * <p>
 * Aufrufbeispiele finden Sie in der `main()`-Methode.
 * <p>
 * __Hinweise:__
 * <p>
 * - Nutzen Sie jeweils den konkretesten Lambda Typ
 * (also bspw. `Predicate<String>` anstatt `Function<String, Boolean>`).
 * - Achten Sie darauf, dass sie Streams limitieren (ansonsten haben Sie Endlosberechnungen).
 * <p>
 * __Verbote:__
 * <p>
 * - Es sind nur Lambda Funktionen erlaubt, keine Methoden (bis auf die `main()`).
 * - Es sind keine Schleifen oder bedingten Anweisungen erlaubt.
 */
public class Main {

    public static void main(String[] args) {
        List<String> examples = Arrays.asList(
                "Dies", "ist", "nur", "ein", "Beispiel"
        );
        List<String> result = without.apply(examples, "nur");
        System.out.println(result); // => ["Dies", "ist", "ein", "Beispiel"]
    }

    public static BiFunction<List<String>, String, List<String>> without;

    static {
        without = (list, str) -> list.isEmpty() ? list : str.isEmpty() ? list
                : list.stream().filter(e -> !e.equals(str)).collect(Collectors.toList());
    }
}
