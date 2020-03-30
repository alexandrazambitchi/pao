package ro.unibuc.fmi;

public class DepozitVanz extends Imobil implements Vanzare {
    private double inaltime, pretMp;

    public DepozitVanz(String adresa, int zona, int suprafata, double inaltime, double pretMp) {
        super(adresa, zona, suprafata);
        this.inaltime = inaltime;
        this.pretMp = pretMp;
    }

    @Override
    public double pret() {
        if (inaltime > 2.5)
            return pretMp * getSuprafata() * 1.4;
        return pretMp * getSuprafata() * 1.2;
    }

    @Override
    public void afisare() {
        System.out.println("Depozitul de vanzare se afla in zona " + getZona() + ", " + getAdresa());
        System.out.println("Are suprafata " + getSuprafata() + "mp si inaltimea " + inaltime + "m");
        System.out.println("Pret " + pret());
    }

    @Override
    public void afisare_zona(int value) {
        if (value == getZona())
            afisare();
    }

    @Override
    public void cautarePret(double x, double y) {
        if (pret() >= x && pret() <= y)
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
        cautarePret(x, y);
    }

    @Override
    public void cautarePretInch(double x, double y) {
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
