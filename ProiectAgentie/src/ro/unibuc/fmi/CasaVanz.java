package ro.unibuc.fmi;

public class CasaVanz extends Imobil implements Vanzare {
    private int nrNivele, nrCamere;
    private boolean piscina, gradina;
    private double pretMP;

    public CasaVanz(String adresa, int zona, int suprafata, int nrNivele, int nrCamere, boolean piscina, boolean gradina, double pretMP) {
        super(adresa, zona, suprafata);
        this.nrNivele = nrNivele;
        this.nrCamere = nrCamere;
        this.piscina = piscina;
        this.gradina = gradina;
        this.pretMP = pretMP;
    }

    @Override
    public double pret() {
        double comision = 1;
        if (piscina && gradina)
            comision = 1.3;
        else if (piscina)
            comision = 1.2;
        else if (gradina)
            comision = 1.1;
        return getZona() * pretMP * nrCamere * getSuprafata() * comision;

    }

    @Override
    public void afisare() {
        System.out.println("Casa de vanzare se afla in zona " + getZona() + ", " + getAdresa());
        System.out.println("Are suprafata " + getSuprafata() + "mp, impartita in " + nrCamere + " camere si " + nrNivele + " etaje");
        if (piscina)
            System.out.println("Dispune de piscina");
        else System.out.println("Nu dispune de piscina");
        if (gradina)
            System.out.println("Dispune de gradina");
        else System.out.println("Nu dispune de gradina");
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
        if (gradina && piscina)
            afisare();
    }

    @Override
    public void apartamentEtaj(int value) {
    }

    @Override
    public void cautarePretInch(double x, double y) {
    }

    @Override
    public void casaVanzZona(int value) {
        if (getZona() == value)
            afisare();
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
    public void cautarePretCump(double x, double y) {
        cautarePret(x, y);
    }

    @Override
    public void terenMare(int value) {
    }
}
