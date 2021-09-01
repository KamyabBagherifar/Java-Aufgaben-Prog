package Chessman;

import Chessman.Figur;
import Chessman.Position;

import java.util.LinkedList;
import java.util.List;

public class Laeufer extends Figur {
    public Laeufer(char r, int l) {
        super(r, l);
    }

    @Override
    public List<Position> erreichbarePositionen() {
        List<Position> result = new LinkedList<>();
        for(int i = -7; i< 8; i++){
            if(i != 0){
                
                if(this.position().relativ(i,i).gueltig()) result.add(this.position().relativ(i,i));

                if(this.position().relativ(i,-i).gueltig()) result.add(this.position().relativ(i,-i));
            }

        }
        return result;
    }

    @Override
    public String name() {
        return "Läufer";
    }
}
