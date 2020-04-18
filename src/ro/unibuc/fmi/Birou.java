package ro.unibuc.fmi;

public class Birou extends Imobil implements Inchiriere {
    private int nrNivele;
    private int etaj;

    public Birou() {

    }

    public Birou(int id, String adresa, int zona, int suprafata, double pretMp, boolean inchiriere, int nrNivele, int etaj) {
        super(id, adresa, zona, suprafata, pretMp, inchiriere);
        this.nrNivele = nrNivele;
        this.etaj = etaj;
    }

    public int getNrNivele() {
        return nrNivele;
    }

    public int getEtaj() {
        return etaj;
    }

    @Override
    public double pretLuna() {
        double suma = 0;
        if (getZona() == 1) {
            if (etaj > 5)
                suma = getPretMp() * getSuprafata() * 1.5;
            else suma = getPretMp() * getSuprafata() * 1.3;
        }
        if (getZona() == 2) {
            if (etaj > 5)
                suma = getPretMp() * getSuprafata() * 1.4;
            else suma = getPretMp() * getSuprafata() * 1.2;
        }
        if (getZona() == 3) {
            if (etaj > 5)
                suma = getPretMp() * getSuprafata() * 1.3;
            else suma = getPretMp() * getSuprafata() * 1.1;
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
    public void cautarePret(double x, double y) {
        if (totalCheltuieli() > x && totalCheltuieli() < y)
            afisare();
    }

    public void cautarePretInch(double x, double y) {
        if (pretLuna() > x && pretLuna() < y)
            afisare();
    }

    public void birouriEtaje(int value) {
        if (nrNivele >= value)
            afisare();
    }

    @Override
    public void afisare_zona(int zona_cautata) {
        if (getZona() == zona_cautata)
            afisare();
    }

}
