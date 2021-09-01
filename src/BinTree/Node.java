package BinTree;
import java.util.List;

/**
 * Diese Klasse ist gegeben. Ändern Sie daran nichts.
 * Änderungen werden im Rahmen der Autoevaluierung 
 * überschrieben und haben daher keinen Effekt!
 */
public class Node {

    public String value;
    public Node left = null;
    public Node right = null;

    public Node(String v) { this.value = v; }

    public Node(String v, Node l, Node r) {
        this.value = v;
        this.left = l;
        this.right = r;
    }

    public void insert(String content, double shift) {
        if (Math.random() < shift) {
            // insert left
            if (this.left != null) this.left.insert(content, shift);
            else this.left = new Node(content);
        } else {
            // insert right
            if (this.right != null) this.right.insert(content, shift);
            else this.right = new Node(content);
        }
    }

    public Node insert(List<String> contents, double shift) {
        for (String content : contents) this.insert(content, shift);
        return this;
    }

    public String toString() {
        if (this.left == null && this.right == null) return this.value;
        return String.format("%s[%s,%s]", this.value, this.left, this.right);
    }
}