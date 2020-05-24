package ro.unibuc.fmi.persistence;

import ro.unibuc.fmi.model.House;
import ro.unibuc.fmi.repository.HouseRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersistenceHouse {
    private static PersistenceHouse serviciu = null;

    private PersistenceHouse() {
    }

    public static PersistenceHouse getInstance() {
        if (serviciu == null)
            serviciu = new PersistenceHouse();
        return serviciu;
    }

    public boolean saveHouses(){
        List<House> houseList=new ArrayList<>();
        HouseRepository houseRepository=new HouseRepository();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("casa.csv"))) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                String[] dataFields = currentLine.split(",");
                House house = new House(Integer.parseInt(dataFields[0]), dataFields[1], Integer.parseInt(dataFields[2]), Integer.parseInt(dataFields[3]), Double.parseDouble(dataFields[4]), Integer.parseInt(dataFields[5]), Integer.parseInt(dataFields[6]), new Date());
                House houseToSave= houseRepository.saveHouse(house);
            }
        } catch (IOException e) {
            System.out.println("Could not read data from file: " + e.getMessage());
            return false;
        }
        return true;
    }
}
