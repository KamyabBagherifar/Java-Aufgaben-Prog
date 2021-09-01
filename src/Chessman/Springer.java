package Chessman;

import java.util.LinkedList;
import java.util.List;

public class Springer extends Figur {
    public Springer(char r, int l) {
        super(r, l);
    }



    @Override
    public List<Position> erreichbarePositionen() {
        List<Position> result = new LinkedList<>();
        Position standhere = this.position();
        if(standhere.relativ(2,1).gueltig()) result.add(standhere.relativ(2,1));
        if(standhere.relativ(2,-1).gueltig()) result.add(standhere.relativ(2,-1));
        if(standhere.relativ(-2,1).gueltig()) result.add(standhere.relativ(-2,1));
        if(standhere.relativ(-2,-1).gueltig()) result.add(standhere.relativ(-2,-1));
        if(standhere.relativ(1,2).gueltig()) result.add(standhere.relativ(1,2));
        if(standhere.relativ(-1,2).gueltig()) result.add(standhere.relativ(-1,2));
        if(standhere.relativ(1,-2).gueltig()) result.add(standhere.relativ(1,-2));
        if(standhere.relativ(-1,-2).gueltig()) result.add(standhere.relativ(-1,-2));

        return result;
    }

    @Override
    public String name() {
        return "Springer";
    }
}
