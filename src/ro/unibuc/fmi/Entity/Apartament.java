package ro.unibuc.fmi.Entity;

public class Apartament extends Imobil implements Vanzare, Inchiriere {
    private int etaj;
    private int nrBai;
    private int nrCamere;
    private boolean terasa;

    public Apartament() {
    }

    public Apartament(int id, String adresa, int zona, int suprafata, double pretMp, boolean inchiriere, int etaj, int nrBai, int nrCamere, boolean terasa) {
        super(id, adresa, zona, suprafata, pretMp, inchiriere);
        this.etaj = etaj;
        this.nrBai = nrBai;
        this.nrCamere = nrCamere;
        this.terasa = terasa;
    }

    public int getEtaj() {
        return etaj;
    }

    public int getNrBai() {
        return nrBai;
    }

    public int getNrCamere() {
        return nrCamere;
    }

    public boolean isTerasa() {
        return terasa;
    }

    @Override
    public double pret() {
        return getPretMp() * nrCamere * getSuprafata();
    }

    @Override
    public double pretLuna() {
        double suma = 0;
        if (getZona() == 1) {
            if (terasa)
                suma = getPretMp() * getSuprafata() * 1.2;
            else
                suma = getPretMp() * getSuprafata();
        }
        if (getZona() == 2) {
            if (terasa)
                suma = getPretMp() * getSuprafata() * 1.1;
            else
                suma = getPretMp() * getSuprafata();
        }
        if (getZona() == 3) {
            suma = getPretMp() * getSuprafata();
        }
        return suma / 12;
    }

    @Override
    public double cheltuieliFixe() {
        double suma = 0;
        if (getZona() == 1) {
            if (terasa)
                suma = (nrCamere + nrBai) * 1.5 + 300;
            else
                suma = (nrCamere + nrBai) * 1.3 + 300;
        }
        if (getZona() == 2) {
            if (terasa)
                suma = (nrCamere + nrBai) * 1.4 + 200;
            else
                suma = (nrCamere + nrBai) * 1.2 + 200;
        }
        if (getZona() == 3) {
            if (terasa)
                suma = (nrCamere + nrBai) * 1.3 + 150;
            else
                suma = (nrCamere + nrBai) * 1.1 + 150;
        }
        return suma;
    }

    @Override
    public double totalCheltuieli() {
        return pretLuna() + cheltuieliFixe();
    }

    @Override
    public void afisare() {
        if (!isInchiriere()) {
            System.out.println("Apartamentul de vanzare se afla in zona " + getZona() + ", " + getAdresa() + ", la etajul " + etaj);
            System.out.println("Are suprafata " + getSuprafata() + "mp, impartita in " + nrCamere + " camere si " + nrBai + " bai");
            if (terasa)
                System.out.println("Dispune de terasa");
            else System.out.println("Nu dispune de terasa");
            System.out.println("Pret: " + pret());
        } else {
            System.out.println("Apartamentul de inchiriat se afla in zona " + getZona() + ", " + getAdresa() + ", la etajul " + etaj);
            System.out.println("Are suprafata " + getSuprafata() + "mp, impartita in " + nrCamere + " camere si " + nrBai + " bai");
            if (terasa)
                System.out.println("Dispune de terasa");
            else System.out.println("Nu dispune de terasa");
            System.out.println("Pret chirie pe luna: " + pretLuna());
            System.out.println("Cheltuieli fixe: " + cheltuieliFixe());
            System.out.println("Total " + totalCheltuieli());
        }

    }

    @Override
    public void cautarePret(double x, double y) {
        if (!isInchiriere())
            cautarePretCump(x, y);
        else cautarePretInch(x, y);
    }

    @Override
    public void afisare_zona(int zona_cautata) {
        if (getZona() == zona_cautata)
            afisare();
    }

    public void apartamentEtaj(int value) {
        if (etaj >= value)
            afisare();
    }

    public void cautarePretCump(double x, double y) {
        if (!isInchiriere()) {
            if (pret() >= x && pret() <= y)
                afisare();
        }
    }

    public void cautarePretInch(double x, double y) {
        if (isInchiriere()) {
            if (pretLuna() >= x && pretLuna() <= y)
                afisare();
        }
    }

}
