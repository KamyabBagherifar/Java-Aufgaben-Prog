package max;

import java.util.Arrays;
import java.util.List;

/**
 * Vorgabe. Diese Datei darf durch Sie nicht verändert werden.
 * Etwaige Änderungen werden bei der Ausführung oder Evaluierung
 * überschrieben und haben daher keinen Effekt.
 */
public class RList {

    public int value;
    public RList next;
    public boolean isEmpty = false;

    public RList() { this.isEmpty = true; }
    public RList(int v) { this.value = v; }

    public static RList build(List<Integer> values) {
        if (values.isEmpty()) return new RList();
        RList first = new RList(values.get(0));
        RList last = first;
        for (int i = 1; i < values.size(); i++) {
            last.next = new RList(values.get(i));
            last = last.next;
        }
        return first;
    }

    public static RList build(Integer... values) {
        return RList.build(Arrays.asList(values));
    }

    public String serialize() {
        return value + (next == null ? "" : ", " + next.serialize());
    }

    public String toString() {
        return isEmpty ? "[]" : "[" + serialize() + "]";
    }
}
