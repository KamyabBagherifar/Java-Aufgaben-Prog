package MyQeue;

/**
 *
 * ## Generische Warteschlange
 *
 * Lesen Sie sich bitte in das Konzept der Datenstruktur
 * [Warteschlange](http://de.wikipedia.org/wiki/Warteschlange_(Datenstruktur)) ein
 * und entwickeln Sie eine generische Warteschlange `MyQueue` mit dem generischen
 * Typparameter `T`. Die Datenstruktur `MyQueue` soll die folgenden
 * Methoden implementieren:
 *
 * - `enter()` fügt ein neues Element der Warteschlange hinzu.
 *    Liefert `true`, wenn das Element der Warteschlange hinzugefügt werden konnte,
 *    andernfalls `false`.
 * - `leave()` entnimmt das erste Element
 *    der Warteschlange. Ist die Warteschlange leer wirft die Methode
 *    eine `java.util.NoSuchElementException`.
 * - `isEmpty()` prüft ob die Warteschlange leer ist.
 * - `front()` liest das erste Element der Warteschlange,
 *   belässt es aber in der Warteschlange. Liefert `null`,
 *   wenn sich kein Element in der Warteschlange befindet.
 * - `toString()` liefert eine eine textuelle Repräsentation
 *   der Warteschlange in folgender Form: `"[e1, e2, e3, e4]"` wenn
 *      – `e1`, ..., `e4` Elemente der Warteschlange sind und
 *      – `e1` das hinterste Element und
 *      – `e4` das vorderste Element der Warteschlange ist.
 *
 * Aufrufbeispiele finden Sie in der `main()`-Methode. Ergänzend ist Ihnen
 * noch folgendes UML-Diagramm an die Hand gegeben.
 *
 * ![UML](../unit-09/ex-01-generische-warteschlange/UML.png)
 *
 */
class Main {

    public static void main(String[] args) {

        MyQueue<String> myq = new MyQueue<String>();
        System.out.println(myq);
        // => []

        myq.enter("Max");
        myq.enter("Maren");
        myq.enter("Tessa");
        myq.enter("Hans");


        System.out.println(myq);
        // => [Hans, Tessa, Maren, Max]

         System.out.println(myq.front());
        // => Max

        System.out.println(myq);
        // => [Hans, Tessa, Maren, Max]

        System.out.println(myq.leave());
        // => Max

        System.out.println(myq);
        // => [Hans, Tessa, Maren]
    }

}

