package LambdaWithOut;



import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;


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
