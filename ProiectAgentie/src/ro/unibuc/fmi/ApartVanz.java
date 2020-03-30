package ro.unibuc.fmi;

public class ApartVanz extends Imobil implements Vanzare {
    private int etaj, nrBai, nrCamere;
    private boolean terasa;
    private double pretMp;

    public ApartVanz(String adresa, int zona, int suprafata, int etaj, int nrBai, int nrCamere, boolean terasa, double pretMp) {
        super(adresa, zona, suprafata);
        this.etaj = etaj;
        this.nrBai = nrBai;
        this.nrCamere = nrCamere;
        this.terasa = terasa;
        this.pretMp = pretMp;
    }

    @Override
    public double pret() {
        return pretMp * nrCamere * getSuprafata();
    }

    @Override
    public void afisare() {
        System.out.println("Apartamentul de vanzare se afla in zona " + getZona() + ", " + getAdresa() + ", la etajul " + etaj);
        System.out.println("Are suprafata " + getSuprafata() + "mp, impartita in " + nrCamere + " camere si " + nrBai + " bai");
        if (terasa)
            System.out.println("Dispune de terasa");
        else System.out.println("Nu dispune de terasa");
        System.out.println("Pret: " + pret());
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
        if (etaj >= value)
            afisare();
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
        if (terasa && getZona() == value)
            afisare();
    }

    @Override
    public void depozitH(double value) {
    }

    @Override
    public void birouriEtaje(int value) {
    }

    @Override
    public void terenMare(int value) {
    }
}
