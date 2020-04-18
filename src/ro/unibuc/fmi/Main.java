package ro.unibuc.fmi;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        readFromFile();

        ImobilService proprietati = new ImobilService();
        proprietati.readPropertiesFromFile();

        proprietati.writePropertiesToFile();

        List<String> actiuni= new ArrayList<>();
        List<Casa> listaCase = proprietati.getListaCase();
        List<Apart> listaApart = proprietati.getListaApart();
        List<Birou> listaBirouri = proprietati.getListaBirouri();
        List<Depozit> listaDep = proprietati.getListaDep();
        Set<Teren> listaTeren = proprietati.getListaTeren();

        Collections.sort(listaApart);

        Scanner keyboard = new Scanner(System.in);
        System.out.println("1. Acces admin");
        System.out.println("2. Acces client");
        System.out.println("3. Iesire");
        int input = keyboard.nextInt();
        switch (input) {
            case 1: {
                System.out.println("1. Schimbare pret proprietati");
                System.out.println("2. Iesire");
                int key;
                do {
                    key = keyboard.nextInt();
                    if (key == 1) {
                        System.out.println("Introducere procent crestere/scadere pret (ex 30 pt 30%)");
                        int value = keyboard.nextInt();
                        proprietati.modificarePret(value);
                        actiuni.add("Modificare pret");
                    }
                } while (key != 2);
            }
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
                            for (Depozit dep : listaDep)
                                dep.afisare_zona(zona_cautata);
                            System.out.println("Terenuri");
                            for (Imobil teren : listaTeren)
                                teren.afisare_zona(zona_cautata);
                            actiuni.add("Cautare dupa zona");
                        }
                        break;
                        case "b": {
                            System.out.println("Afisare proprietati disponibile intre 2 sume");
                            System.out.println("Pret minim-maxim (min: 400, maxim: 110001)");
                            double pretMin = keyboard.nextDouble();
                            double pretMax = keyboard.nextDouble();
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
                            for (Imobil dep : listaDep)
                                dep.cautarePret(pretMin, pretMax);
                            System.out.println("Terenuri");
                            for (Imobil teren : listaTeren)
                                teren.cautarePret(pretMin, pretMax);
                            actiuni.add("Cautari dupa buget");
                        }
                        break;
                        case "c": {
                            System.out.println("Afisare case care dispun si de gradina si de piscina");
                            for (Casa casa : listaCase)
                                casa.CaseGradinasiPiscina();
                            actiuni.add("Cautari case");
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
                            actiuni.add("Case de vanzare");
                        }
                        break;
                        case "e": {
                            System.out.println("Apartamente care se afla cel putin la un anumit etaj");
                            int etaj = keyboard.nextInt();
                            for (Apart apart : listaApart)
                                apart.apartamentEtaj(etaj);
                            actiuni.add("Cautare apartamente");
                        }
                        break;
                        case "f": {
                            System.out.println("Proprietati de cumparat intr-un anumit buget");
                            System.out.println("Pret minim-maxim (min: 9350, max:110001)");
                            double pretMin = keyboard.nextDouble();
                            double pretMax = keyboard.nextDouble();
                            System.out.println("Apartamente");
                            for (Apart apart : listaApart)
                                apart.cautarePretCump(pretMin, pretMax);
                            System.out.println("Case");
                            for (Casa casa : listaCase)
                                casa.cautarePretCump(pretMin, pretMax);
                            System.out.println("Depozite");
                            for (Depozit dep : listaDep)
                                dep.cautarePretCump(pretMin, pretMax);
                            System.out.println("Terenuri");
                            for (Imobil teren : listaTeren)
                                teren.cautarePret(pretMin, pretMax);
                            actiuni.add("Cautare proprietati de cumparat");
                        }
                        break;
                        case "g": {
                            System.out.println("Proprietati de inchiriat intr-un anumit buget");
                            System.out.println("Pret minim-maxim (min: 400, max: 6702)");
                            double pretMin = keyboard.nextDouble();
                            double pretMax = keyboard.nextDouble();
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
                            for (Depozit dep : listaDep)
                                dep.cautarePretInch(pretMin, pretMax);
                            actiuni.add("Cautare proprietati de inchiriat");
                        }
                        break;
                        case "h": {
                            System.out.println("Depozite cu o inaltime minima");
                            System.out.println("Introduceti inaltimea minima");
                            double inaltime = keyboard.nextDouble();
                            for (Depozit dep : listaDep)
                                dep.depozitH(inaltime);
                            actiuni.add("Cautare depozite");
                        }
                        break;
                        case "i": {
                            System.out.println("Birouri cu un numar minim de etaje");
                            int etaje = keyboard.nextInt();
                            for (Birou birou : listaBirouri)
                                birou.birouriEtaje(etaje);
                            actiuni.add("Cautare birouri");
                        }
                        break;
                        case "j": {
                            System.out.println("Terenuri cu o suprafata minima");
                            int suprTeren = keyboard.nextInt();
                            for (Teren teren : listaTeren)
                                teren.terenMare(suprTeren);
                            actiuni.add("Cautare terenuri");
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

        proprietati.afisarePropr();
        System.out.println("Suprafata maxima disponibila: ");
        System.out.println(proprietati.getSuprafMaxima().getSuprafata());
        proprietati.getDetalii();
        proprietati.writeAudit(actiuni);
    }

    public static void readFromFile() throws IOException {
        InputStreamReader inputStreamReader = new FileReader("read.txt");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String currentLine;
        while ((currentLine = bufferedReader.readLine()) != null) {
            System.out.println("Read line: " + currentLine);
        }
        bufferedReader.close();
    }

}
