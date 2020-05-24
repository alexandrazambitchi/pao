package ro.unibuc.fmi.persistence;

import ro.unibuc.fmi.Entity.*;

import java.io.*;
import java.util.*;

public class PersistenceRead {

    private static PersistenceRead serviciu = null;

    private PersistenceRead() {
    }

    public static PersistenceRead getInstance() {
        if (serviciu == null)
            serviciu = new PersistenceRead();
        return serviciu;
    }

    /*public List<Casa> citireCasa() {
        List<Casa> listaCasa = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("casa.csv"))) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                String[] dataFields = currentLine.split(",");
                Casa imobil = new Casa(Integer.parseInt(dataFields[0]), dataFields[1], Integer.parseInt(dataFields[2]), Integer.parseInt(dataFields[3]), Double.parseDouble(dataFields[4]), Boolean.parseBoolean(dataFields[5]), Integer.parseInt(dataFields[6]), Integer.parseInt(dataFields[7]), Boolean.parseBoolean(dataFields[8]), Boolean.parseBoolean(dataFields[9]));
                listaCasa.add(imobil);
            }
        } catch (IOException e) {
            System.out.println("Could not read data from file: " + e.getMessage());
            return null;
        }
        return listaCasa;
    }

    public List<Apartament> citireApartament() {
        List<Apartament> listaAp = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("apartament.csv"))) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                String[] dataFields = currentLine.split(",");
                Apartament imobil = new Apartament(Integer.parseInt(dataFields[0]), dataFields[1], Integer.parseInt(dataFields[2]), Integer.parseInt(dataFields[3]), Double.parseDouble(dataFields[4]), Boolean.parseBoolean(dataFields[5]), Integer.parseInt(dataFields[6]), Integer.parseInt(dataFields[7]), Integer.parseInt(dataFields[8]), Boolean.parseBoolean(dataFields[9]));
                listaAp.add(imobil);
            }
        } catch (IOException e) {
            System.out.println("Could not read data from file: " + e.getMessage());
            return null;
        }
        return listaAp;
    }

    public List<Birou> citireBirou() {
        List<Birou> listaBirou = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("birou.csv"))) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                String[] dataFields = currentLine.split(",");
                Birou imobil = new Birou(Integer.parseInt(dataFields[0]), dataFields[1], Integer.parseInt(dataFields[2]), Integer.parseInt(dataFields[3]), Double.parseDouble(dataFields[4]), Boolean.parseBoolean(dataFields[5]), Integer.parseInt(dataFields[6]), Integer.parseInt(dataFields[7]));
                listaBirou.add(imobil);
            }
        } catch (IOException e) {
            System.out.println("Could not read data from file: " + e.getMessage());
            return null;
        }
        return listaBirou;
    }*/

    public List<Depozit> citireDepozit() {
        List<Depozit> listaDep = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("depozit.csv"))) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                String[] dataFields = currentLine.split(",");
                Depozit imobil = new Depozit(Integer.parseInt(dataFields[0]), dataFields[1], Integer.parseInt(dataFields[2]), Integer.parseInt(dataFields[3]), Double.parseDouble(dataFields[4]), Boolean.parseBoolean(dataFields[5]), Double.parseDouble(dataFields[6]));
                listaDep.add(imobil);
            }
        } catch (IOException e) {
            System.out.println("Could not read data from file: " + e.getMessage());
            return null;
        }
        return listaDep;
    }

    public List<Teren> citireTeren() {
        List<Teren> listaTeren = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("teren.csv"))) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                String[] dataFields = currentLine.split(",");
                Teren imobil = new Teren(Integer.parseInt(dataFields[0]), dataFields[1], Integer.parseInt(dataFields[2]), Integer.parseInt(dataFields[3]), Double.parseDouble(dataFields[4]), Boolean.parseBoolean(dataFields[5]));
                listaTeren.add(imobil);
            }
        } catch (IOException e) {
            System.out.println("Could not read data from file: " + e.getMessage());
            return null;
        }
        return listaTeren;
    }

    /*public List<Agent> citireAgent() {
        List<Agent> listaAgent = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("agent.csv"))) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                String[] dataFields = currentLine.split(",");
                Agent imobil = new Agent(Integer.parseInt(dataFields[0]), dataFields[1], Integer.parseInt(dataFields[2]));
                listaAgent.add(imobil);
            }
        } catch (IOException e) {
            System.out.println("Could not read data from file: " + e.getMessage());
            return null;
        }
        return listaAgent;
    }*/

}

