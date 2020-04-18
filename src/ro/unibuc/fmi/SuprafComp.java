package ro.unibuc.fmi;

import java.util.Comparator;

public class SuprafComp implements Comparator<Imobil> {

    @Override
    public int compare(Imobil o1, Imobil o2) {
        return o1.getSuprafata()-o2.getSuprafata();
    }
}
