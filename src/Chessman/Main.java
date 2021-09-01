package Chessman;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 *
 * ## Possible Chessmen
 *
 * Ein Schachbrett ist waagrecht in acht Reihen (A bis H) und
 * senkrecht in acht Linien (1 bis 8) aufgebaut.
 * Auf so einem Schachbrett seien nun mehrere Zugfolgen gegeben.
 * Z.B.:
 *
 * B2 - C3 - E5 - E8 - G6
 *
 * Gem. den Schachregeln kann diese Zugfolge nicht jede Figur ziehen.
 * Sie sollen in dieser Aufgabe nun eine Methode `possibleChessmen()` entwickeln,
 * die bestimmen kann, welche Schachfiguren (König, Dame, Turm, Läufer, Springer)
 * in der Lage sind, eine __beliebig vorgegebene Zugfolge__ zu ziehen.
 *
 * Zur Hilfe sei Ihnen folgendes UML Klassendiagramm an die Hand gegeben,
 * mit denen das Problem objektorientiert strukturiert werden kann.
 *
 * ![UML](../unit-06/ex-03-possible-chessmen/UML.png)
 *
 * Implementieren Sie nun bitte die Methode `possibleChessmen()` in der `Main`-Klasse
 * und die Klassen des UML-Klassendiagramm um das Problem zu lösen.
 *
 * __Hinweise:__
 *
 * - Die Bauern werden bewusst nicht berücksichtigt.
 * - Beachten Sie, dass die Klasse `Figur` bewusst als abstrakte Klasse konzipiert wurde.
 * - Nehmen Sie sich ein Schachbrett (oder mindestens ein Blatt Papier) zur Hand,
 *   um das Problem nachzuvollziehen.
 *
 */
class Main {

    public static void main(String[] args) {

        // Wirkungsweise eines Positionsobjekts
        Position pos = new Position('c', 2);
        System.out.println(pos); // => C2
        System.out.println(pos.gueltig()); // => true;
        System.out.println(pos.relativ(1, -1)); // => D1
        System.out.println(pos.relativ(1, -2).gueltig()); // => false
        System.out.println(pos.relativ(-3, 0).gueltig()); // => false


        // Wirkungsweise einer Schachfigur
        Figur f = new Dame('c', 2);
        System.out.println(f); // => Springer [C2]
        System.out.println(f.erreichbarePositionen()); // => [B4, D4, A3, E3, A1, E1]
        System.out.println(f.geheZu(new Position('b', 3))); // => false
        System.out.println(f); // => Springer [C2]
        System.out.println(f.geheZu(new Position('e', 3))); // => true
        System.out.println(f); // => Springer [E3]

        // Demonstration der Wirkungsweise von possibleChessmen()
        List<Position> moves = Arrays.asList(
                new Position('B', 2),
                new Position('C', 3),
                new Position('E', 5),
                new Position('E', 8),
                new Position('G', 6)
        );

        for (int i = 0; i < moves.size(); i++) {
            List<Position> submoves = moves.subList(0, i + 1);
            String men = possibleChessmen(submoves)
                    .stream()
                    .map(fig -> fig.name())
                    .collect(Collectors.joining(", "));
            System.out.println(moves.get(i) + ": " + men);
        }
        // Ergibt folgende Ausgabe:
        // B2: König, Dame, Turm, Laeufer, Springer
        // C3: König, Dame, Läufer
        // E5: Dame, Chessman.Laeufer
        // E8: Dame
        // G6: Dame
    }

    private static List<Figur> possibleChessmen(List<Position> submoves) {
        List<Figur> result = new LinkedList<>();
        result.add(new Koenig(submoves.get(0).reihe(),submoves.get(0).linie()));
        result.add(new Dame(submoves.get(0).reihe(),submoves.get(0).linie()));
        result.add(new Turm(submoves.get(0).reihe(),submoves.get(0).linie()));
        result.add(new Springer(submoves.get(0).reihe(),submoves.get(0).linie()));
        result.add(new Laeufer(submoves.get(0).reihe(),submoves.get(0).linie()));


        return possibleChessmen(submoves,result);
    }


    public static List<Figur> possibleChessmen(List<Position> submoves, List<Figur> result) {
        if (submoves.size() == 1) {
            return result;
        }
        List<Figur> tmp = new LinkedList<>();
        for(Figur f : result) {
            if(f.geheZu(submoves.get(1))) {
                tmp.add(f);
            }
        }

        return possibleChessmen(submoves.subList(1, submoves.size()), tmp);




    }





}
