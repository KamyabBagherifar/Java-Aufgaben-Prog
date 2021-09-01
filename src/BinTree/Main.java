package BinTree;

import BinTree.Node;


/**
 * ## Binärbäume rekursiv prettyprinten
 * <p>
 * Gegeben sei die Klasse `Node` mit der Binärbäume
 * gebildet werden können, die Zeichenketten als Werte
 * speichern können.
 * <p>
 * Entwickeln Sie nun bitte eine __rekursive__ Methode `prettyPrint()`, die
 * eine Zeichenkettenrepräsentation für solche Binärbäume generiert,
 * die auf der Konsole ausgegeben gut als Baumstruktur interpretierbar
 * sind.
 * <p>
 * Sie finden Aufrufbeispiele in der `main()`-Methode.
 * <p>
 * `prettyPrint()` soll
 * <p>
 * - jeden Knoten des Baums mit einem vorangestellten `"- "` kennzeichen,
 * - jede Ebene des Baums um zwei Leerzeichen `"  "` einrücken und
 * - für den `null` Baum, die leere Zeichenkette `""` zurückgeben.
 * <p>
 * __Hinweis:__
 * <p>
 * - Die Datenstruktur `Node` findet sich in der Datei `Node.java`.
 * - Es bietet sich ggf. an das Einrückungsproblem mit einer
 * überladenen Methode anzugehen, der eine Einrückungstiefe
 * als zusätzlicher Parameter übergeben wird.
 * <p>
 * __Verbote:__
 * <p>
 * - Das Problem ist rein rekursiv zu lösen. Schleifen sind nicht gestattet.
 */
class Main {

    public static void main(String[] args) {
        Node tree = new Node("f",
                new Node("o",
                        new Node("C",
                                new Node("tasty"),
                                null),
                        new Node("F")
                ),
                new Node("E",
                        null,
                        new Node("e")
                )
        );
        // Hinweis, der Evaluator wird diesen Baum in folgender
        // Notation ausgeben (Pattern: %value[%left,%right])
        // <f[o[C[tasty,null],F],E[null,e]]>

        String output = prettyPrint(tree);
        System.out.println(output); // =>
        //- f
        //  - o
        //    - C
        //      - tasty
        //    - F
        //  - E
        //    - e 

        System.out.println(prettyPrint(new Node("A"))); // => "- A"
        System.out.println(prettyPrint(null)); // => ""
    }

    private static String prettyPrint(Node tree, String tab) {
        if (tree == null) return "";
        if ((tree.left != null) && (tree.right != null))
            return tab + "- " + tree.value + "\n" + prettyPrint(tree.left, tab + "  ") + prettyPrint(tree.right, tab + "  ");
        if (tree.left != null) return tab + "- " + tree.value + "\n" + prettyPrint(tree.left, tab + "  ");
        if (tree.right != null) return tab + "- " + tree.value + "\n" + prettyPrint(tree.right, tab + "  ");
        return tab + "- " + tree.value + "\n";
    }

    public static String prettyPrint(Node tree) {
        return prettyPrint(tree, "");
    }

}