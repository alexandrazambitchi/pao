package ro.unibuc.fmi;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Persistenta persistenta = Persistenta.getInstance();
        ImobilService proprietati = new ImobilService();

        Agent ag = new Agent();
        Casa c = new Casa();
        Apart ap = new Apart();
        Birou bir = new Birou();
        Depozit dep = new Depozit();
        Teren teren = new Teren();

        BufferedReader fileAg = new BufferedReader(new FileReader("agent.csv"));
        if (fileAg.readLine() != null) {
            proprietati.setListaAgenti(Persistenta.citire(ag, proprietati));
        }

        BufferedReader fileCase = new BufferedReader(new FileReader("casa.csv"));
        if (fileCase.readLine() != null) {
            proprietati.setListaCase(Persistenta.citire(c, proprietati));
        }
        BufferedReader fileAp = new BufferedReader(new FileReader("apart.csv"));
        if (fileAp.readLine() != null) {
            proprietati.setListaApart(Persistenta.citire(ap, proprietati));
        }
        BufferedReader fileBirou = new BufferedReader(new FileReader("birou.csv"));
        if (fileBirou.readLine() != null) {
            proprietati.setListaBirouri(Persistenta.citire(bir, proprietati));
        }
        BufferedReader fileDep = new BufferedReader(new FileReader("depozit.csv"));
        if (fileDep.readLine() != null) {
            proprietati.setListaDep(Persistenta.citire(dep, proprietati));
        }
        BufferedReader fileTeren = new BufferedReader(new FileReader("teren.csv"));
        if (fileTeren.readLine() != null) {
            proprietati.setListaTeren(Persistenta.citire(teren, proprietati));
        }

        List<Agent> listaAgent = proprietati.getListaAgenti();
        List<Casa> listaCase = proprietati.getListaCase();
        List<Apart> listaApart = proprietati.getListaApart();
        List<Birou> listaBirouri = proprietati.getListaBirouri();
        List<Depozit> listaDep = proprietati.getListaDep();
        List<Teren> listaTeren = proprietati.getListaTeren();

        Collections.sort(listaApart);
        proprietati.readPropertiesFromFile();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("1. Acces admin");
        System.out.println("2. Acces client");
        System.out.println("3. Iesire");
        int input = keyboard.nextInt();
        switch (input) {
            case 1: {
                System.out.println("1. Adaugare agent");
                System.out.println("2. Lista agenti");
                System.out.println("3. Iesire");
                int key;
                do {
                    System.out.println("Alegere: ");
                    key = keyboard.nextInt();
                    if (key == 1) {
                        System.out.println("Datele noului agent: (id, nume, zona)");
                        int idAng = keyboard.nextInt();
                        String numeAng = keyboard.next();
                        int zonaAng = keyboard.nextInt();
                        proprietati.addAgent(idAng, numeAng, zonaAng);
                        listaAgent = proprietati.getListaAgenti();

                    } else if (key == 2) {
                        for (Agent agent : listaAgent)
                            agent.afisare();
                        proprietati.writeAudit("Afisare agenti");
                    }
                } while (key != 3);
            }break;
            case 2: {
                String tasta;
                System.out.println("a. Cautare proprietati dupa zona");
                System.out.println("b. Afisare proprietati disponibile intre 2 sume");
                System.out.println("c. Afisare case care dispun si de gradina si de piscina");
                System.out.println("d. Case de vanzare intr-o anumita zona");
                System.out.println("e. Apartamente care se afla cel putin la un anumit etaj");
                System.out.println("f. Proprietati de cumparat intr-un anumit buget");
                System.out.println("g. Proprietati de inchiriat intr-un anumit buget");
                System.out.println("h. Depozite cu o inaltime minima");
                System.out.println("i. Birouri cu un numar minim de etaje");
                System.out.println("j. Terenuri cu o suprafata minima");
                System.out.println("k. Suprafata maxima disponibila");
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
                            proprietati.afisZone(zona_cautata);
                        }
                        break;
                        case "b": {
                            System.out.println("Afisare proprietati disponibile intre 2 sume");
                            System.out.println("Pret minim-maxim (min: 400, maxim: 110001)");
                            double pretMin = keyboard.nextDouble();
                            double pretMax = keyboard.nextDouble();
                            proprietati.cautareBuget(pretMin, pretMax);
                        }
                        break;
                        case "c": {
                            System.out.println("Afisare case care dispun si de gradina si de piscina");
                            for (Casa casa : listaCase)
                                casa.CaseGradinasiPiscina();
                            proprietati.writeAudit("Cautari case");
                        }
                        break;
                        case "d": {
                            System.out.println("Case de vanzare intr-o anumita zona");
                            System.out.println("Zona (1/2/3)");
                            int zona_cautata = keyboard.nextInt();
                            if (zona_cautata != 1 && zona_cautata != 2 && zona_cautata != 3) {
                                System.out.println("Nu s-a gasit zona");
                                break;
                            }
                            for (Casa casa : listaCase)
                                casa.casaVanzZona(zona_cautata);
                            proprietati.writeAudit("Cautare case de vanzare");
                        }
                        break;
                        case "e": {
                            System.out.println("Apartamente care se afla cel putin la un anumit etaj");
                            int etaj = keyboard.nextInt();
                            for (Apart apart : listaApart)
                                apart.apartamentEtaj(etaj);
                            proprietati.writeAudit("Cautare apartamente");
                        }
                        break;
                        case "f": {
                            System.out.println("Proprietati de cumparat intr-un anumit buget");
                            System.out.println("Pret minim-maxim (min: 9350, max:110001)");
                            double pretMin = keyboard.nextDouble();
                            double pretMax = keyboard.nextDouble();
                            proprietati.cautareCump(pretMin, pretMax);
                        }
                        break;
                        case "g": {
                            System.out.println("Proprietati de inchiriat intr-un anumit buget");
                            System.out.println("Pret minim-maxim (min: 400, max: 6702)");
                            double pretMin = keyboard.nextDouble();
                            double pretMax = keyboard.nextDouble();
                            proprietati.cautareInch(pretMin, pretMax);
                        }
                        break;
                        case "h": {
                            System.out.println("Depozite cu o inaltime minima");
                            System.out.println("Introduceti inaltimea minima");
                            double inaltime = keyboard.nextDouble();
                            for (Depozit depozit : listaDep)
                                depozit.depozitH(inaltime);
                            proprietati.writeAudit("Cautare depozite");
                        }
                        break;
                        case "i": {
                            System.out.println("Birouri cu un numar minim de etaje");
                            int etaje = keyboard.nextInt();
                            for (Birou birou : listaBirouri)
                                birou.birouriEtaje(etaje);
                            proprietati.writeAudit("Cautare birouri");
                        }
                        break;
                        case "j": {
                            System.out.println("Terenuri cu o suprafata minima");
                            int suprTeren = keyboard.nextInt();
                            for (Teren terenuri : listaTeren)
                                terenuri.terenMare(suprTeren);
                            proprietati.writeAudit("Cautare terenuri");
                        }
                        break;
                        case "k": {
                            System.out.println("Suprafata maxima disponibila: ");
                            System.out.println(proprietati.getSuprafMaxima().getSuprafata());
                            proprietati.getDetalii();
                            proprietati.writeAudit("Afisare suprafata maxima disponibila");
                        }break;
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
