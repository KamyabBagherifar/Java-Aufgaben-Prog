package LambdaColumnize;

import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * ## Tabellarische Konsolenausgabe mittels Lambdas
 * <p>
 * Diese Aufgabe haben Sie bereits exakt oder in sehr ähnlicher Form
 * an anderen Stellen im Praktikum geloest. Diesmal dürfen Sie
 * allerdings nur Streams und Lambdafunktionen nutzen.
 * Innerhalb von Lambdafunktionen sind jegliche Kontrollanweisungen
 * wie Schleifen oder bedingte Anweisungen untersagt.
 * Sie dürfen aber natürlich Teilprobleme in andere Lambdafunktionen,
 * Operatoren oder Prädikate auslagern.
 * <p>
 * Entwickeln Sie nun bitte eine Lambdafunktion `columnize` und machen Sie diese
 * in `public static` Datenfeldern außerhalb der `main()`-Methode
 * für die Auto-Evaluierung bekannt.
 * <p>
 * `columnize` soll aus einer Liste von Zahlen eine Zeichenkette in dem jedes Element
 * mit einem Tabulator `\t` getrennt wird. Jeder n.te Tabulator wird jedoch
 * durch ein `\n` ersetzt (solche Zeichenketten erscheinen tabellarisch
 * auf der Konsole). Im Fehlerfall soll `columnize` die `null` Referenz zurueckgeben.
 * <p>
 * Aufrufbeispiele finden Sie in der `main()`-Methode.
 * <p>
 * __Hinweise:__
 * <p>
 * - Nutzen Sie jeweils den konkretesten Lambda Typ
 * (also bspw. `Predicate<String>` anstatt `Function<String, Boolean>`).
 * <p>
 * __Verbote:__
 * <p>
 * - Es sind nur Lambda Funktionen erlaubt, keine Methoden (bis auf die `main()`).
 * - Es sind keine Schleifen oder bedingten Anweisungen erlaubt.
 */
class Main {

    public static void main(String[] args) {

        String result = columnize.apply(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8), 4);
        System.out.println(result);
        // 1       2       3
        // 4       5       6
        // 7       8

        // Entspricht der Zeichenkette:
        // "1\t2\t3\n4\t5\t6\n7\t8"
    }

    public static BiFunction<List<Integer>, Integer, String> columnize = (x, y) -> y == 0 ? null :
            x.stream().map(i -> i + "").collect(Collectors.joining("\t"))
                    .replaceAll("(([^\t]*\t){" + (y - 1) + "}[^\t]*)\t", "$1\n");


}
