package ro.unibuc.fmi.service;

import ro.unibuc.fmi.Entity.Depozit;

import java.util.ArrayList;
import java.util.List;

public class DepozitService {

    private List<Depozit> listaDep = new ArrayList<>();
    private AuditService auditService;

    public List<Depozit> getListaDep() {
        return listaDep;
    }

    public void setListaDep(List<Depozit> listaDep) {
        this.listaDep = listaDep;
    }

    public void afisZoneDepozite(int zona_cautata) {
        System.out.println("Depozite");
        int cnt = 0;
        for (Depozit depozit : listaDep) {
            depozit.afisare_zona(zona_cautata);
            cnt++;
        }
        if (cnt == 0) {
            System.out.println("Nu exista depozite in zona cautata");
        }
    }
}