package Check;

import java.util.List;

public class Partition<T> {
    public List<T> valids;
    public List<T> invalids;
    public Partition(List<T> v, List<T> in){
        valids = v;
        invalids = in;
    }

    public List<T> valids() {
        return valids;
    }

    public List<T> invalids() {
        return invalids;
    }
}
