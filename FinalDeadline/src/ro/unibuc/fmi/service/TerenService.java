package ro.unibuc.fmi.service;

import ro.unibuc.fmi.Entity.Teren;

import java.util.ArrayList;
import java.util.List;

public class TerenService {

    private List<Teren> listaTeren = new ArrayList<>();
    private AuditService auditService;

    public List<Teren> getListaTeren() {
        return listaTeren;
    }

    public void setListaTeren(List<Teren> listaTeren) {
        this.listaTeren = listaTeren;
    }

    public void afisZoneTerenuri(int zona_cautata) {
        System.out.println("Terenuri");
        int cnt = 0;
        for (Teren teren : listaTeren) {
            teren.afisare_zona(zona_cautata);
            cnt++;
        }
        if (cnt == 0) {
            System.out.println("Nu exista terenuri in zona cautata");
        }
    }
}