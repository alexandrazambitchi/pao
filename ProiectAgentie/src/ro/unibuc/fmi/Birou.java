package ro.unibuc.fmi;

public class Birou extends Imobil implements Inchiriere {
    private int nrNivele, etaj;
    private double pretMp;

    public Birou(String adresa, int zona, int suprafata, int nrNivele, int etaj, double pretMp) {
        super(adresa, zona, suprafata);
        this.nrNivele = nrNivele;
        this.etaj = etaj;
        this.pretMp = pretMp;
    }

    @Override
    public double pretLuna() {
        double suma = 0;
        if (getZona() == 1) {
            if (etaj > 5)
                suma =  pretMp * getSuprafata() * 1.5;
            else suma = pretMp * getSuprafata() * 1.3;
        }
        if (getZona() == 2) {
            if (etaj > 5)
                suma = pretMp * getSuprafata() * 1.4;
            else suma = pretMp * getSuprafata() * 1.2;
        }
        if (getZona() == 3) {
            if (etaj > 5)
                suma = pretMp * getSuprafata() * 1.3;
            else suma = pretMp * getSuprafata() * 1.1;
        }
        return suma;
    }

    @Override
    public double cheltuieliFixe() {
        double suma = 0;
        if (getZona() == 1) {
            if (etaj > 5)
                suma = nrNivele * 1.5 + 200;
            else suma = nrNivele * 1.3 + 200;
        }
        if (getZona() == 2) {
            if (etaj > 5)
                suma = nrNivele * 1.4 + 150;
            else suma = nrNivele * 1.2 + 150;
        }
        if (getZona() == 3) {
            if (etaj > 5)
                suma = nrNivele * 1.3 + 100;
            else suma = nrNivele * 1.1 + 100;
        }
        return suma;
    }

    @Override
    public double totalCheltuieli() {
        return pretLuna() + cheltuieliFixe();
    }

    @Override
    public void afisare() {
        System.out.println("Biroul se afla in zona " + getZona() + ", " + getAdresa() + ", la etajul " + etaj);
        System.out.println("Are suprafata " + getSuprafata() + ", impartita in " + nrNivele + " etaj(e)");
        System.out.println("Pret chirie pe luna: " + pretLuna());
        System.out.println("Cheltuieli fixe: " + cheltuieliFixe());
        System.out.println("Total " + totalCheltuieli());
    }

    @Override
    public void afisare_zona(int value) {
        if (value == getZona())
            afisare();
    }

    @Override
    public void cautarePret(double x, double y) {
        if (totalCheltuieli() > x && totalCheltuieli() < y)
            afisare();
    }

    @Override
    public void CaseGradinasiPiscina() {
    }

    @Override
    public void apartamentEtaj(int value) {
    }

    @Override
    public void cautarePretCump(double x, double y) {
    }

    @Override
    public void cautarePretInch(double x, double y) {
        if (pretLuna() > x && pretLuna() < y)
            afisare();
    }

    @Override
    public void casaVanzZona(int value) {
    }

    @Override
    public void apartTerasaZona(int value) {
    }

    @Override
    public void depozitH(double value) {
    }

    @Override
    public void birouriEtaje(int value) {
        if(nrNivele>=value)
            afisare();
    }

    @Override
    public void terenMare(int value) {
    }
}
