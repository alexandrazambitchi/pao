package ro.unibuc.fmi;

import ro.unibuc.fmi.Entity.*;
import ro.unibuc.fmi.model.*;
import ro.unibuc.fmi.persistence.*;
import ro.unibuc.fmi.repository.*;
import ro.unibuc.fmi.service.*;

import java.io.*;
import java.util.*;

public class Main {

    private static final HouseService houseService = HouseService.getInstance();
    private static final AgentDbService agentDbService = AgentDbService.getInstance();
    private static final ApartmentDbService apartmentDbService = ApartmentDbService.getInstance();
    private static final OfficeService officeService = OfficeService.getInstance();

    public static void main(String[] args) throws IOException {

        PersistenceRead persistentaR = PersistenceRead.getInstance();
        PersistenceWrite persistentaW = PersistenceWrite.getInstance();
        ImobilService proprietati = new ImobilService();
        AuditService auditService = new AuditService();
        DepozitService depozitService = new DepozitService();
        TerenService terenService = new TerenService();
        HouseService houseService = new HouseService();

        BufferedReader fileDep = new BufferedReader(new FileReader("depozit.csv"));
        if (fileDep.readLine() != null) {
            depozitService.setListaDep(persistentaR.citireDepozit());
        }
        BufferedReader fileTeren = new BufferedReader(new FileReader("teren.csv"));
        if (fileTeren.readLine() != null) {
            terenService.setListaTeren(persistentaR.citireTeren());
        }

        List<Depozit> listaDep = depozitService.getListaDep();
        List<Teren> listaTeren = terenService.getListaTeren();

        proprietati.readPropertiesFromFile();

        Scanner keyboard = new Scanner(System.in);
        System.out.println("1. Acces admin");
        System.out.println("2. Acces client");
        System.out.println("3. Iesire");
        int input = keyboard.nextInt();
        switch (input) {
            case 1: {
                System.out.println("a. Adaugare agent");
                System.out.println("b. Cautare agenti");
                System.out.println("c. Modificare zona agent");
                System.out.println("d. Stergere agent");
                System.out.println("e. Adaugare casa");
                System.out.println("f. Modificare pret casa");
                System.out.println("g. Stergere casa");
                System.out.println("h. Adaugare apartament");
                System.out.println("i. Modificare pret apartament");
                System.out.println("j. Stergere apartament");
                System.out.println("k. Adaugare birou");
                System.out.println("l. Modificare pret birou");
                System.out.println("m. Stergere birou");
                System.out.println("z. Iesire");
                String key;
                do {
                    System.out.println("Alegere: ");
                    key = keyboard.next();
                    switch (key) {
                        case "a": {
                            System.out.println("Datele noului agent: (id, nume, zona)");
                            int idAng = keyboard.nextInt();
                            String numeAng = keyboard.next();
                            int zonaAng = keyboard.nextInt();
                            agentDbService.saveAgent(idAng, numeAng, zonaAng, new Date());
                            auditService.writeAudit("Adaugare agent");
                        }
                        break;
                        case "b": {
                            System.out.println("Id-ul agentului cautat");
                            int id = keyboard.nextInt();
                            System.out.println(agentDbService.findAgent(id));
                            auditService.writeAudit("Cautare agent");
                        }
                        break;
                        case "c": {
                            System.out.println("Noua zona a agentului si id-ul acestuia");
                            int newZona = keyboard.nextInt();
                            int id = keyboard.nextInt();
                            AgentDB newAgentDb = agentDbService.findAgent(id);
                            newAgentDb.setZonaAct(newZona);
                            agentDbService.updateAgent(newAgentDb);
                            auditService.writeAudit("Modificare zona agent");
                        }
                        break;
                        case "d": {
                            System.out.println("Id-ul agentului de sters");
                            int id = keyboard.nextInt();
                            AgentDB agentDB = agentDbService.findAgent(id);
                            agentDbService.deleteAgent(agentDB);
                            auditService.writeAudit("Stergere agent");
                        }
                        break;
                        case "e": {
                            System.out.println("Datele casei de adaugat (id, adresa, zona, suprafata, pret MP, nr Nivele, nr Camere)");
                            int id = keyboard.nextInt();
                            String adresa = keyboard.next();
                            int zona = keyboard.nextInt();
                            int suprafata = keyboard.nextInt();
                            double pret = keyboard.nextDouble();
                            int nrNivele = keyboard.nextInt();
                            int nrCamere = keyboard.nextInt();
                            houseService.saveHouse(id, adresa, zona, suprafata, pret, nrNivele, nrCamere, new Date());
                            auditService.writeAudit("Adaugare casa");
                        }
                        break;
                        case "f": {
                            System.out.println("Noul pret al casei si id-ul casei");
                            double pret = keyboard.nextDouble();
                            int id = keyboard.nextInt();
                            House casa = houseService.findHouse(id);
                            casa.setPretMp(pret);
                            houseService.updateHouse(casa);
                            auditService.writeAudit("Modificare pret casa");
                        }
                        break;
                        case "g": {
                            System.out.println("Id-ul casei de sters");
                            int id = keyboard.nextInt();
                            House house = houseService.findHouse(id);
                            houseService.deleteHouse(house);
                            auditService.writeAudit("Stergere casa");
                        }
                        break;
                        case "h": {
                            System.out.println("Datele apartamentului de adaugat (id, adresa, zona, suprafata, pret MP, etaj, nr Bai, nr Camere)");
                            int id = keyboard.nextInt();
                            String adresa = keyboard.next();
                            int zona = keyboard.nextInt();
                            int suprafata = keyboard.nextInt();
                            double pret = keyboard.nextDouble();
                            int etaj = keyboard.nextInt();
                            int nrBai = keyboard.nextInt();
                            int nrCamere = keyboard.nextInt();
                            apartmentDbService.saveApartment(id, adresa, zona, suprafata, pret, etaj, nrBai, nrCamere, new Date());
                            auditService.writeAudit("Adaugare apartament");
                        }
                        break;
                        case "i": {
                            System.out.println("Noul pret al apartamentului si id-ul apartamentului");
                            double pret = keyboard.nextDouble();
                            int id = keyboard.nextInt();
                            ApartmentDB apartmentDB = apartmentDbService.findApartment(id);
                            apartmentDB.setPretMp(pret);
                            apartmentDbService.updateApartment(apartmentDB);
                            auditService.writeAudit("Modificare pret apartament");
                        }
                        break;
                        case "j": {
                            System.out.println("Id-ul apartamentului de sters");
                            int id = keyboard.nextInt();
                            ApartmentDB apartmentDB = apartmentDbService.findApartment(id);
                            apartmentDbService.deleteApartment(apartmentDB);
                            auditService.writeAudit("Stergere apartament");
                        }
                        break;
                        case "k": {
                            System.out.println("Datele biroului de adaugat (id, adresa, zona, suprafata, pret MP, nrNivele, etaj)");
                            int id = keyboard.nextInt();
                            String adresa = keyboard.next();
                            int zona = keyboard.nextInt();
                            int suprafata = keyboard.nextInt();
                            double pret = keyboard.nextDouble();
                            int nrNivele = keyboard.nextInt();
                            int etaj = keyboard.nextInt();
                            officeService.saveOffice(id, adresa, zona, suprafata, pret, nrNivele, etaj, new Date());
                            auditService.writeAudit("Adaugare birou");
                        }
                        break;
                        case "l": {
                            System.out.println("Noul pret al biroului si id-ul biroului");
                            double pret = keyboard.nextDouble();
                            int id = keyboard.nextInt();
                            Office office = officeService.findOffice(id);
                            office.setPretMp(pret);
                            officeService.updateOffice(office);
                            auditService.writeAudit("Modificare pret birou");
                        }
                        break;
                        case "m": {
                            System.out.println("Id-ul biroului de sters");
                            int id = keyboard.nextInt();
                            Office office = officeService.findOffice(id);
                            officeService.deleteOffice(office);
                            auditService.writeAudit("Stergere birou");
                        }
                        break;
                        case "z": {
                            System.out.println("Parasire meniu admin");

                        }
                        break;
                        default: {
                            System.out.println("Tasta invalida");
                        }
                        break;
                    }
                } while (!key.equals("z"));
            }
            break;
            case 2: {
                String tasta;
                System.out.println("a. Cautare proprietati dupa zona");
                System.out.println("b. Depozite cu o inaltime minima");
                System.out.println("c. Terenuri cu o suprafata minima");
                System.out.println("d. Suprafata maxima disponibila");
                System.out.println("z. Parasire meniu");
                do {
                    System.out.print("Introducere tasta: ");
                    tasta = keyboard.next();
                    switch (tasta) {
                        case "a": {
                            System.out.println("Cautare proprietati dupa zona");
                            System.out.println("Introduceti zona cautata (1/2/3)");
                            int zona_cautata = keyboard.nextInt();
                            if (zona_cautata != 1 && zona_cautata != 2 && zona_cautata != 3) {
                                System.out.println("Nu s-a gasit zona");
                                break;
                            }
                            System.out.println(houseService.findArea(zona_cautata));
                            System.out.println(apartmentDbService.findArea(zona_cautata));
                            System.out.println(officeService.findArea(zona_cautata));
                            proprietati.afisZone(zona_cautata);
                        }
                        break;
                        case "b": {
                            System.out.println("Depozite cu o inaltime minima");
                            System.out.println("Introduceti inaltimea minima");
                            double inaltime = keyboard.nextDouble();
                            for (Depozit depozit : listaDep)
                                depozit.depozitH(inaltime);
                            auditService.writeAudit("Cautare depozite");
                        }
                        break;
                        case "c": {
                            System.out.println("Terenuri cu o suprafata minima");
                            int suprTeren = keyboard.nextInt();
                            for (Teren terenuri : listaTeren)
                                terenuri.terenMare(suprTeren);
                            auditService.writeAudit("Cautare terenuri");
                        }
                        break;
                        case "d": {
                            System.out.println("Suprafata maxima disponibila: ");
                            System.out.println(proprietati.getSuprafMaxima().getSuprafata());
                            proprietati.getDetalii();
                            auditService.writeAudit("Afisare suprafata maxima disponibila");
                        }
                        break;
                        case "z": {
                            System.out.println("Parasire meniu cautare");

                        }
                        break;
                        default: {
                            System.out.println("Tasta invalida");
                        }
                        break;
                    }
                    System.out.println();
                } while (!tasta.equals("z"));
            }
        }
    }
}