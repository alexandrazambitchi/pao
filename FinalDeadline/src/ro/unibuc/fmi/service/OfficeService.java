package ro.unibuc.fmi.service;

import ro.unibuc.fmi.model.Office;
import ro.unibuc.fmi.repository.OfficeRepository;

import java.util.Date;

public class OfficeService {
    private static OfficeService instance;

    private final OfficeRepository officeRepository = OfficeRepository.getInstance();

    public static OfficeService getInstance(){
        if(instance == null){
            instance=new OfficeService();
        }
        return instance;
    }

    public Office saveOffice(int id, String adresa, int zona, int suprafata, double pretMp, int nrNivele, int etaj, Date registeredDateTime) {
        Office office=new Office();
        office.setId(id);
        office.setAdresa(adresa);
        office.setZona(zona);
        office.setSuprafata(suprafata);
        office.setPretMp(pretMp);
        office.setNrNivele(nrNivele);
        office.setEtaj(etaj);
        office.setRegisteredDateTime(registeredDateTime);

        return officeRepository.saveOffice(office);
    }

    public Office findOffice(int id) {
        return officeRepository.findOffice(id);
    }

    public Office updateOffice(Office office) {
        return officeRepository.updateOffice(office);
    }

    public boolean deleteOffice(Office office) {
        return officeRepository.deleteOffice(office.getId());
    }

    public Office findArea(int zona) {
        return officeRepository.findArea(zona);
    }
}
