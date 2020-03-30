package ro.unibuc.fmi;

public class Teren extends Imobil implements Vanzare {
    private double pretMp;

    public Teren(String adresa, int zona, int suprafata, double pretMp) {
        super(adresa, zona, suprafata);
        this.pretMp = pretMp;
    }

    @Override
    public double pret() {
        if(getZona()==1)
            return pretMp * getSuprafata() * 1.3;
        if(getZona()==2)
            return pretMp * getSuprafata() * 1.1;
        return pretMp * getSuprafata();
    }

    @Override
    public void afisare() {
        System.out.println("Terenul se afla in zona " + getZona() + ", " + getAdresa());
        System.out.println("Are suprafata " + getSuprafata() + "mp");
        System.out.println("Pret "+ pret());
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
    }

    @Override
    public void birouriEtaje(int value) {
    }

    @Override
    public void terenMare(int value) {
        if (getSuprafata() >= value)
            afisare();
    }

}
