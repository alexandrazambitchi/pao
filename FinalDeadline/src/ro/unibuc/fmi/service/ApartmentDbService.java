package ro.unibuc.fmi.service;

import ro.unibuc.fmi.model.ApartmentDB;
import ro.unibuc.fmi.repository.ApartmentRepository;


import java.util.Date;

public class ApartmentDbService {
    private static ApartmentDbService instance;

    private final ApartmentRepository apartmentRepository = ApartmentRepository.getInstance();

    public static ApartmentDbService getInstance() {
        if (instance == null) {
            instance = new ApartmentDbService();
        }
        return instance;
    }

    public ApartmentDB saveApartment(int id, String adresa, int zona, int suprafata, double pretMp, int etaj, int nrBai, int nrCamere, Date registeredDateTime) {
        ApartmentDB apartmentDB = new ApartmentDB();
        apartmentDB.setId(id);
        apartmentDB.setAdresa(adresa);
        apartmentDB.setZona(zona);
        apartmentDB.setSuprafata(suprafata);
        apartmentDB.setPretMp(pretMp);
        apartmentDB.setEtaj(etaj);
        apartmentDB.setNrBai(nrBai);
        apartmentDB.setNrCamere(nrCamere);
        apartmentDB.setRegisteredDateTime(registeredDateTime);

        return apartmentRepository.saveApartment(apartmentDB);
    }

    public ApartmentDB findApartment(int id) {
        return apartmentRepository.findApartment(id);
    }

    public ApartmentDB updateApartment(ApartmentDB apartmentDB) {
        return apartmentRepository.updateApartment(apartmentDB);
    }

    public boolean deleteApartment(ApartmentDB apartmentDB) {
        return apartmentRepository.deleteApartment(apartmentDB.getId());
    }

    public ApartmentDB findArea(int zona) {
        return apartmentRepository.findArea(zona);
    }
}
