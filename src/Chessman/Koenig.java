package Chessman;

import java.util.LinkedList;
import java.util.List;

public class Koenig extends Figur {
    public Koenig(char r, int l) {
        super(r, l);
    }

    @Override
    public List<Position> erreichbarePositionen() {
        List<Position> result = new LinkedList<>();
        Position standhere = this.position();
        if(standhere.relativ(1,0).gueltig()) result.add(standhere.relativ(1,0));
        if(standhere.relativ(1,1).gueltig()) result.add(standhere.relativ(1,1));
        if(standhere.relativ(1,-1).gueltig()) result.add(standhere.relativ(1,-1));
        if(standhere.relativ(-1,0).gueltig()) result.add(standhere.relativ(-1,0));
        if(standhere.relativ(-1,1).gueltig()) result.add(standhere.relativ(-1,1));
        if(standhere.relativ(-1,-1).gueltig()) result.add(standhere.relativ(-1,-1));
        if(standhere.relativ(0,1).gueltig()) result.add(standhere.relativ(0,1));
        if(standhere.relativ(0,-1).gueltig()) result.add(standhere.relativ(0,-1));

        return result;
    }

    @Override
    public String name() {
        return "Koenig";
    }
}
