package ro.unibuc.fmi.service;

import ro.unibuc.fmi.Entity.Apartament;
import ro.unibuc.fmi.Entity.Imobil;

import java.util.ArrayList;
import java.util.List;

public class ApartamentService {

    private List<Apartament> listaApart = new ArrayList<>();
    private AuditService auditService;

    public List<Apartament> getListaApart() {
        return listaApart;
    }

    public void setListaApart(List<Apartament> listaApart) {
        this.listaApart = listaApart;
    }

    public void afisZoneApart(int zona_cautata) {
        System.out.println("Apartamente");
        int cnt = 0;
        for (Apartament apart : listaApart) {
            apart.afisare_zona(zona_cautata);
            cnt++;
        }
        if (cnt == 0) {
            System.out.println("Nu exista apartamente in zona cautata");
        }
    }

    public void cautareBuget(double pretMin, double pretMax) {
        System.out.println("Apartamente");
        int cnt = 0;
        for (Apartament apart : listaApart) {
            apart.cautarePret(pretMin, pretMax);
            cnt++;
        }
        if (cnt == 0) {
            System.out.println("Nu exista apartamente in acest buget");
        }

    }

    public void cautareCump(double pretMin, double pretMax) {
        System.out.println("Apartamente");
        int cnt = 0;
        for (Apartament apart : listaApart) {
            apart.cautarePretCump(pretMin, pretMax);
            cnt++;
        }
        if (cnt == 0) {
            System.out.println("Nu exista apartamente in acest buget");
        }
    }

    public void cautareInch(double pretMin, double pretMax) {
        System.out.println("Apartamente");
        int cnt = 0;
        for (Apartament apart : listaApart) {
            apart.cautarePretInch(pretMin, pretMax);
            cnt++;
        }
        if (cnt == 0) {
            System.out.println("Nu exista apartamente in acest buget");
        }
    }


}
