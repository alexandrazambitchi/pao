package ro.unibuc.fmi.service;

import ro.unibuc.fmi.model.House;
import ro.unibuc.fmi.repository.HouseRepository;

import java.util.Date;

public class HouseService {

    private static HouseService instance;

    private final HouseRepository houseRepository = HouseRepository.getInstance();

    public static HouseService getInstance(){
        if(instance == null){
            instance=new HouseService();
        }
        return instance;
    }

    public House saveHouse(int id, String adresa, int zona, int suprafata, double pretMp, int nrNivele, int nrCamere, Date registeredDateTime) {
        House house=new House();
        house.setId(id);
        house.setAdresa(adresa);
        house.setZona(zona);
        house.setSuprafata(suprafata);
        house.setPretMp(pretMp);
        house.setNrNivele(nrNivele);
        house.setNrCamere(nrCamere);
        house.setRegisteredDateTime(registeredDateTime);

        return houseRepository.saveHouse(house);
    }

    public House findHouse(int id) {
        return houseRepository.findHouse(id);
    }

    public House updateHouse(House house) {
        return houseRepository.updateHouse(house);
    }

    public boolean deleteHouse(House house) {
        return houseRepository.deleteHouse(house.getId());
    }

    public House findNewest() {
        return houseRepository.findNewest();
    }
}
