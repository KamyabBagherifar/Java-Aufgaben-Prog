package Chessman;

import java.util.LinkedList;
import java.util.List;

public class Turm extends Figur {
    public Turm(char r, int l) {
        super(r, l);
    }

    @Override
    public List<Position> erreichbarePositionen() {
        List<Position> result = new LinkedList<>();
        for(int i = -7; i< 8; i++){
            if(i != 0){
                if(this.position().relativ(i,0).gueltig()) result.add(this.position().relativ(i,0));

                if(this.position().relativ(0,i).gueltig()) result.add(this.position().relativ(0,i));

            }

        }
        return result;
    }

    @Override
    public String name() {
        return "Turm";
    }
}
