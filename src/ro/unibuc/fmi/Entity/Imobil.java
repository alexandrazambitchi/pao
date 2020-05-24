package ro.unibuc.fmi.Entity;

public abstract class Imobil implements Comparable<Imobil> {
    private int id;
    private String adresa;
    private int zona;
    private int suprafata;
    private double pretMp;
    private boolean inchiriere;

    public Imobil(int id, String adresa, int zona, int suprafata, double pretMp, boolean inchiriere) {
        this.id = id;
        this.adresa = adresa;
        this.zona = zona;
        this.suprafata = suprafata;
        this.pretMp = pretMp;
        this.inchiriere = inchiriere;
    }

    public Imobil() {
        id = -1;
        adresa = "";
        zona = 0;
        suprafata = 0;
        pretMp = 0;
        inchiriere = false;
    }

    public double getPretMp() {
        return pretMp;
    }

    public void setPretMp(double pretMp) {
        this.pretMp = pretMp;
    }

    public int getId() {
        return id;
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

    public boolean isInchiriere() {
        return inchiriere;
    }

    public abstract void afisare();

    public abstract void cautarePret(double x, double y);

    @Override
    public int compareTo(Imobil o) {
        return this.zona - o.getZona();
    }

    public abstract void afisare_zona(int zona_cautata);
}
