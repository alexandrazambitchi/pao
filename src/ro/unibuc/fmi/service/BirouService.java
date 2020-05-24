package ro.unibuc.fmi.service;

import ro.unibuc.fmi.Entity.Birou;

import java.util.ArrayList;
import java.util.List;

public class BirouService {

    private List<Birou> listaBirouri = new ArrayList<>();
    private AuditService auditService;

    public List<Birou> getListaBirouri() {
        return listaBirouri;
    }

    public void setListaBirouri(List<Birou> listaBirouri) {
        this.listaBirouri = listaBirouri;
    }

    public void afisZoneBirouri(int zona_cautata) {
        System.out.println("Birouri");
        int cnt = 0;
        for (Birou birou : listaBirouri) {
            birou.afisare_zona(zona_cautata);
            cnt++;
        }
        if (cnt == 0) {
            System.out.println("Nu exista birouri in zona cautata");
        }
    }
}
