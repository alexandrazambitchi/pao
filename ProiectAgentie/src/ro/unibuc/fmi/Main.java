package ro.unibuc.fmi;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        CasaVanz casav1 = new CasaVanz("Bucuresti", 2, 100, 2, 5, false, true, 100);
        CasaInch casai1 = new CasaInch("Bucuresti", 1, 70, 1, 4, true, true, 200);
        ApartInch api1 = new ApartInch("Ilfov", 2, 200, 3, 2, 4, true, 10.5);
        ApartVanz apv1 = new ApartVanz("Ilfov", 3, 300, 2, 2, 4, true, 30);
        ApartInch api2 = new ApartInch("Ilfov", 2, 200, 7, 1, 2, true, 40);
        Birou birou1 = new Birou("Bucuresti", 1, 100, 2, 5, 50);
        Birou birou2 = new Birou("Bucuresti", 1, 150, 3, 15, 100);
        DepozitInch depi1 = new DepozitInch("Ilfov", 3, 150, 2.5, 50);
        DepozitInch depi2 = new DepozitInch("Ilfov", 2, 200, 3.5, 70);
        DepozitVanz depv1 = new DepozitVanz("Bucuresti", 3, 250, 2, 55);
        Teren teren1 = new Teren("Bucuresti", 2, 170, 50);
        Teren teren2 = new Teren("Ilfov", 1, 200, 60);

        List<Imobil> listaCase = new ArrayList<>();
        List<Imobil> listaApart = new ArrayList<>();
        List<Imobil> listaBirouri = new ArrayList<>();
        List<Imobil> listaDep = new ArrayList<>();
        Set<Imobil> listaTeren = new HashSet<>();
        listaCase.add(casav1);
        listaCase.add(casai1);
        listaApart.add(api1);
        listaApart.add(apv1);
        listaApart.add(api2);
        listaBirouri.add(birou1);
        listaBirouri.add(birou2);
        listaDep.add(depi1);
        listaDep.add(depi2);
        listaDep.add(depv1);
        listaTeren.add(teren1);
        listaTeren.add(teren2);

        Collections.sort(listaApart);

        System.out.println("Cautare proprietati dupa zona");
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Introduceti zona cautata (1/2/3)");
        int zona_cautata = keyboard.nextInt();
        System.out.println("Apartamente");
        for (Imobil apart : listaApart)
            apart.afisare_zona(zona_cautata);
        System.out.println("Case");
        for (Imobil casa : listaCase)
            casa.afisare_zona(zona_cautata);
        System.out.println("Birouri");
        for (Imobil birou : listaBirouri)
            birou.afisare_zona(zona_cautata);
        System.out.println("Depozite");
        for (Imobil dep : listaDep)
            dep.afisare_zona(zona_cautata);
        System.out.println("Terenuri");
        for (Imobil teren : listaTeren)
            teren.afisare_zona(zona_cautata);

        System.out.println();
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

        System.out.println();
        System.out.println("Afisare case care dispun si de gradina si de piscina");
        for (Imobil casa : listaCase)
            casa.CaseGradinasiPiscina();

        System.out.println();
        System.out.println("Case de vanzare intr-o anumita zona");
        System.out.println("Zona (1/2/3)");
        zona_cautata = keyboard.nextInt();
        for (Imobil casa : listaCase)
            casa.casaVanzZona(zona_cautata);

        System.out.println();
        System.out.println("Apartamente care se afla cel putin la un anumit etaj");
        int etaj = keyboard.nextInt();
        for (Imobil apart : listaApart)
            apart.apartamentEtaj(etaj);

        System.out.println();
        System.out.println("Proprietati de cumparat intr-un anumit buget");
        System.out.println("Pret minim-maxim (min: 9350, max:110001)");
        pretMin = keyboard.nextDouble();
        pretMax = keyboard.nextDouble();
        System.out.println("Apartamente");
        for (Imobil apart : listaApart)
            apart.cautarePretCump(pretMin, pretMax);
        System.out.println("Case");
        for (Imobil casa : listaCase)
            casa.cautarePretCump(pretMin, pretMax);
        System.out.println("Depozite");
        for (Imobil dep : listaDep)
            dep.cautarePretCump(pretMin, pretMax);
        System.out.println("Terenuri");
        for (Imobil teren : listaTeren)
            teren.cautarePretCump(pretMin, pretMax);

        System.out.println();
        System.out.println("Proprietati de inchiriat intr-un anumit buget");
        System.out.println("Pret minim-maxim (min: 400, max: 6702)");
        pretMin = keyboard.nextDouble();
        pretMax = keyboard.nextDouble();
        System.out.println("Apartamente");
        for (Imobil apart : listaApart)
            apart.cautarePretInch(pretMin, pretMax);
        System.out.println("Case");
        for (Imobil casa : listaCase)
            casa.cautarePretInch(pretMin, pretMax);
        System.out.println("Birouri");
        for (Imobil birou : listaBirouri)
            birou.cautarePretInch(pretMin, pretMax);
        System.out.println("Depozite");
        for (Imobil dep : listaDep)
            dep.cautarePretInch(pretMin, pretMax);

        System.out.println();
        System.out.println("Apartamente cu terasa intr-o anumita zona");
        System.out.println("Zona (1/2/3)");
        zona_cautata = keyboard.nextInt();
        for (Imobil apart : listaApart)
            apart.apartTerasaZona(zona_cautata);

        System.out.println();
        System.out.println("Depozite cu o inaltime minima");
        System.out.println("Introduceti inaltimea minima");
        double inaltime = keyboard.nextDouble();
        for (Imobil dep : listaDep)
            dep.depozitH(inaltime);

        System.out.println();
        System.out.println("Birouri cu un numar minim de etaje");
        int etaje = keyboard.nextInt();
        for (Imobil birou : listaBirouri)
            birou.birouriEtaje(etaje);

        System.out.println();
        System.out.println("Terenuri cu o suprafata minima");
        int suprTeren = keyboard.nextInt();
        for (Imobil teren : listaTeren)
            teren.terenMare(suprTeren);

        System.out.println();
        ImobilService comparSupr = new ImobilService();
        comparSupr.register(casai1);
        comparSupr.register(casav1);
        comparSupr.register(api1);
        comparSupr.register(api2);
        comparSupr.register(apv1);
        comparSupr.register(birou1);
        comparSupr.register(birou2);

        System.out.println("Suprafata maxima disponibila: ");
        System.out.println(comparSupr.getSuprafMaxima().getSuprafata());
        comparSupr.getDetalii();

    }
}
