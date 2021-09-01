package Combine;

public class Combination<T,U> {
    public T first;
    public U second;
    public Combination(T f, U s){
        first = f;
        second = s;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}