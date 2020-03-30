package ro.unibuc.fmi;

public abstract class Imobil implements Comparable<Imobil>{
    private String adresa;
    private int zona, suprafata;

    public Imobil(String adresa, int zona, int suprafata) {
        this.adresa = adresa;
        this.zona = zona;
        this.suprafata = suprafata;
    }

    public String getAdresa() {
        return adresa;
    }

    public int getZona() {
        return zona;
    }

    public int getSuprafata() {
        return suprafata;
    }

    public abstract void afisare();

    public abstract void afisare_zona(int value);

    public abstract void cautarePret(double x, double y);

    public abstract void cautarePretCump(double x, double y);

    public abstract void cautarePretInch(double x, double y);

    public abstract void CaseGradinasiPiscina();

    public abstract void apartamentEtaj(int value);

    public abstract void casaVanzZona(int value);

    public abstract void apartTerasaZona(int value);

    public abstract void depozitH(double value);

    public abstract void birouriEtaje(int value);

    public abstract void terenMare(int value);

    @Override
    public int compareTo(Imobil o) {
        return this.zona - o.getZona();
    }
}
