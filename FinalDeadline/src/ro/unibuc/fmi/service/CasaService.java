package ro.unibuc.fmi.service;

import ro.unibuc.fmi.Entity.Casa;

import java.util.ArrayList;
import java.util.List;

public class CasaService {

    private List<Casa> listaCase = new ArrayList<>();
    private AuditService auditService;

    public List<Casa> getListaCase() {
        return listaCase;
    }

    public void setListaCase(List<Casa> listaCase) {
        this.listaCase = listaCase;
    }

    public void afisZoneCase(int zona_cautata) {
        System.out.println("Case");
        int cnt = 0;
        for (Casa casa : listaCase) {
            casa.afisare_zona(zona_cautata);
            cnt++;
        }
        if (cnt == 0) {
            System.out.println("Nu exista case in zona cautata");
        }
    }

    public void cautareBuget(double pretMin, double pretMax) {
        System.out.println("Case");
        int cnt = 0;
        for (Casa casa : listaCase) {
            casa.cautarePret(pretMin, pretMax);
            cnt++;
        }
        if (cnt == 0) {
            System.out.println("Nu exista case in acest buget");
        }
    }

    public void cautareCump(double pretMin, double pretMax) {
        System.out.println("Case");
        int cnt = 0;
        for (Casa casa : listaCase) {
            casa.cautarePretCump(pretMin, pretMax);
            cnt++;
        }
        if (cnt == 0) {
            System.out.println("Nu exista case in acest buget");
        }
    }

    public void cautareInch(double pretMin, double pretMax) {
        System.out.println("Case");
        int cnt = 0;
        for (Casa casa : listaCase) {
            casa.cautarePretInch(pretMin, pretMax);
            cnt++;
        }
        if (cnt == 0) {
            System.out.println("Nu exista case in acest buget");
        }
    }

}