package Chessman;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Position {
    public static int BREITE;
    private char reihe;
    private int linie;

    public Position(char c, int i){
        linie = i;
        reihe = Character.toUpperCase(c);
    }
    public char reihe(){
        return reihe;
    }
    public int linie(){
        return linie;
    }
    public boolean gueltig(){
        List<Character> list = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H');

        if((linie > 0 && linie < 9) && (list.contains(reihe))){
            return true;

        }
        return false;
    }
    public Position relativ(int r , int l){
        int tmplinie = linie + l;
        int ascii = (int) reihe;
        ascii = ascii + r;
        char tmpreihe = (char) ascii;
        return new Position(tmpreihe,tmplinie);
    }
    public boolean equals(Position p){
        return (linie == p.linie() && reihe == p.reihe());

    }

    public String toString(){

        return reihe + (linie + "");
    }


}
