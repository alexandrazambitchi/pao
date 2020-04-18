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
    private List<Teren> listaTeren = new ArrayList<>();
    private List<Agent> listaAgenti = new ArrayList<>();

    public void setListaCase(List<Casa> listaCase) {
        this.listaCase = listaCase;
    }

    public void setListaApart(List<Apart> listaApart) {
        this.listaApart = listaApart;
    }

    public void setListaBirouri(List<Birou> listaBirouri) {
        this.listaBirouri = listaBirouri;
    }

    public void setListaDep(List<Depozit> listaDep) {
        this.listaDep = listaDep;
    }

    public void setListaTeren(List<Teren> listaTeren) {
        this.listaTeren = listaTeren;
    }

    public List<Agent> getListaAgenti() {
        return listaAgenti;
    }

    public void setListaAgenti(List<Agent> listaAgenti) {
        this.listaAgenti = listaAgenti;
    }

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

    public List<Teren> getListaTeren() {
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
                        addImobil(imobil);
                    }
                    break;
                    case 2: {
                        Apart imobil = new Apart(Integer.parseInt(dataFields[0]), dataFields[1], Integer.parseInt(dataFields[2]), Integer.parseInt(dataFields[3]), Double.parseDouble(dataFields[4]), Boolean.parseBoolean(dataFields[5]), Integer.parseInt(dataFields[6]), Integer.parseInt(dataFields[7]), Integer.parseInt(dataFields[8]), Boolean.parseBoolean(dataFields[9]));
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
        System.out.println("Apartamente");
        for (Apart apart : listaApart)
            apart.afisare_zona(zona_cautata);
        System.out.println("Case");
        for (Casa casa : listaCase)
            casa.afisare_zona(zona_cautata);
        System.out.println("Birouri");
        for (Birou birou : listaBirouri)
            birou.afisare_zona(zona_cautata);
        System.out.println("Depozite");
        for (Depozit depozit : listaDep)
            depozit.afisare_zona(zona_cautata);
        System.out.println("Terenuri");
        for (Imobil terenuri : listaTeren)
            terenuri.afisare_zona(zona_cautata);
        writeAudit("Afisare dupa zone");
    }

    public void cautareBuget(double pretMin, double pretMax) {
        System.out.println("Apartamente");
        for (Imobil apart : listaApart)
            apart.cautarePret(pretMin, pretMax);
        System.out.println("Case");
        for (Imobil casa : listaCase)
            casa.cautarePret(pretMin, pretMax);
        System.out.println("Birouri");
        for (Imobil birou : listaBirouri)
            birou.cautarePret(pretMin, pretMax);
        System.out.println("Depozite");
        for (Imobil depozit : listaDep)
            depozit.cautarePret(pretMin, pretMax);
        System.out.println("Terenuri");
        for (Imobil terenuri : listaTeren)
            terenuri.cautarePret(pretMin, pretMax);
        writeAudit("Cautare dupa Buget");
    }

    public void cautareCump(double pretMin, double pretMax) {
        System.out.println("Apartamente");
        for (Apart apart : listaApart)
            apart.cautarePretCump(pretMin, pretMax);
        System.out.println("Case");
        for (Casa casa : listaCase)
            casa.cautarePretCump(pretMin, pretMax);
        System.out.println("Depozite");
        for (Depozit depozit : listaDep)
            depozit.cautarePretCump(pretMin, pretMax);
        System.out.println("Terenuri");
        for (Imobil terenuri : listaTeren)
            terenuri.cautarePret(pretMin, pretMax);
        writeAudit("Cautare cumparare");
    }

    public void cautareInch(double pretMin, double pretMax) {
        System.out.println("Apartamente");
        for (Apart apart : listaApart)
            apart.cautarePretInch(pretMin, pretMax);
        System.out.println("Case");
        for (Casa casa : listaCase)
            casa.cautarePretInch(pretMin, pretMax);
        System.out.println("Birouri");
        for (Birou birou : listaBirouri)
            birou.cautarePretInch(pretMin, pretMax);
        System.out.println("Depozite");
        for (Depozit depozit : listaDep)
            depozit.cautarePretInch(pretMin, pretMax);
        writeAudit("Cautare inchiriere");
    }

    public void addImobil(Imobil imobil) {
        proprietati.add(imobil);
    }

    public void addAgent(int id, String nume, int zona) {
        Agent ag = new Agent(id, nume, zona);
        listaAgenti.add(ag);
        writeAudit("Adaugare agent");
    }

    public void writeAudit(String actiuni) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("audit.csv", true))) {
            Date date = new Date();
            bufferedWriter.write(actiuni + "," + date.toString());
            bufferedWriter.newLine();
        } catch (IOException e) {
            System.out.println("Nu s-a putut scrie din fisierul: " + e.getMessage());
            return;
        }

    }
}
