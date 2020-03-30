package ro.unibuc.fmi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImobilService {
    private List<Imobil> proprietati = new ArrayList<>();
    private SuprafComp compSupraf = new SuprafComp();

    public List<Imobil> getProprietati() {
        return proprietati;
    }

    public SuprafComp getCompSupraf() {
        return compSupraf;
    }

    public void register(Imobil imobil)
    {
        proprietati.add(imobil);
    }

    public Imobil getSuprafMaxima() {
        proprietati.sort(Collections.reverseOrder(compSupraf));
        return proprietati.get(0);
    }

    public void getDetalii(){
        Imobil temp = getSuprafMaxima();
        temp.afisare();
    }
}
