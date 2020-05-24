package ro.unibuc.fmi.service;

import ro.unibuc.fmi.Entity.*;

import java.io.*;
import java.util.*;

public class ImobilService {
    private List<Imobil> proprietati = new ArrayList<>();
    private SuprafataComp compSupraf = new SuprafataComp();
    private AuditService audit;
    private ApartamentService apartamentService;
    private BirouService birouService;
    private CasaService casaService;
    private DepozitService depozitService;
    private TerenService terenService;

    public List<Imobil> getProprietati() {
        return proprietati;
    }

    public SuprafataComp getCompSupraf() {
        return compSupraf;
    }

    public Imobil getSuprafMaxima() {
        proprietati.sort(Collections.reverseOrder(compSupraf));
        return proprietati.get(0);
    }

    public void getDetalii() {
        Imobil temp = getSuprafMaxima();
        temp.afisare();
    }


    public void readPropertiesFromFile() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("persistence.txt"))) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                String[] dataFields = currentLine.split(",");
                switch (Integer.parseInt(dataFields[0])) {
                    case 1: {
                        Casa imobil = new Casa(Integer.parseInt(dataFields[0]), dataFields[1], Integer.parseInt(dataFields[2]), Integer.parseInt(dataFields[3]), Double.parseDouble(dataFields[4]), Boolean.parseBoolean(dataFields[5]), Integer.parseInt(dataFields[6]), Integer.parseInt(dataFields[7]), Boolean.parseBoolean(dataFields[8]), Boolean.parseBoolean(dataFields[9]));
                        addImobil(imobil);
                    }
                    break;
                    case 2: {
                        Apartament imobil = new Apartament(Integer.parseInt(dataFields[0]), dataFields[1], Integer.parseInt(dataFields[2]), Integer.parseInt(dataFields[3]), Double.parseDouble(dataFields[4]), Boolean.parseBoolean(dataFields[5]), Integer.parseInt(dataFields[6]), Integer.parseInt(dataFields[7]), Integer.parseInt(dataFields[8]), Boolean.parseBoolean(dataFields[9]));
                        addImobil(imobil);
                    }
                    break;
                    case 3: {
                        Birou imobil = new Birou(Integer.parseInt(dataFields[0]), dataFields[1], Integer.parseInt(dataFields[2]), Integer.parseInt(dataFields[3]), Double.parseDouble(dataFields[4]), Boolean.parseBoolean(dataFields[5]), Integer.parseInt(dataFields[6]), Integer.parseInt(dataFields[7]));
                        addImobil(imobil);
                    }
                    break;
                    case 4: {
                        Depozit imobil = new Depozit(Integer.parseInt(dataFields[0]), dataFields[1], Integer.parseInt(dataFields[2]), Integer.parseInt(dataFields[3]), Double.parseDouble(dataFields[4]), Boolean.parseBoolean(dataFields[5]), Double.parseDouble(dataFields[6]));
                        addImobil(imobil);
                    }
                    break;
                    case 5: {
                        Teren imobil = new Teren(Integer.parseInt(dataFields[0]), dataFields[1], Integer.parseInt(dataFields[2]), Integer.parseInt(dataFields[3]), Double.parseDouble(dataFields[4]), Boolean.parseBoolean(dataFields[5]));
                        addImobil(imobil);
                    }
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Nu s-a putut citi din fisierul: " + e.getMessage());
            return;
        }
    }

    public void afisZone(int zona_cautata) {
        apartamentService.afisZoneApart(zona_cautata);
        casaService.afisZoneCase(zona_cautata);
        birouService.afisZoneBirouri(zona_cautata);
        depozitService.afisZoneDepozite(zona_cautata);
        terenService.afisZoneTerenuri(zona_cautata);
        audit.writeAudit("Afisare dupa zone");
    }

    public void cautareBuget(double pretMin, double pretMax) {
        apartamentService.cautareBuget(pretMin,pretMax);
        casaService.cautareBuget(pretMin,pretMax);
        audit.writeAudit("Cautare dupa Buget");
    }

    public void cautareCump(double pretMin, double pretMax) {
        apartamentService.cautareCump(pretMin,pretMax);
        casaService.cautareCump(pretMin,pretMax);
        audit.writeAudit("Cautare cumparare");
    }

    public void cautareInch(double pretMin, double pretMax) {
        apartamentService.cautareInch(pretMin,pretMax);
        casaService.cautareInch(pretMin,pretMax);
        audit.writeAudit("Cautare inchiriere");
    }

    public void addImobil(Imobil imobil) {
        proprietati.add(imobil);
    }




}
