package Chessman;

import java.util.List;

public abstract class Figur {
    private Position position;
    public Figur(char r, int l){
        position = new Position(r,l);
    }
    public Position position(){
        return position;
    }
    public abstract List<Position> erreichbarePositionen();

    public abstract String name();

    public boolean erreichbar(Position p){
        return (p.gueltig());
    }

    public boolean geheZu(Position p){
        List<Position> erreichbarePositionen = erreichbarePositionen();
        for (Position po : erreichbarePositionen) {
            if(po.equals(p)) {
                position = p;
                return true;
            }

        }

        return false;
    }

    public String toString(){
        return name() + " [" + position + "]";

    }
}
