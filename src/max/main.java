package max;

/**
 * ## Maximum auf einer verketteten Liste rekursiv bestimmen
 * <p>
 * Gegeben sei eine einfach verkette Liste (`RList`).
 * Implementieren Sie nun bitte auf dieser Datenstruktur
 * eine __rekursive__ Methode `max()`, die das Maximum
 * in einer solchen Liste findet.
 * <p>
 * Ist eine `RList` leer, soll `max()` die `null`-Referenz zurückgeben.
 * <p>
 * Aufrufbeispiele finden Sie in der `main()`-Methode.
 * <p>
 * __Hinweise:__
 * <p>
 * - Die Datenstruktur finden Sie in der Datei `RList.java`.
 * - Die Datenstruktur `RList` ist gegeben und muss durch Sie __nicht__
 * implementiert werden.
 * - Wenn ein Rückgabewert im Fehlerfall eine `null`-Referenz sein soll,
 * kann man bei primitiven Datentypen mit der Referenztypentsprechung
 * arbeiten (also bspw. `Integer` statt `int`).
 * <p>
 * __Verbote:__
 * <p>
 * - Sie sollen rekursiv programmieren, d.h. Schleifen aller Art sind verboten.
 */
class Main {

    public static void main(String[] args) {
        RList ls = RList.build(0, 3, 2, 4, 7, 1);
        RList empty = RList.build();
        System.out.println(ls); // => [0, 3, 2, 4, 7, 1]
        System.out.println(empty); // => []
        System.out.println(max(ls)); // => 7
        System.out.println(max(empty)); // => null
    }

        public static Integer max(RList vliste) {
            if (vliste.isEmpty) return null;
            if (vliste.next == null) return vliste.value;
            return Math.max(vliste.value, max(vliste.next));
        }
}
