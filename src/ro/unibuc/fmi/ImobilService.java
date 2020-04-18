package ro.unibuc.fmi;

import java.io.*;
import java.util.*;

public class ImobilService {
    private List<Imobil> proprietati = new ArrayList<>();
    private SuprafComp compSupraf = new SuprafComp();
    private List<Casa> listaCase = new ArrayList<>();
    private List<Apart> listaApart = new ArrayList<>();
    private List<Birou> listaBirouri = new ArrayList<>();
    private List<Depozit> listaDep = new ArrayList<>();
    private Set<Teren> listaTeren = new HashSet<>();

    public List<Casa> getListaCase() {
        return listaCase;
    }

    public List<Apart> getListaApart() {
        return listaApart;
    }

    public List<Birou> getListaBirouri() {
        return listaBirouri;
    }

    public List<Depozit> getListaDep() {
        return listaDep;
    }

    public Set<Teren> getListaTeren() {
        return listaTeren;
    }

    public List<Imobil> getProprietati() {
        return proprietati;
    }

    public SuprafComp getCompSupraf() {
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
                        addCasa(imobil);
                        addImobil(imobil);
                    }
                    break;
                    case 2: {
                        Apart imobil = new Apart(Integer.parseInt(dataFields[0]), dataFields[1], Integer.parseInt(dataFields[2]), Integer.parseInt(dataFields[3]), Double.parseDouble(dataFields[4]), Boolean.parseBoolean(dataFields[5]), Integer.parseInt(dataFields[6]), Integer.parseInt(dataFields[7]), Integer.parseInt(dataFields[8]), Boolean.parseBoolean(dataFields[9]));
                        addApart(imobil);
                        addImobil(imobil);
                    }
                    break;
                    case 3: {
                        Birou imobil = new Birou(Integer.parseInt(dataFields[0]), dataFields[1], Integer.parseInt(dataFields[2]), Integer.parseInt(dataFields[3]), Double.parseDouble(dataFields[4]), Boolean.parseBoolean(dataFields[5]), Integer.parseInt(dataFields[6]), Integer.parseInt(dataFields[7]));
                        addBirou(imobil);
                        addImobil(imobil);
                    }
                    break;
                    case 4: {
                        Depozit imobil = new Depozit(Integer.parseInt(dataFields[0]), dataFields[1], Integer.parseInt(dataFields[2]), Integer.parseInt(dataFields[3]), Double.parseDouble(dataFields[4]), Boolean.parseBoolean(dataFields[5]), Double.parseDouble(dataFields[6]));
                        addDep(imobil);
                        addImobil(imobil);
                    }
                    break;
                    case 5: {
                        Teren imobil = new Teren(Integer.parseInt(dataFields[0]), dataFields[1], Integer.parseInt(dataFields[2]), Integer.parseInt(dataFields[3]), Double.parseDouble(dataFields[4]), Boolean.parseBoolean(dataFields[5]));
                        addTeren(imobil);
                        addImobil(imobil);
                    }
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Nu s-a putut citi din fisierul: " + e.getMessage());
            return;
        }
        System.out.println("S-au citit cu succes " + proprietati.size() + " proprietati!");
    }

    public void writePropertiesToFile() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("persistence.txt"))) {
            for (Casa casa : listaCase) {
                bufferedWriter.write(casa.getId() + "," + casa.getAdresa() + "," + casa.getZona() + "," + casa.getSuprafata() + "," + casa.getPretMp() + "," + casa.isInchiriere() + "," + casa.getNrNivele() + "," + casa.getNrCamere() + "," + casa.isPiscina() + "," + casa.isGradina());
                bufferedWriter.newLine();
            }
            for (Apart apart : listaApart) {
                bufferedWriter.write(apart.getId() + "," + apart.getAdresa() + "," + apart.getZona() + "," + apart.getSuprafata() + "," + apart.getPretMp() + "," + apart.isInchiriere() + "," + apart.getEtaj() + "," + apart.getNrBai() + "," + apart.getNrCamere() + "," + apart.isTerasa());
                bufferedWriter.newLine();
            }
            for (Birou birou : listaBirouri) {
                bufferedWriter.write(birou.getId() + "," + birou.getAdresa() + "," + birou.getZona() + "," + birou.getSuprafata() + "," + birou.getPretMp() + "," + birou.isInchiriere() + "," + birou.getNrNivele() + "," + birou.getEtaj());
                bufferedWriter.newLine();
            }
            for (Depozit dep : listaDep) {
                bufferedWriter.write(dep.getId() + "," + dep.getAdresa() + "," + dep.getZona() + "," + dep.getSuprafata() + "," + dep.getPretMp() + "," + dep.isInchiriere() + "," + dep.getInaltime());
                bufferedWriter.newLine();
            }
            for (Imobil teren : listaTeren) {
                bufferedWriter.write(teren.getId() + "," + teren.getAdresa() + "," + teren.getZona() + "," + teren.getSuprafata() + "," + teren.getPretMp() + "," + teren.isInchiriere());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Nu s-a putut scrie din fisierul: " + e.getMessage());
            return;
        }
        System.out.println("S-au scris cu succes " + proprietati.size() + " proprietati!");
    }

    public void addImobil(Imobil imobil) {
        proprietati.add(imobil);
    }

    public void addCasa(Casa imobil) {
        listaCase.add(imobil);
    }

    public void addApart(Apart imobil) {
        listaApart.add(imobil);
    }

    public void addBirou(Birou imobil) {
        listaBirouri.add(imobil);
    }

    public void addDep(Depozit imobil) {
        listaDep.add(imobil);
    }

    public void addTeren(Teren imobil) {
        listaTeren.add(imobil);
    }

    public void afisarePropr() {
        System.out.println(proprietati.size());
        for (Imobil imobil : proprietati) {
            imobil.afisare();
        }
    }

    public void modificarePret(int procent) {
        for (Imobil imobil : proprietati)
            imobil.setPretMp(imobil.getPretMp() * (1 + (procent / 100)));
    }

    public void writeAudit(List<String> actiuni) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("audit.csv"))) {
            for (String actiune : actiuni) {
                Date date = new Date();
                bufferedWriter.write(actiune + "," + date.toString());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Nu s-a putut scrie din fisierul: " + e.getMessage());
            return;
        }

    }
}
