package ro.unibuc.fmi;

public class DepozitInch extends Imobil implements Inchiriere {
    private double inaltime, pretMp;

    public DepozitInch(String adresa, int zona, int suprafata, double inaltime, double pretMp) {
        super(adresa, zona, suprafata);
        this.inaltime = inaltime;
        this.pretMp = pretMp;
    }

    @Override
    public double pretLuna() {
        if (inaltime > 2.5)
            return (pretMp * getSuprafata() * 1.1)/12;
        return (pretMp * getSuprafata())/12;
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
        System.out.println("Depozitul de inchiriat se afla in zona " + getZona() + ", " + getAdresa());
        System.out.println("Are suprafata " + getSuprafata() + "mp si inaltimea " + inaltime + "m");
        System.out.println("Pret pe luna " + pretLuna());
        System.out.println("Cheltuieli fixe " + cheltuieliFixe());
        System.out.println("Total " + totalCheltuieli());
    }

    @Override
    public void afisare_zona(int value) {
        if (value == getZona())
            afisare();
    }

    @Override
    public void cautarePret(double x, double y) {
        if (totalCheltuieli() >= x && totalCheltuieli() <= y)
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
        if (pretLuna() >= x && pretLuna() <= y)
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
        if (inaltime >= value)
            afisare();
    }

    @Override
    public void birouriEtaje(int value) {
    }

    @Override
    public void terenMare(int value) {
    }
}
