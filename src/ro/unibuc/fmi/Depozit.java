package ro.unibuc.fmi;

public class Depozit extends Imobil implements Vanzare, Inchiriere {
    private double inaltime;

    public Depozit(int id, String adresa, int zona, int suprafata, double pretMp, boolean inchiriere, double inaltime) {
        super(id, adresa, zona, suprafata, pretMp, inchiriere);
        this.inaltime = inaltime;
    }

    public double getInaltime() {
        return inaltime;
    }

    @Override
    public double pret() {
        if (inaltime > 2.5)
            return getPretMp() * getSuprafata() * 1.4;
        return getPretMp() * getSuprafata() * 1.2;
    }

    @Override
    public double pretLuna() {
        if (inaltime > 2.5)
            return (getPretMp() * getSuprafata() * 1.1) / 12;
        return (getPretMp() * getSuprafata()) / 12;
    }

    @Override
    public double cheltuieliFixe() {
        return getZona() * 100 + 100;
    }

    @Override
    public double totalCheltuieli() {
        return pretLuna() + cheltuieliFixe();
    }

    @Override
    public void afisare() {
        if (!isInchiriere()) {
            System.out.println("Depozitul de vanzare se afla in zona " + getZona() + ", " + getAdresa());
            System.out.println("Are suprafata " + getSuprafata() + "mp si inaltimea " + inaltime + "m");
            System.out.println("Pret " + pret());
        } else {
            System.out.println("Depozitul de inchiriat se afla in zona " + getZona() + ", " + getAdresa());
            System.out.println("Are suprafata " + getSuprafata() + "mp si inaltimea " + inaltime + "m");
            System.out.println("Pret pe luna " + pretLuna());
            System.out.println("Cheltuieli fixe " + cheltuieliFixe());
            System.out.println("Total " + totalCheltuieli());
        }
    }

    @Override
    public void cautarePret(double x, double y) {
        if (pret() >= x && pret() <= y)
            afisare();
    }

    public void cautarePretCump(double x, double y) {
        if (!isInchiriere())
            cautarePret(x, y);
    }

    public void cautarePretInch(double x, double y) {
        if (isInchiriere())
            cautarePret(x, y);
    }

    public void depozitH(double value) {
        if (inaltime >= value)
            afisare();
    }

    @Override
    public void afisare_zona(int zona_cautata) {
        if (getZona() == zona_cautata)
            afisare();
    }

}
