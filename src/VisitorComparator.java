import java.util.Comparator;

public class VisitorComparator implements Comparator<Visitor> {
    
    public int compare(Visitor v1, Visitor v2) {
        // first compare by VIP status (VIP first)
        if (v1.getHasVIP() && !v2.getHasVIP()) {
            return -1;
        } else if (!v1.getHasVIP() && v2.getHasVIP()) {
            return 1;
        }
        
        // if same VIP status, compare by age (younger first)
        return Integer.compare(v1.getAge(), v2.getAge());
    }
}