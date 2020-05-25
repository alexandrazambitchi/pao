package ro.unibuc.fmi.Entity;

import java.util.Comparator;

public class SuprafataComp implements Comparator<Imobil> {

    @Override
    public int compare(Imobil o1, Imobil o2) {
        return o1.getSuprafata() - o2.getSuprafata();
    }
}
