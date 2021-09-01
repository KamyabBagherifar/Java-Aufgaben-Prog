package Fruchkorb;

/**
 *
 * ## Fruchtkorb
 *
 * In dieser Aufgabe sollen Früchte Körben zugeordnet werden
 * können. Zu den folgenden Früchten ist bekannt:
 *
 * - Apfel:
 *   Gewicht zwischen 100 g und 200 g (gleichverteilt), 52 kcal pro 100 g
 * - Banane:
 *   Gewicht von 75 g bis 200 g (gleichverteilt), 93 kcal pro 100 g
 * - Pfirsich:
 *   Gewicht von 100 g bis 160 g (gleichverteilt), 39 kcal pro 100 g
 *
 * Werden Früchte ohne weitere Angaben erzeugt, so sollen Sie ein
 * zufälliges Gewicht aus den angegebenen Bereichen erhalten.
 *
 * Der Zusammenhang ist in beigelegtem UML-Diagramm erläutert.
 *
 * ![UML](../unit-06/ex-04-frucht-korb/uml.png)
 *
 * In der `main()`-Methode sehen Sie wie die entsprechenden Objekte
 * angelegt werden können und auf der Konsole ausgegeben werden
 * können. Implementieren Sie nun bitte das UML Diagramm.
 *
 * Hinweise:
 *
 * - Mit der `Math.random()` Methode können Sie eine gleichverteilte
 *   Zufallszahl [0.0, 1.0[ erzeugen.
 * - Mit der `Math.round()` Methode können Sie runden.
 *
 */
class Main {

    public static void main(String[] args) {
        Frucht apple = new Apfel(127);
        System.out.println(apple);
        Frucht banana = new Banane(105);
        System.out.println(banana);
        Frucht peach = new Pfirsich(117);
        System.out.println(apple); // Apfel, 127 g, 66 kcal
        System.out.println(banana); // Banane, 105 g, 98 kcal
        System.out.println(peach); // Pfirsich, 117 g, 46 kcal

        Korb korb = new Korb();
        korb.add(banana, apple);
        korb.add(peach);
        System.out.println(korb);
        // Fruchtkorb mit insgesamt 210 kcal
        // + Banane, 105 g, 98 kcal
        // + Apfel, 127 g, 66 kcal
        // + Pfirsich, 117 g, 46 kcal

    }
}
